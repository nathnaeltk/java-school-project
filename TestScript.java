import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestScript {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Start Your Registration Here");
            System.out.println();

            Student student1 = new Student();

            simulateProfileInput(student1, input);

            simulateBatchInput(student1, input);

            System.out.println(" Registered Successfully");
            System.out.println();
            student1.display();

            simulateWritingToFile(student1);

            simulateReadingFromFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void simulateProfileInput(Student student, Scanner input) {
        System.out.print("Enter your first name: ");
        student.FName = input.next();
        System.out.print("Enter your last name: ");
        student.LName = input.next();
        System.out.print("Enter your ID number: ");
        student.Id = input.next();
        System.out.print("Enter your Department: ");
        student.Dept = input.next();
    }

    private static void simulateBatchInput(Student student, Scanner input) {
        System.out.print("Enter your current year: ");
        student.Year = input.nextInt();
        do {
            System.out.print("Enter your current semester: ");
            student.semester = input.nextInt();
            if (student.semester != 1 && student.semester != 2) {
                System.out.println("Invalid Semester input");
            }
        } while (student.semester != 2 && student.semester != 1);
    }

    private static void simulateWritingToFile(Student student) throws IOException {
        System.out.println("Simulating writing to file...");
        // Simulate writing student information to a file
        // (You can replace this with the actual file writing logic if needed)
        // For example:
        FileWriter slipFile = new FileWriter("slip.txt");
        slipFile.write("Student Information:\n");
        slipFile.write("Name: " + student.FName + " " + student.LName + "\n");
        slipFile.write("ID: " + student.Id + "\n");
        slipFile.write("Department: " + student.Dept + "\n");
        slipFile.write("Year: " + student.Year + "\n");
        slipFile.write("Semester: " + student.semester + "\n\n");
        slipFile.write(student.getCourseDetails());
        slipFile.close();
    }

    private static void simulateReadingFromFile() throws IOException {
        System.out.println("\nSimulating reading from file...");
        // Simulate reading content from the file
        // (You can replace this with the actual file reading logic if needed)
        BufferedReader reader = new BufferedReader(new FileReader("slip.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
