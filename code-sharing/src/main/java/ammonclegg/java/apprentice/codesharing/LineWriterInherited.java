package ammonclegg.java.apprentice.codesharing;

import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author ammonclegg on 8/2/19.
 */
public class LineWriterInherited extends FileOpener implements Writer {
  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LineWriterComposition.class);
  private String filename;

  public LineWriterInherited(String filename) {
    if (filename.endsWith(".txt")) {
      this.filename = filename;
    }
    else {
      LOGGER.warn("File did not end in '.txt'. Appending '.txt'.");
      this.filename = filename + ".txt";
    }
  }

  /**
   * Writes a message to a file
   * @param message The message to write
   * @param sender The sender of the message
   * @param recipient The recipient of the message
   * @throws IOException
   */
  public void writeMessage(String message, String sender, String recipient) throws IOException {
    LOGGER.info("Writing to file {} using inheritance", filename);
    writeToFile(filename, "To: " + recipient);
    appendToFile(filename, "From: " + sender);
    appendToFile(filename, message);
  }
}
