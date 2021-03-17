package chaptor.stream.kindsOfStream;

import chaptor.BasicExample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileContentExample extends BasicExample {
    @Override
    public void runWithException() throws Exception {
        Path path = Paths.get("C:\\Users\\bw\\IdeaProjects\\JavaStudy\\study\\src\\chaptor\\stream\\linedata.txt");
        Stream<String> stream;

        //Files.lines() 메소드 이용
        stream = Files.lines(path, Charset.defaultCharset());
        stream.forEach(System.out::println);
        System.out.println();

        //BufferedReader의 lines() 메소드 이용
        File file = path.toFile();
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        stream = br.lines();
        stream.forEach(System.out::println);
    }

    @Override
    public void run() {

    }
}
