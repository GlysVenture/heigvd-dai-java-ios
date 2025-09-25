package ch.heigvd.ios.text;

import ch.heigvd.ios.Readable;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that reads text files. This implementation reads the file byte per byte. It manages the
 * file reader properly with a try-catch-finally block.
 */
public class TextFileReader implements Readable {

  @Override
  public void read(String filename) {
      FileReader in = null;

      try {
          in = new FileReader(filename, StandardCharsets.UTF_8);
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
