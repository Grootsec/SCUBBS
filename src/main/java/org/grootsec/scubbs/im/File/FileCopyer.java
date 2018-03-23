package org.grootsec.scubbs.im.File;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyer {
    static boolean copyFile(File tempfile, String filepath) {
        if (CopyFile(tempfile, filepath)) return false;
        return true;
    }

    static boolean CopyFile(File tempfile, String filepath) {
        try {
            java.nio.file.Path source = Paths.get(tempfile.getPath());
            java.nio.file.Path destination = Paths.get(filepath);

            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }
}
