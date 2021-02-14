import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UI {
    private static final String title = "PTT DevScript";
    private FileList list;

    public UI(FileList list) {
        this.list = list;
    }

    public void start() {
        String[] actions = {"Pull", "Push", "Backup", "Restore"};
        int result = JOptionPane.showOptionDialog(null, "Choose an action:", title, JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, actions, actions[0]);

        // Close if nothing chosen
        if (result == -1) {
            return;
        }

        int fileNum = fileWindow();

        // Close if no file chosen
        if (fileNum == -1) {
            return;
        }


        switch (result) {
            case 0:
                // Pull code
                break;
            case 1:
                // Push code
                break;
            case 2:
                // Backup code
                break;
            case 3:
                // Restore code
                break;
            default:
                // Close
                return;
        }
    }

    private int fileWindow() {
        List<String> options = new ArrayList<>(list.getFilenames());
        options.add("All files");
        return JOptionPane.showOptionDialog(null, "Choose a file", title, JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, options.toArray(), options.get(0));
    }
}
