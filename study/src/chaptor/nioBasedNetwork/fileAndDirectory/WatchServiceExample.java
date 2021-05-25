package chaptor.nioBasedNetwork.fileAndDirectory;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchService;

public class WatchServiceExample {
    // TODO: implement that after implementing PathExmaple
    class WatchServiceThread extends Thread {
        @Override
        public void run() {
            try {
                WatchService watchService = FileSystems.getDefault().newWatchService();
                Path directory = Paths.get("C:/Temp");
            } catch (Exception e) {

            }
        }
    }
}
