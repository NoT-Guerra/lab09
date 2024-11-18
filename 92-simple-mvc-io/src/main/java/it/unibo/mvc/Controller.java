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
    public void SetFile(final File file){
        if (file.exists() && file.isFile()) {
            fileopen = file;
        } else {
            throw new IllegalArgumentException("file does not exists");
        }
    }
    public  File CurrentFile(){
    return fileopen;
    }
    public String PathFile() {
        return fileopen.getAbsolutePath();
    }
    public void SaveString(String Scritta) throws IOException {
         try (PrintStream ps = new PrintStream(PathFile(), StandardCharsets.UTF_8)) {
                    ps.println(Scritta);
                }
};
}