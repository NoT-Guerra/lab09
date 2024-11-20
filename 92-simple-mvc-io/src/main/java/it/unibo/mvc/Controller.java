package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String HOME = System.getProperty("user.home"); 
    private static final String DEFAULT_FILE = "output.txt";
    private File fileopen = new File(HOME + File.separator + DEFAULT_FILE);
    /**
      *@param file
    */
    public void setFile(final File file) {
        if (file.exists() && file.isFile()) {
            fileopen = file;
        } else {
            throw new IllegalArgumentException("file does not exists");
        }
    }
    /**
     * @return fileopen
     */
    public  File currentFile() {
    return fileopen;
    }
    /**
     * @return fileopen
     */
    public String pathFile() {
        return fileopen.getAbsolutePath();
    }
    /**
     * @param scritta
     */
    public void saveString(final String scritta) throws IOException {
         try (PrintStream ps = new PrintStream(pathFile(), StandardCharsets.UTF_8)) {
                    ps.println(scritta);
                }
            }
}
