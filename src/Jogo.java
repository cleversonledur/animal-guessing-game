import javax.swing.JOptionPane;
/*
 * Author: Cleverson Lopes Ledur
 * Date: 23/03/2017
 * Last Modification: 23/03/2017
 * 
 * This game uses a binary tree algorithm (widely used in machine learning and AI) to "learn" 
 * and classify different animals according to their characteristics. 
 * Basically this has two classes (Question and Animal) that derive from
 * the Node class. We initialize the binary tree with a question and two possible animals.
 * Then, the root (first node of the tree) starts processing with the nextNode() method.
 * This method was implemented in both classes in order to navigate to the leaf nodes, where there
 * are two possible actions: or find the Animal, or to add a new animal and its characteristic on
 * the binary tree.
 * In order to define a convention, I used in this code the following meanings for yes/no responses 
 * to navigate the tree:
 * 		
 * No - Goes to the Left.
 * Yes - Goes to the Right.
 *
 * */
public class Jogo {
	public static void main(String[] args) {
		/*Initialize the tree*/
		Node root = new Question(null,null,"vive na água");
		root.setRightChild(new Animal(null,null,"Tubarão"));
		root.setLeftChild(new Animal(null,null,"Macaco"));
		
		/*I had to create this in order to get the response that is not 
		 * available in a simple showMessageDialog().*/
		Object[] options = {"OK"};
		int n=0;
		
		/*While the user press Ok button, this will keep running.*/
		while(n==0){
		    n = JOptionPane.showOptionDialog(null,
		                   "Pense em um animal","Jogo dos Animais",
		                   JOptionPane.PLAIN_MESSAGE,
		                   JOptionPane.QUESTION_MESSAGE,
		                   null,
		                   options,
		                   options[0]);

		    if(n==0){ /*In case of clicking 
		    		   * X (exit) this will not run again. */
		    	
		    	root.nextNode(0,null); //Start the game!
		    }
		}
	}
}

