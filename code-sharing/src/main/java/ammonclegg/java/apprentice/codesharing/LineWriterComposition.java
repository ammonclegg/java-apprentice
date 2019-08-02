package ammonclegg.java.apprentice.codesharing;

import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author ammonclegg on 9/7/18.
 */
public class LineWriterComposition implements Writer {
  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LineWriterComposition.class);

  private FileOpener fileOpener;
  private String filename;

  public LineWriterComposition(String filename) {
    fileOpener = new FileOpener();
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
    LOGGER.info("Writing message to file using composition {}", filename);
    fileOpener.writeToFile(filename, "To: " + recipient);
    fileOpener.appendToFile(filename, "From: " + sender);
    fileOpener.appendToFile(filename, message);
  }
}
