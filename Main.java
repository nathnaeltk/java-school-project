import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Start Your Registration Here");
            System.out.println();

            Student student1 = new Student();
            student1.getProfile();
            student1.getBatch();

            System.out.println(" Registered Successfully");
            System.out.println();
            student1.display();

            // Write student information and courses to a single file
            FileWriter slipFile = new FileWriter("slip.txt");
            slipFile.write("Student Information:\n");
            slipFile.write("Name: " + student1.FName + " " + student1.LName + "\n");
            slipFile.write("ID: " + student1.Id + "\n");
            slipFile.write("Department: " + student1.Dept + "\n");
            slipFile.write("Year: " + student1.Year + "\n");
            slipFile.write("Semester: " + student1.semester + "\n\n");
            slipFile.write(student1.getCourseDetails());
            slipFile.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

class Student extends Courses {
    Scanner input = new Scanner(System.in);
    public String Id;
    public String FName;
    public String LName;
    public String Dept;
    public int Year;
    public int semester;

    public void getProfile() {
        try {
            System.out.print("Enter your first name: ");
            FName = input.next();
            System.out.print("Enter your last name: ");
            LName = input.next();
            System.out.print("Enter your ID number: ");
            Id = input.next();
            System.out.print("Enter your Department: ");
            Dept = input.next();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please enter the correct data type.");
            input.nextLine(); // Clear the input buffer
            getProfile(); // Re-attempt input
        }
    }

    public void getBatch() {
        try {
            System.out.print("Enter your current year:  ");
            Year = input.nextInt();
            do {
                System.out.print("Enter your current semester: ");
                semester = input.nextInt();
                if (semester != 1 && semester != 2) {
                    System.out.println("Invalid Semester input");
                }
            } while (semester != 2 && semester != 1);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please enter the correct data type.");
            input.nextLine(); // Clear the input buffer
            getBatch(); // Re-attempt input
        }
    }

    public String getCourseDetails() {
        String[][] courses = {}; // Initialize courses to an empty array
        String semesterInfo = "";

        if (Year == 1 && semester == 1) {
            courses = secondYearSecondSemester;
            semesterInfo = "Second Year Second Semester";
        } else if (Year == 1 && semester == 2) {
            courses = ThirdYearFirstSemester;
            semesterInfo = "Third Year First Semester";
        } else if (Year == 2 && semester == 1) {
            courses = ThirdYearSecondSemester;
            semesterInfo = "Third Year Second Semester";
        } else if (Year == 2 && semester == 2) {
            courses = FourthYearFirstSemester;
            semesterInfo = "Fourth Year First Semester";
        } else if (Year == 3 && semester == 1) {
            courses = FifthYearFirstSemester;
            semesterInfo = "Fifth Year First Semester";
        } else if (Year == 3 && semester == 2) {
            courses = FifthYearSecondSemester;
            semesterInfo = "Fifth Year Second Semester";
        } else if (Year == 4 && semester == 1) {
            courses = secondYearSecondSemester;
            semesterInfo = "Second Year Second Semester";
        } else if (Year == 4 && semester == 2) {
            courses = ThirdYearFirstSemester;
            semesterInfo = "Third Year First Semester";
        } else if (Year == 5 && semester == 1) {
            courses = ThirdYearSecondSemester;
            semesterInfo = "Third Year Second Semester";
        } else if (Year == 5 && semester == 2) {
            courses = FourthYearFirstSemester;
            semesterInfo = "Fourth Year First Semester";
        }

        StringBuilder result = new StringBuilder();
        result.append("Courses Information:\n");
        result.append(semesterInfo).append(":\n");
        for (String[] course : courses) {
            result.append(Arrays.toString(course)).append("\n");
        }
        return result.toString();
    }

    public void display() {
        System.out.println("Welcome " + FName + " " + LName);
        System.out.println("You are registered for " + Year + " year " + semester + " semester ");
        System.out.println("Courses Information has been saved to 'slip.txt'");
    }
}

class Courses {
    public static String[][] secondYearSecondSemester = {
            { "OOP  ", "  3 Credit Hours  ", "   Abenet" },
            { "COA  ", "  3 Credit Hours  ", "   Dawit" },
            { "OS   ", "  4 Credit Hours  ", "   Markos" },
            { "SP   ", "  3 Credit Hours  ", "   Matiyas" },
            { "NT   ", "  4 Credit Hours  ", "   Yonas" }
    };
    public static String[][] ThirdYearFirstSemester = {
            { "Software Design ", "3 Credit Hours", "   Makeda " },
            { "FSE ", "    3 Credit Hours", "   Liya " },
            { "Algorithms ", "    4 Credit Hours", "   Aster " },
            { "Python Programming ", " 3 Credit Hours", "   Senait " },
            { "Database Systems", "4 Credit Hours", "   Bethlehem " }
    };
    public static String[][] ThirdYearSecondSemester = {
            { "Cybersecurity... ", "  3 Credit Hours", "    Tsion " },
            { "Web Development ", "            3 Credit Hours", "    Selam " },
            { "Android App Development ", "    4 Credit Hours", "    Kidist " },
            { "Research Methods ", "       3 Credit Hours", "    Tizita " },
            { "Advanced Data Structures ", "4 Credit Hours", "    Rahel " }
    };
    public static String[][] FourthYearFirstSemester = {
            { "Small Sensors ", "     3 Credit Hours", "   Getaneh " },
            { "Anthropology ", "      3 Credit Hours", "   Alemayehu " },
            { "Entrepreneurship ", "  4 Credit Hours", "   Temesgen " },
            { "Deep Learning ", "     3 Credit Hours", "   Dawit " },
            { "Artificial Intelligence... ", "4 Credit Hours", "   Abel " }
    };
    public static String[][] FifthYearFirstSemester = {
            { "Virtual Reality ", "3 Credit Hours", "     Yared " },
            { "Machine Learning...", " 3 Credit Hours", "     Abiy " },
            { "Civic Engagement ", "          4 Credit Hours", "     Mesfin " },
            { "Emerging Technologies...", "3 Credit Hours", "     Henok " },
            { "Robotics", "        4 Credit Hours", "     Betelhem " }
    };
    public static String[][] FifthYearSecondSemester = {
            { "Operating System ", " 3 Credit Hours", "    Natnael " },
            { "Web Frameworks ", "   3 Credit Hours", "    Abel " },
            { "Economics ", "        4 Credit Hours", "    Biruk " },
            { "Digitization ", "     3 Credit Hours", "    Samuel " },
            { "Augmented Reality ", "4 Credit Hours", "    Daniel " }
    };

};
