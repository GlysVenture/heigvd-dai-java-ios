package ch.heigvd.ios.binary;

import ch.heigvd.ios.Writable;

import java.io.*;

/**
 * A class that writes binary files. This implementation writes the file using a buffered output
 * stream. It manages the file output stream properly with a try-with-resources block.
 */
public class BufferedBinaryFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
      try (OutputStream out = new BufferedOutputStream(new FileOutputStream(filename))) {
          while(sizeInBytes > 0) {
              out.write(42);
              sizeInBytes--;
          }
      } catch (IOException e) {
          System.err.println("Exception: " + e);
      }
  }
}
