import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		TreeTable students = new TreeTable();
		Scanner in = new Scanner(System.in);
		int choice = 0;
		
		while (true) {

			printMenu();

			try {
				String choiceString = in.nextLine();
				choice = Integer.parseInt(choiceString);
				
				if (choice == 1) {
					// Add student
					System.out.println("\nAdd Student");
					System.out.println("---------------");

					System.out.print("Enter ID: ");
					String idString = in.nextLine();
					if (!yearValid(idString))
						continue;

					int id = Integer.parseInt(idString);
					if (students.find(id) != null) {
						System.out.println(
								"Student with given ID already exists in database. Please use update function.\n");
						continue;
					}
					System.out.print("Enter name: ");
					String name = in.nextLine();
					System.out.print("Enter address: ");
					String address = in.nextLine();
					System.out.print("Enter GPA: ");
					double gpa = Double.parseDouble(in.nextLine());
					if (gpa > 4.0 || gpa < 0.0) {
						System.out.println("invalid gpa \n");
						continue;
					}

					Student std = new Student(id, name, address, gpa);
					students.insert(std);
					System.out.println("\nAdded " + std + "\n");
				}

				else if (choice == 2) {
					// Find student
					System.out.println("\nFind Student");
					System.out.println("---------------");

					System.out.print("Enter ID of student to find: ");
					String idString = in.nextLine();
					if (!yearValid(idString))
						continue;

					int id = Integer.parseInt(idString);

					Student std = students.find(id);
					if (std == null)
						System.out.println("Student with given ID does not exist in the database.\n");
					else
						System.out.println("Found " + std + "\n");
				}

				else if (choice == 3) {
					// Update student
					System.out.println("\nUpdate Student");
					System.out.println("---------------");

					System.out.print("Enter ID of the student to be modified: ");
					String idString = in.nextLine();
					if (!yearValid(idString))
						continue;

					int id = Integer.parseInt(idString);

					Student std = students.find(id);
					if (std == null)
						System.out.println("Student with given ID does not exist in the database.\n");
					else {
						System.out.print("Enter new name: ");
						String name = in.nextLine();
						System.out.print("Enter new address: ");
						String address = in.nextLine();
						System.out.print("Enter new GPA: ");
						double gpa = Double.parseDouble(in.nextLine());
						if (gpa > 4.0 || gpa < 0.0) {
							System.out.println("invalid gpa \n");
							continue;
						}
						Student temp = new Student(id, name, address, gpa);
						students.update(temp);
						System.out.println("Updated " + temp + "\n");
					}
				}

				else if (choice == 4) {
					// Delete student
					System.out.println("\nRemove Student");
					System.out.println("---------------");

					System.out.print("Enter ID of the student to be deleted: ");
					String idString = in.nextLine();
					if (!yearValid(idString))
						continue;

					int id = Integer.parseInt(idString);

					boolean std = students.remove(id);
					if (std == false)
						System.out.println("Student with given ID does not exist in the database.\n");
					else
						System.out.println("Student has been deleted successfully.\n");
				}

				else if (choice == 5) {
					// Display students in year
					System.out.println("\nDisplay Student in Year");
					System.out.println("---------------");

					System.out.print("Enter year from which the students should be displayed: ");
					String yearString = in.nextLine();
					if (!yearValid(yearString))
						continue;

					int year = Integer.parseInt(yearString);
					students.printStudents(year);
					System.out.println("");
				}

				else if (choice == 6) {
					// Display all students
					System.out.println("\nDisplay All Students");
					
					students.printAll();
					System.out.println("");
				}

				else if (choice == 7) {
					// Display students with less GPA
					System.out.println("\nDisplay Students with Less GPA");
					System.out.println("---------------");
					
					ArrayList<Student> std = new ArrayList<>();
					System.out.print("Enter the GPA below which students should be fetched: ");
					double gpa = Double.parseDouble(in.nextLine());
					if (gpa > 4.0 || gpa < 0.0) {
						System.out.println("Invalid GPA.\n");
						continue;
					}
					std = students.studentWithGPA(gpa);

					for (int i = 0; i < std.size(); i++) {
						System.out.println(std.get(i));
					}

					System.out.println("");
				}

				else if (choice == 8) {
					// Save to file
					System.out.println("Saving database to students.dat file...");
					try {
						ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"));
						out.writeObject(students);
						out.close();
						System.out.println("File saved.\n");
					} catch (FileNotFoundException e) {
						System.out.println("Student database file not found.\n");
					} catch (IOException e) {
						System.out.println("Error when processing student database.\n");
					}
				}

				else if (choice == 9) {
					// Load from file
					System.out.println("Attempting to read data from students.dat file...");
					try {
						ObjectInputStream read = new ObjectInputStream(new FileInputStream("students.dat"));
						students = (TreeTable) read.readObject();
						read.close();
						System.out.println("Data loaded.\n");
					} catch (FileNotFoundException e) {
						System.out.println("Student database file not found.\n");
					} catch (EOFException e) {
					} catch (IOException e) {
						System.out.println("Error when processing student database.\n");
					} catch (ClassNotFoundException e) {
						System.out.println("No student data in database.\n");
					}
				}

				else if (choice == 10) {
					System.out.println("Exiting...");
					in.close();
					break;
				}

				else {
					System.out.println("INVALID CHOICE. Please try again.\n\n");
					printMenu();
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Try again.\n");
				continue;
			}
		}
	}

	private static void printMenu() {
		// Print the application menu.
		System.out.println("QU STUDENT MANAGEMENT\n");
		System.out.println(
				"1. Add student\n2. Find student\n3. Update student\n4. Delete student\n5. Display students in year");
		System.out.println(
				"6. Display all students\n7. Display students with less GPA\n8. Save to file\n9. Load from file\n10.Exit");
		System.out.print("\nENTER MENU OPTION: ");
	}

	private static boolean yearValid(String id) {
		// Check if year in allowed year range.
		if (id.length() < 4) {
			System.out.println("Invalid input.\n");
			return false;
		}

		try {
			int year = Integer.parseInt(id.substring(0, 4));

			if (year < 2000 || year > 2024) {
				System.out.println("Year " + year + " is not allowed in this database. Only 2000 - 2024.\n");
				return false;
			} else
				return true;
		} catch (NumberFormatException e) {
			System.out.println("Invalid input.\n");
			return false;
		}
	}
}
