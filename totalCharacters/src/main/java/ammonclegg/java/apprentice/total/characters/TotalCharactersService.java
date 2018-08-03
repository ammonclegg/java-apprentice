package ammonclegg.java.apprentice.total.characters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ammonclegg on 8/3/18.
 */
@Service
public class TotalCharactersService {
  private static final Logger LOGGER = LoggerFactory.getLogger(TotalCharactersService.class);
  private final int STRING_LENGTH = 1000;

  MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
  List<String> stringList = new LinkedList<>();
  int length = 0;
  long maxMemory = memoryBean.getHeapMemoryUsage().getMax();
  long usedMemory;

  public void run() {
    try {
      for (int i = 0; i < 50000000; i++) {
        stringList.add(getString());
        if (i % 10 == 0) {
          System.out.println("Current count: " + i);
        }
      }
    }
    catch(OutOfMemoryError e) {
      usedMemory = memoryBean.getHeapMemoryUsage().getUsed();
      length = stringList.size();
      stringList.clear();
      LOGGER.info("Ran out of memory, usedMemory={} maxMemory={} ", usedMemory, maxMemory, e);
      LOGGER.info("There were {} strings in the list.", length);
      LOGGER.info("There were {} characters in the list", length * STRING_LENGTH);
      LOGGER.info("Each string used approximately {} bytes of memory", (usedMemory/length));
      LOGGER.info("Each character used approximately {} bytes of memory", (usedMemory/(length*STRING_LENGTH)));
    }
    finally {
      stringList.clear();
    }
  }

  private String getString() {
    StringBuilder stringBuilder = new StringBuilder();
    for(int i = 0; i < STRING_LENGTH; i++) {
      stringBuilder.append('a');
    }
    return stringBuilder.toString();
  }
}
