
//This program decodes the output file created by the MTFencoder program

import java.io.*;

class MTFdecode {
	public static void main(String[] args) {

		if (args.length == 0 || args.length > 1) {
			System.out.println("Syntax to run the program: java MTFdecode <inputFile>");
		} else {
			try {
				Tokenizer tokenizer = new Tokenizer();
				tokenizer.add("[a-zA-Z]+",8);
			    tokenizer.add("\\s*[^a-zA-Z]+\\s*",9);
			    tokenizer.add("\\r\\n|\\r", 10);
				BufferedReader br = new BufferedReader(new FileReader(args[0]));
				String line;
				//Declare a new wordList to store the MRU words
				WordList wordList = new WordList(); 
				while ((line = br.readLine()) != null) {
					String[] strArray = line.split(" ");
					int index = 0;
					if (strArray.length > 1) {
						wordList.addToFront(strArray[1]);
						if(strArray[1].equals("xNEWLINEx")){
							System.out.println();
						}
						else{
							System.out.print(strArray[1]+ " ");
						}
						
					} else {
						index = Integer.parseInt(strArray[0]);
						String word;
						word = wordList.getWord(index);
						wordList.moveToFront(word);
						if(word.equals("xNEWLINEx")){
							System.out.println();
						}
						else{
							System.out.print(word + " ");
						}
						
					}
				}
				// System.out.println("------------The internal word List is below----------");
				// wordList.showList();
			} catch (Exception e) {
				System.out.println("Unable to read encoded file: " + e);
			}
		}
	}
}