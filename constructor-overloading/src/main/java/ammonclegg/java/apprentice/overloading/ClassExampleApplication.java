package ammonclegg.java.apprentice.overloading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ammonclegg on 8/3/18.
 */
@SpringBootApplication
public class ClassExampleApplication implements CommandLineRunner {
  private static final Logger LOGGER = LoggerFactory.getLogger(ClassExampleApplication.class);

  private static final String FIRST_STUDENT_ID = "i12345";
  private static final String SECOND_STUDENT_ID = "i98473";
  private static final String THIRD_STUDENT_ID = "i37483";
  private static final String FOURTH_STUDENT_ID = "i89372";

  /**
   * Starts the project up.
   *
   * @param args a non-null String array of command line args.
   */
  public static void main(String[] args)  {
    SpringApplication.run(ClassExampleApplication.class, args);
  }

  @Override
  @SuppressWarnings({"squid:S106", "squid:S1181"})
  public void run(String... args) {
    List<Student> students = new ArrayList<>();

    System.out.println("Creating a class of students");

    System.out.println(String.format("First a default student with id=%s", FIRST_STUDENT_ID));

    students.add(new Student(FIRST_STUDENT_ID));

    System.out.println(String.format("And now a student named Jessy with id=%s", SECOND_STUDENT_ID));
    students.add(new Student(SECOND_STUDENT_ID, "Jessy"));

    System.out.println(String.format("And now a student named Fred with id=%s, who is 26 years old.", THIRD_STUDENT_ID));
    students.add(new Student(THIRD_STUDENT_ID, "Fred", 26));


    System.out.println(String.format("And now a student named George with id=%s, who is 29 years old with a gpa of 1.2", FOURTH_STUDENT_ID));
    students.add(new Student(FOURTH_STUDENT_ID, "George", 29, 1.2));

    System.out.println("Outputting students");
    System.out.println(students);

  }
}
