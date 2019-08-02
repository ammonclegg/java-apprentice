package ammonclegg.java.apprentice.codesharing;

import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author ammonclegg on 9/7/18.
 */
public class XMLWriterStaticCalls implements Writer {
  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(XMLWriterStaticCalls.class);
  private String filename;

  public XMLWriterStaticCalls(String filename) {
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
    LOGGER.info("Writing to xml file {} using static calls", filename);
    FileOpener.writeToFileStatic(filename, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    FileOpener.appendToFileStatic(filename, "<message>");
    FileOpener.appendToFileStatic(filename, "\t<to>" + recipient + "</to>");
    FileOpener.appendToFileStatic(filename, "\t<from>" + sender + "</from>");
    FileOpener.appendToFileStatic(filename, "\t<body>" + message + "</body>");
    FileOpener.appendToFileStatic(filename, "</message>");
  }
}
