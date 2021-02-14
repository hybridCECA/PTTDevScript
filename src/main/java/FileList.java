import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileList {
    private List<String> fullFilenames;
    private List<String> filenames;

    public FileList(String configFilename) throws IOException {
        // Read in file names
        File configFile = new File(configFilename);
        BufferedReader reader = new BufferedReader(new FileReader(configFile));
        fullFilenames = reader.lines()
                .map(filename -> filename.replaceFirst("ftp://.*?/", ""))
                .collect(Collectors.toList());
        reader.close();

        // Parse filenames without absolute path
        filenames = fullFilenames.stream()
                .map(filename -> filename.replaceFirst(".*/", ""))
                .collect(Collectors.toList());
    }

    public List<String> getFilenames() {
        return filenames;
    }

    public List<String> getFullFilenames() {
        return fullFilenames;
    }
}
