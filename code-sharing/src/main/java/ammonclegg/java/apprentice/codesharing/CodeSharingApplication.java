package ammonclegg.java.apprentice.codesharing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


/**
 * @author ammonclegg on 9/7/18.
 */
@SpringBootApplication
public class CodeSharingApplication implements CommandLineRunner {
  private static final Logger LOGGER = LoggerFactory.getLogger(CodeSharingApplication.class);

  private static final String FILENAME = "code-sharing-example";
  private static final String COMPOSITION_FILENAME = FILENAME + "-composition";
  private static final String INHERITANCE_FILENAME = FILENAME + "-inheritance";
  private static final String STATIC_CALLS_FILENAME = FILENAME + "-static-calls";


  /**
   * Starts the project up.
   *
   * @param args a non-null String array of command line args.
   */
  public static void main(String[] args) {
    SpringApplication.run(CodeSharingApplication.class, args);
  }

  @Override
  @SuppressWarnings({"squid:S106", "squid:S1181"})
  public void run(String... args) {
    System.out.println("Writing to files via different mechanisms");

    Writer lineWriterComposition = new LineWriterComposition(COMPOSITION_FILENAME);
    System.out.println(String.format("Writing message to text file %s.txt", COMPOSITION_FILENAME));
    writeToFile(lineWriterComposition,"Hello world", "Ammon", "Joe");

    Writer lineWriterInherited = new LineWriterInherited(INHERITANCE_FILENAME);
    System.out.println(String.format("Writing message to text file %s.txt", INHERITANCE_FILENAME));
    writeToFile(lineWriterInherited,"Hello world", "Ammon", "Joe");

    Writer lineWriterStaticCalls = new LineWriterStaticCalls(STATIC_CALLS_FILENAME);
    System.out.println(String.format("Writing message to text file %s.txt", STATIC_CALLS_FILENAME));
    writeToFile(lineWriterStaticCalls,"Hello world", "Ammon", "Joe");

    Writer xmlWriterComposition = new XMLWriterComposition(COMPOSITION_FILENAME);
    System.out.println(String.format("Writing message to xml file %s.xml", COMPOSITION_FILENAME));
    writeToFile(xmlWriterComposition,"Hello world too", "Ammon", "Joe");

    Writer xmlWriterInherited = new XMLWriterInherited(INHERITANCE_FILENAME);
    System.out.println(String.format("Writing message to text file %s.txt", INHERITANCE_FILENAME));
    writeToFile(xmlWriterInherited,"Hello world", "Ammon", "Joe");

    Writer xmlWriterStaticCalls = new XMLWriterStaticCalls(STATIC_CALLS_FILENAME);
    System.out.println(String.format("Writing message to text file %s.txt", STATIC_CALLS_FILENAME));
    writeToFile(xmlWriterStaticCalls,"Hello world", "Ammon", "Joe");
  }

  private void writeToFile(Writer writer, String message, String sender, String recipient) {
    try {
      writer.writeMessage(message, sender, recipient);
    }
    catch (IOException e) {
      LOGGER.error("Encountered error while writing to file", e);
    }
  }
}
