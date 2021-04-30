package chaptor.ioBasednetwork.tcp.chatServer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServerExample extends Application {
    ExecutorService executorService;
    ServerSocket serverSocket;
    List<Client> connections = new Vector<Client>();

    void startServer(){
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try{
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 5001));
        } catch (Exception e) {
            if(!serverSocket.isClosed()){
                stopServer();
            }
            return;
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Platform.runLater(() ->{

                });
                while(true) {
                    try {
                        Socket socket = serverSocket.accept();
                        String message = "[연결 수락: " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
                        Platform.runLater(()->{});

                        Client client = new Client(socket);
                        connections.add(client);
                        Platform.runLater(()->{});
                    }
                    catch (Exception e) {
                        if(!serverSocket.isClosed()) {stopServer();}
                        break;
                    }
                }
            }
        };

        executorService.submit(runnable);
    }
    void stopServer(){
        try {
            Iterator<Client> iterator = connections.iterator();
            while(iterator.hasNext()) {
                Client client = iterator.next();
                client.socket.close();
                iterator.remove();
            }
            if(serverSocket!=null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            if(executorService!=null && !executorService.isShutdown()) {
                executorService.shutdown();
            }
            Platform.runLater(()->{});
        } catch (Exception e){}
    }


    class Client{
        Socket socket;

        Client(Socket socket) {
            this.socket = socket;
            receive();
        }
        void receive() {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try{
                        while(true) {
                            byte[] byteArr = new byte[100];
                            InputStream inputStream = socket.getInputStream();

                            int readByteCount = inputStream.read(byteArr);

                            if(readByteCount == -1) {throw new IOException(); }

                            String message = "[요청 처리: " + socket.getRemoteSocketAddress() +
                                    ": " + Thread.currentThread().getName() + "]";
                            Platform.runLater(() -> {});

                            String data = new String(byteArr, 0, readByteCount, "UTF-8");
                            for(Client client : connections) {
                                client.send(data);
                            }
                        }
                    } catch (Exception e){
                        try {
                            connections.remove(Client.this);
                            String message = "[클라이언트 통신 안됨: " +
                                    socket.getRemoteSocketAddress() +
                                    ": " + Thread.currentThread().getName() + "]";
                            Platform.runLater(()->{});
                            socket.close();
                        } catch (IOException e2) {}
                    }
                }
            };
            executorService.submit(runnable);
        }
        void send(String data) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        byte[] byteArr = data.getBytes("UTF-8");
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write(byteArr);
                        outputStream.flush();
                    } catch (Exception e) {
                        try {
                            String message = "[클라이언트 통신 안됨: " +
                                    socket.getRemoteSocketAddress() + ": " +
                                    Thread.currentThread().getName()+ "]";
                            Platform.runLater(()->{});
                            connections.remove(Client.this);
                            socket.close();
                        } catch (IOException e2) {}
                    }
                }
            };
            executorService.submit(runnable);
        }
    }

    TextArea txtDisplay;
    Button btnStartStop;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(500, 300);

        txtDisplay = new TextArea();
        txtDisplay.setEditable(false);
        BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
        root.setCenter(txtDisplay);

        btnStartStop = new Button("start");
        btnStartStop.setPrefHeight(30);
        btnStartStop.setMaxWidth(Double.MAX_VALUE);
        btnStartStop.setOnAction(e->{
            if(btnStartStop.getText().equals("start")) {
                startServer();
            } else if(btnStartStop.getText().equals("stop")) {
                stopServer();
            }
        });
        root.setBottom(btnStartStop);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("app.css").toString());
        stage.setScene(scene);
        stage.setTitle("Server");
        stage.setOnCloseRequest(event->stopServer());
        stage.show();
    }

    void displayText(String text) {
        txtDisplay.appendText(text + "\n");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
