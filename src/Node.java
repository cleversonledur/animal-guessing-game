
abstract class Node{
	
	private Node leftChild; //Stores the left child node
	private Node rightChild; //Stores the right child node
	private String content; //Stores the node content 

	
	public Node(Node l, Node r, String content) {
		this.leftChild = l;
		this.rightChild = r;		
		this.content = content;
	}
	public Node(String m) {
		this.content = m;		
	}
	
	abstract int getAnswer();

	abstract void nextNode(int lastOption, Node parent);
	
	
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}

