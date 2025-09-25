package ch.heigvd.ios.text;

import ch.heigvd.ios.Writable;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that writes text files. This implementation write the file byte per byte. It manages the
 * file writer properly with a try-catch-finally block.
 */
public class TextFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
      FileWriter out = null;

      try {
          out = new FileWriter(filename, StandardCharsets.UTF_8);
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
