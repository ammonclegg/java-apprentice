package ammonclegg.java.apprentice.filesorter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ammonclegg on 8/3/18.
 */
@Service
public class FileSorterService {
  private static final Logger LOGGER = LoggerFactory.getLogger(FileSorterService.class);

  private List<String> readLines(String inputFileName) {
    List<String> lines = new LinkedList<>();
    try(BufferedReader inputFile = new BufferedReader(new FileReader(inputFileName))) {
      String line = inputFile.readLine();
      while (line != null) {
        lines.add(line);
        line = inputFile.readLine();
      }
    }
    catch(IOException e) {
      LOGGER.error("Encountered error reading from file.", e);
    }
    return lines;
  }

  private void outputLines(String outputFileName, List<String> lines) {
    try(BufferedWriter outputFile = new BufferedWriter(new FileWriter(outputFileName, false))) {
      for(String outputLines: lines) {
          outputFile.write(outputLines);
          outputFile.newLine();
      }
    }
    catch(IOException e) {
      LOGGER.error("Encountered error writing to file.", e);
    }
  }

  public void sortFile(String inputFileName, String outputFileName, Order ordering) {

    List<String> lines = readLines(inputFileName);

    if (Order.REVERSE.equals(ordering)) {
      lines.sort(Collections.reverseOrder());
    }
    else {
      Collections.sort(lines);
    }

    outputLines(outputFileName, lines);
  }
}
