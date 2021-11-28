import java.io.Serializable;

public class Node implements Serializable {
	public int key;
	public Student data;
	public Node leftChild;
	public Node rightChild;

	public void displayNode() {
		System.out.print('{');
		System.out.print(key);
		System.out.print(", ");
		System.out.print(data);
		System.out.print("} ");
	}
}