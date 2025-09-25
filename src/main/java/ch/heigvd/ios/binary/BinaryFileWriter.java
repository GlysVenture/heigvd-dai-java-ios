package ch.heigvd.ios.binary;

import ch.heigvd.ios.Writable;

import java.io.*;

/**
 * A class that writes binary files. This implementation writes the file byte per byte. It manages
 * the file output stream properly with a try-catch-finally block.
 */
public class BinaryFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
      OutputStream out = null;

      try {
          out = new FileOutputStream(filename);
          while (sizeInBytes > 0) {
              out.write(42);
              sizeInBytes--;
          }
      } catch (IOException e) {
          System.err.println("Exception: " + e);
      } finally {
          if (out != null) {
              try {
                  out.close();
              } catch (IOException e) {
                  System.err.println("Error closing file: " + filename);
              }
          }
      }
  }
}
