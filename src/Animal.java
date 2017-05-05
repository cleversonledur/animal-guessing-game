import javax.swing.JOptionPane;

public class Animal extends Node{
	public Animal(Node l, Node r, String animalName) {
		super(l,r,animalName);
	}
	
	/*The getAnswer method is used to show the JOptionPane and get the
	 * user response.*/
	public int getAnswer(){
		String message = "O animal que você pensou é " + this.getContent() + "?";
		String title = "Acho que sei o animal!";
		return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	}
	
	public void nextNode(int lastOption, Node parent){
		int answer = this.getAnswer();

		
		if(answer == JOptionPane.YES_OPTION){
			/*The algorithm found the right answer.*/
			JOptionPane.showMessageDialog(null, "Acertei de novo!");
			
		}else{
			/*It is required to insert a new animal*/
			String animalName = JOptionPane.showInputDialog("Qual o animal que você pensou?");
			
			String actionName = JOptionPane.showInputDialog("Um " + 
											animalName + 
											"_____ mas um(a) " + 
											this.getContent() + 
											" não");
			
			if(actionName == null || actionName.trim().isEmpty()||animalName == null || animalName.trim().isEmpty()){
				/*Some of the fields were left blank. Then, in order to avoid bad nodes in the tree we abort and return
				 * to the initial (root) position and start again.*/
				JOptionPane.showMessageDialog(null, "Parece que você deixou dados em branco! "
						+ "Vamos voltar para o início sem cadastrar seu animal.");
				return;
			}
			/*If the fields were completely filled, we create a new animal and a new question to add at the tree.*/
			Animal newAnimal = new Animal(null,null,animalName);
			
			if(lastOption==JOptionPane.YES_OPTION){
				/*If the last option were "Yes", then we point the parent node to the new question using the right parent 
				 * child position*/
				parent.setRightChild(new Question(this, newAnimal, actionName));
			}else{
				/*Otherwise, If the last option was "No", we point the parent node to the new question using the left parent 
				 * child position*/
				parent.setLeftChild(new Question(this, newAnimal, actionName));
			}
		}
	}
}
