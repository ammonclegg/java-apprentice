package ammonclegg.java.apprentice.codesharing;

import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author ammonclegg on 9/7/18.
 */
public class XMLWriterComposition implements Writer {
  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(XMLWriterComposition.class);
  private FileOpener fileOpener;
  private String filename;

  public XMLWriterComposition(String filename) {
    fileOpener = new FileOpener();
    if (filename.endsWith(".xml")) {
      this.filename = filename;
    }
    else {
      LOGGER.warn("File did not end in '.xml'. Appending '.xml'.");
      this.filename = filename + ".xml";
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
    LOGGER.info("Writing message to xml file using composition {}", filename);
    fileOpener.writeToFile(filename, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    fileOpener.appendToFile(filename, "<message>");
    fileOpener.appendToFile(filename, "\t<to>" + recipient + "</to>");
    fileOpener.appendToFile(filename, "\t<from>" + sender + "</from>");
    fileOpener.appendToFile(filename, "\t<body>" + message + "</body>");
    fileOpener.appendToFile(filename, "</message>");
  }
}
