package ch.heigvd.ios.binary;

import ch.heigvd.ios.Readable;

import java.io.*;

/**
 * A class that reads binary files. This implementation reads the file using a buffered input
 * stream. It manages the input stream and the buffered input stream properly with a
 * try-with-resources block.
 */
public class BufferedBinaryFileReader implements Readable {

  @Override
  public void read(String filename) {
      try (InputStream in = new BufferedInputStream(new FileInputStream(filename))) {
          while(in.read() != -1);
      } catch (IOException e) {
          System.err.println("Exception: " + e);
      }
  }
}
