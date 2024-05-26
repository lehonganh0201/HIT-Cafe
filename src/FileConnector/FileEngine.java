package FileConnector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;

public class FileEngine {
    
    private static final Logger LOGGER = Logger.getLogger(FileEngine.class.getName());
    
    public void writeToFile(Map<?, ?> map, File file) {
        try (OutputStream os = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(map);
        } catch (FileNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Không tìm thấy file: " + file, ex);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi đọc ghi file: " + file, ex);
        }
    }
    
    public Map<?, ?> readFile(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Map<?, ?>) ois.readObject();
        } catch (FileNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Không tìm thấy file: " + file, ex);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi đọc ghi file: " + file, ex);
        } catch (ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Không tìm thấy lớp khi đọc file: " + file, ex);
        }
        return null;
    }
}
