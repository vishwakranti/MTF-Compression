//Create a word list node data structure to store a 
// word and a node which points to the next node.
public class WordListNode{
	String word;
	WordListNode next;
	//WordListNode previous;

	WordListNode(String inputWord){
	
	  word = inputWord;
	  next = null;
	  //previous = null;
	}
	
	//Method to get value of a word list node
	public String getValue(){
	  return word;
	}
	
	//Method to get the address of the next node
	public WordListNode getNext(){
	  return next;	
	}

	//Method to set the address of the next node
	public void setNext(WordListNode n){
	  next = n;
	}
}
