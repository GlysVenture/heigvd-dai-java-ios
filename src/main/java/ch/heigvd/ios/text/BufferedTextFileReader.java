package ch.heigvd.ios.text;

import ch.heigvd.ios.Readable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * A class that reads text files. This implementation reads the file using a buffered reader around
 * a file reader. It manages the reader and the buffered reader properly with a try-with-resources
 * block.
 */
public class BufferedTextFileReader implements Readable {

  @Override
  public void read(String filename) {
      try (BufferedReader in = new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8))) {
          while(in.read() != -1);
      } catch (IOException e) {
          System.err.println("Exception: " + e);
      }
  }
}
