package ammonclegg.java.apprentice.argumentmanipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ammonclegg on 8/2/19.
 */
@SpringBootApplication
public class ArgumentManipulationApplication implements CommandLineRunner {
  private static final Logger LOGGER = LoggerFactory.getLogger(ArgumentManipulationApplication.class);

  @Autowired
  ArgumentManipulator argumentManipulator;

  /**
   * Starts the project up.
   *
   * @param args a non-null String array of command line args.
   */
  public static void main(String[] args) {
    SpringApplication.run(ArgumentManipulationApplication.class, args);
  }

  @Override
  public void run(String... args) {
    System.out.println("Creating Integer foo with a value of 8");
    Integer foo = 8;
    System.out.println("foo: " + foo);
    System.out.println("Running updateInteger on foo");
    argumentManipulator.updateInteger(foo);
    System.out.println("foo after updateInteger in main is " + foo);

    System.out.println("Creating primative bar with a value of 7");
    int bar = 7;
    System.out.println("bar: " + bar);
    System.out.println("Running updatePrimative on bar");
    argumentManipulator.updatePrimative(bar);
    System.out.println("bar after updateInteger in main is " + bar);

    System.out.println("Showing manipulation of data for a final reference, by calling .add on an arrayList");
    System.out.println("Creating ArrayList with a value of [14]");
    List<Integer> list = new ArrayList<>();
    list.add(14);
    System.out.println("list: " + list);
    System.out.println("Running updateFinalIntegerList on list");
    argumentManipulator.updateFinalIntegerList(list);
    System.out.println("list after updateFinalIntegerList in main is " + list);
  }
}
