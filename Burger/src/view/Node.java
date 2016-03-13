package view;


public class Node<Type> {
	public Type data;
	public Node<Type> next;
	
	public Node(Type data) {
		this.data = data;
		this.next = null;
	}
	
	public String toString() {
		return data.toString();
	}
}