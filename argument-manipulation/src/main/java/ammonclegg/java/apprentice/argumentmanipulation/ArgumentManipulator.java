package ammonclegg.java.apprentice.argumentmanipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ammonclegg on 8/2/19.
 */
@Component
public class ArgumentManipulator {
  private static final Logger LOGGER = LoggerFactory.getLogger(ArgumentManipulator.class);

  public void updateInteger(Integer integer) {
    System.out.println("Integer as it came into updateInteger: " + integer);
    System.out.println("Adding 2 to integer");
    integer = integer + 2;
    System.out.println("Integer is now " + integer);
    System.out.println("Assign integer to a new Integer with value 4");
    integer = 4;
    System.out.println("Integer in updateInteger: " + integer);
  }

  public void updateFinalIntegerList(final List<Integer> integerList) {
    System.out.println("integerList as it came into updateInteger: " + integerList);
    System.out.println("Unable to modify integer via assignment");
    System.out.println("Calling add on integer list to add the value 7");
    integerList.add(7);
    System.out.println("integerList is now " + integerList);
//    integerList = new ArrayList<>(); Assignment is not allowed for final.
    System.out.println("integerList in updateFinalIntegerList: " + integerList);
  }

  public void updatePrimative(int integer) {
    System.out.println("Integer as it came into updatePrimative: " + integer);
    System.out.println("Adding 2 to integer");
    integer = integer + 2;
    System.out.println("Integer is now " + integer);
    System.out.println("Assign integer to a new Integer with value 4");
    integer = 4;
    System.out.println("Integer in updatePrimative: " + integer);
  }
}
