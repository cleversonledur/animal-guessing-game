import javax.swing.JOptionPane;

public class Question extends Node {
	
	public Question(Node l, Node r, String question) {
		super(l, r,question);
	}
	
	/*The getAnswer method is used to show the JOptionPane and get the
	 * user response.*/
	public int getAnswer(){
		return JOptionPane.showConfirmDialog(null, 
						   "O animal que você pensou " + this.getContent() + "?", 
						   "Pergunta", 
						   JOptionPane.YES_NO_OPTION);
	}

	/*This method will process the current node and will
	 * call nextNode method for the child node according to
	 * the user answer (yes->go right, no->go left)*/
	public void nextNode(int lastOption, Node parent){
		int answer = this.getAnswer();
		if(answer==JOptionPane.YES_OPTION){
			this.getRightChild().nextNode(answer,this);
		}else{
			this.getLeftChild().nextNode(answer,this);
		}
	}
}
