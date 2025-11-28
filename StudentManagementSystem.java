import java.util.Scanner;

public class StudentManagementSystem { public static void main(String[]
args) { Scanner sc = new Scanner(System.in); int[] rollNo = new
int[100]; String[] name = new String[100]; float[] marks = new
float[100]; int count = 0;

        while (true) {
            System.out.println("\n*** Student Management System ***");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Update Student Information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (count >= 100) {
                        System.out.println("Database is full! Cannot add more students.");
                        break;
                    }
                    System.out.print("Enter Roll Number: ");
                    rollNo[count] = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name[count] = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    marks[count] = sc.nextFloat();

                    boolean duplicate = false;
                    for (int i = 0; i < count; i++) {
                        if (rollNo[i] == rollNo[count]) {
                            duplicate = true;
                            break;
                        }
                    }
                    if (duplicate) {
                        System.out.println("Error: Roll Number already exists!");
                    } else {
                        count++;
                        System.out.println("Student added successfully!");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No students in the database.");
                        break;
                    }
                    System.out.println("\nRoll No\tName\t\tMarks");
                    System.out.println("---------------------------------------");
                    for (int i = 0; i < count; i++) {
                        System.out.println(rollNo[i] + "\t" + name[i] + "\t\t" + marks[i]);
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    int searchRoll = sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (rollNo[i] == searchRoll) {
                            System.out.println("Student Found!");
                            System.out.println("Roll No: " + rollNo[i]);
                            System.out.println("Name: " + name[i]);
                            System.out.println("Marks: " + marks[i]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with Roll No " + searchRoll + " not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    int deleteRoll = sc.nextInt();
                    boolean deleted = false;
                    for (int i = 0; i < count; i++) {
                        if (rollNo[i] == deleteRoll) {
                            for (int j = i; j < count - 1; j++) {
                                rollNo[j] = rollNo[j + 1];
                                name[j] = name[j + 1];
                                marks[j] = marks[j + 1];
                            }
                            count--;
                            System.out.println("Student deleted successfully!");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Roll Number to update: ");
                    int updateRoll = sc.nextInt();
                    boolean updated = false;
                    for (int i = 0; i < count; i++) {
                        if (rollNo[i] == updateRoll) {
                            System.out.println("Current Details:");
                            System.out.println("Name: " + name[i] + " | Marks: " + marks[i]);
                            sc.nextLine();
                            System.out.print("Enter new Name: ");
                            name[i] = sc.nextLine();
                            System.out.print("Enter new Marks: ");
                            marks[i] = sc.nextFloat();
                            System.out.println("Student information updated successfully!");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please enter 1 to 6 only.");
            }
        }
    }

}
