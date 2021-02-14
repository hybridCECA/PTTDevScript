import java.io.*;
import java.util.List;
import org.json.JSONObject;

public class FileManager {
    static String executable;
    static String url;

    public static void readConfig(String configFilename) throws IOException {
        String configContent = readFromFile(configFilename);
        JSONObject config = new JSONObject(configContent);


        executable = config.getString("executable");
        url = config.getString("url");
    }

    private static String readFromFile(String filename) throws IOException {
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        reader.lines().forEach(builder::append);
        reader.close();

        return builder.toString();
    }

    public static void executeFtpCommand(List<String> commands) throws Exception {
        ProcessBuilder builder = new ProcessBuilder("\"" + executable + "\"",
                "/command",
                "\"open " + url + "\"",
                String.join(" ", commands),
                "\"exit\""
                );
        builder.inheritIO();
        builder.start().waitFor();
    }
}
