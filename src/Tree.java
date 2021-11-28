import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class Tree implements Serializable {
	private Node root;

	public Tree() {
		root = null;
	}

	public void insert(Student s) {
		int id = s.getId();
		Node newNode = new Node();
		newNode.key = id;
		newNode.data = s;

		if (root == null) {
			root = newNode;
			return;
		}

		Node current = root;
		Node parent;
		while (true) {
			parent = current;
			if (id < current.key) {
				current = current.leftChild;
				if (current == null) {
					parent.leftChild = newNode;
					return;
				}
			} else {
				current = current.rightChild;
				if (current == null) {
					parent.rightChild = newNode;
					return;
				}
			}
		}

	}

	public void checkGpa(ArrayList<Student> s) {
		checkGpa(root, s);
	}

	public void checkGpa(Node localRoot, ArrayList<Student> s) {
		if (localRoot != null) {

			s.add(localRoot.data);
			checkGpa(localRoot.leftChild, s);
			checkGpa(localRoot.rightChild, s);
		}
	}

	public ArrayList<Student> findAll() {
		ArrayList<Student> array = new ArrayList<>();
		checkGpa(array);
		return array;
	}

	public Student find(int id) {
		if (root == null)
			return null;
		Node current = root;
		while (current.key != id) {
			if (id < current.key)
				current = current.leftChild;
			else
				current = current.rightChild;
			if (current == null)
				return null;
		}
		return current.data;
	}

	public Student update(Student newStudent) {
		Student s = this.find(newStudent.getId());

		s.setGPA(newStudent.getGPA());
		s.setAddress(newStudent.getAddress());
		s.setName(newStudent.getName());

		return s;
	}

	public boolean remove(int id) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		while (current.key != id) {
			parent = current;
			if (id < current.key) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null)
				return false;
		}
		if (current.leftChild == null && current.rightChild == null) {
			// Node has no children
			if (current == root)
				root = null;
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		} else if (current.rightChild == null) {
			// Node has left child only
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		} else if (current.leftChild == null) {
			// Node has right child only
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		} else {
			// Node has left AND right children
			Node successor = getSuccessor(current);
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			successor.leftChild = current.leftChild;
		}
		return true;

	}

	private Node getSuccessor(Node nodeToRemove) {
		Node successorParent = nodeToRemove;
		Node successor = nodeToRemove;
		Node current = nodeToRemove.rightChild;

		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		if (successor != nodeToRemove.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = nodeToRemove.rightChild;
		}
		return successor;
	}

	public void preOrder() {
		preOrder(root);
	}

	public void preOrder(Node localRoot) {
		if (localRoot != null) {
			System.out.print(localRoot.data + "\n");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.data + "\n");
			inOrder(localRoot.rightChild);
		}
	}

	public boolean isEmpty() {
		if (root == null)
			return true;
		else
			return false;
	}
}
