//This is a custom linked list class that uses a recursive datatype WordListNode 
//to store an element and a node which points to the next node.
public class WordList{
	private WordListNode head;
	
	//constructor for the word list
	public WordList(){
		//String word = null;
		//WordListNode next = null;
	}
	//Method to add the word to front of the word list
	public void addToFront(String word){
	  WordListNode in = new WordListNode(word);
	  //in.word = word;
	  in.setNext(head);
	  head = in;
	}
	
	//Method to get the length of the word List
	public int length(){
	  WordListNode tmp = head;
	  int count = 0;
	  while (tmp != null) {
	    count++;
	    tmp = tmp.getNext();
	  }
	  return count;
	}
	
	
	//Method to check for the existence of a word in the word list
	public boolean hasWord(String word){
	  WordListNode tmp = head;
	  while (tmp != null) {
	    if (word.equals(tmp.getValue())) 
  	      return true;
	    tmp = tmp.getNext();
	  }
	  return false;
	}
	
	//Method to delete an existing word in the word list and 
	//move it to the front of the word list
	public void moveToFront(String word){
		if(word.equals(head.getValue())){
			head = head.getNext();
		}
		else{
			WordListNode tmp = head;
			while(tmp !=null){
				if (word.equals(tmp.next.getValue())){
					tmp.setNext(tmp.getNext().getNext());
					break;
				}
				tmp = tmp.getNext();
			}
		}
		WordListNode in = new WordListNode(word);
		in.setNext(head);
		head = in;
		
	}
	
	//Method to print each word in the word list
	public void showList(){
		WordListNode tmp = head;
		while(tmp !=null ){
			System.out.println(tmp.getValue());
			tmp = tmp.getNext();
		}
	}
	
	//Method to retreive the index of a word in the word list
	public int getIndex(String word){
		WordListNode tmp = head;
		int count = 0;
		while (tmp != null){
			if (word.equals(tmp.getValue()))
				break;
			tmp = tmp.getNext();
			count++;
		}
		return count;
	}
	
	//Method to retreive the word from the word list
	//based on a supplied index
	public String getWord(int index){
		WordListNode tmp = head;
		for (int i = 0; i <= index; i++){
			if(i == index){
				return tmp.getValue();
			}
			else 
				tmp = tmp.getNext();
		}
		return "";
	}
}
