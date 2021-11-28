import java.io.Serializable;
import java.util.ArrayList;

public class TreeTable implements Serializable {
	// This HashTable is designed to accept and store only 25 years of Student data
	// from the year 2000 to 2024 specifically. Any year outside this range should
	// not be accepted using input validation in the application.

	private int tableSize = 25;
	private Tree[] data = new Tree[tableSize];

	public TreeTable() {
		for (int i = 0; i < tableSize; i++) {
			data[i] = new Tree();
		}
	}

	private int hash(int key) {
		String keyString = Integer.toString(key);
		int year = Integer.parseInt(keyString.substring(0, 4));
		return year % tableSize;
	}

	public void insert(Student s) {
		Tree curTree = data[hash(s.getId())];
		curTree.insert(s);
	}

	public Student find(int id) {
		Tree curTree = data[hash(id)];
		return curTree.find(id);
	}

	public Student update(Student newStudent) {
		Tree curTree = data[hash(newStudent.getId())];
		return curTree.update(newStudent);
	}

	public boolean remove(int id) {
		Tree curTree = data[hash(id)];
		return curTree.remove(id);
	}

	public void printStudents(int year) {
		Tree curTree = data[hash(year)];
		if (curTree.isEmpty()) {
			System.out.println("No student data for given year.");
			return;
		}
		curTree.inOrder();
	}

	public void printAll() {
		for (int i = 0; i < data.length; i++) {
			Tree curTree = data[i];
			if (curTree.isEmpty())
				continue;
			if (i < 10) {
				System.out.println();
				System.out.println(".........................");
				System.out.println("\t \t Year " + "200" + i);

			} else {
				System.out.println();
				System.out.println(".........................");
				System.out.println("\t \t Year " + "20" + i);

			}
			curTree.preOrder();
		}
	}

	public ArrayList<Student> studentWithGPA(double gpa) {
		ArrayList<Student> array = new ArrayList<>();
		ArrayList<Student> tmp = new ArrayList<>();
		int i = 0;
		while (i < data.length) {
			Tree curTree = data[i];
			if (curTree.isEmpty()) {
				i++;
				continue;
			}
			tmp = curTree.findAll();
			for (Student s : tmp) {
				if (s.getGPA() < gpa) {
					array.add(s);
				}
			}
			i++;
		}
		return array;
	}
}
