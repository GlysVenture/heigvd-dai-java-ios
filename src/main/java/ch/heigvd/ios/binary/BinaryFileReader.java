package ch.heigvd.ios.binary;

import ch.heigvd.ios.Readable;

import java.io.*;

/**
 * A class that reads binary files. This implementation reads the file byte per byte. It manages the
 * file input stream properly with a try-catch-finally block.
 */
public class BinaryFileReader implements Readable {

  @Override
  public void read(String filename) {
    InputStream in = null;

    try {
        in = new FileInputStream(filename);
        while (in.read() != -1);
    } catch (IOException e) {
        System.err.println("Exception: " + e);
    } finally {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                System.err.println("Error closing file: " + filename);
            }
        }
    }
  }
}
