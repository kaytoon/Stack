package view;

public class MyStack<Type> {
	StringBuilder builder = new StringBuilder();
	private Node<Type> node;
	private int mySize;
	int numBun = 0;
	public MyStack() {

		node = null;
		mySize = 0;
	}
	boolean isEmpty(){

		return (mySize==0);

	}
	void push(Type item) {
		Node<Type> newNode = new Node<Type>(item);
		newNode.next = node;
		node = newNode;
//		boolean added = false;

		mySize++;
	}
	public Type peek() {
		if(isEmpty()){

			return null;
		}
		return node.data;
	}
	public Type pop(){
		if(isEmpty()){
			return null;
		}
		Type data = node.data;
		node = node.next;
//		String name = data.toString();
//		int index = builder.indexOf(name);
//		builder.delete(index, index+name.length()+2);
		mySize--;
		return data;
	}
	public int size() {
		return mySize;
	}
	public String toString() {
		Node<Type> current = node;
		StringBuilder build = new StringBuilder();
		build.append("[");
		while(current!=null){
			if(current.next != null)
			build.append(current+", ");
			else build.append(current);
			current= current.next;
		}

		build.append("]");
		return build.toString();

	}
}
