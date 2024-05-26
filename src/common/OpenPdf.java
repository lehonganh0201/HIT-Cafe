package common;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class OpenPdf {
    public static void openById(String id) {
        try {
            String filePath = "D:\\" + id + ".pdf";
            File file = new File(filePath);

            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(null, "File does not exist");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
