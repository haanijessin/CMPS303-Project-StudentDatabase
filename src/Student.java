import java.io.Serializable;

public class Student implements Serializable {
	private int id;
	private String name;
	private String address;
	private double GPA;

	public Student(int id, String name, String address, double gPA) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		GPA = gPA;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	@Override
	public String toString() {
		return "[Student " + id + "] Name:" + name + ", Address:" + address + ", GPA:" + GPA;
	}
}
