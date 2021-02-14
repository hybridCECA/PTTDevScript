import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        FileManager.readConfig("config.txt");
        FileManager.executeFtpCommand(new ArrayList<>());
        System.out.println(FileManager.executable);
        System.out.println(FileManager.url);
        FileList fileList = new FileList("files.txt");
        UI ui = new UI(fileList);
        ui.start();
    }
}
