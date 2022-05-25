
//
//This program encodes an input text file based on the move-to-front compression algorithm

import java.util.*;
import java.io.*;

class MTFencoder {
	public static void main(String [] args) {
		
		if (args.length == 0 || args.length > 1) {
			System.out.println("Syntax to run the program: java MTFencoder <inputFile>");
		}
		if (args.length == 1) {
			try {
				int index =0;
				//Declare a wordList where the most recently used words are kept
				WordList wordList = new WordList(); 
				
				BufferedReader br = new BufferedReader(new FileReader(args[0])); //Read in the file
				String line;
				
				while ((line = br.readLine()) != null) { //Read lines from buffered reader until none are left
					String flag = "true"; //flag is set to true at start of the line
					String[] strArray = line.split(" ");
					for (int i=0; i<strArray.length; i++){
						//Capture newline character 
						if (strArray[i].equals("")){ 
							int index3 =0;
							//If new line token already exists then move it to front in the wordList 
							//and output index to console
							if (wordList.hasWord("xNEWLINEx")){ //new line is tokenized to xNEWLINEx in the output
								index3 = wordList.getIndex("xNEWLINEx");
								System.out.println(index3);
								wordList.moveToFront("xNEWLINEx");
							}
							//or else add the newline in the wordList and output 0 and 
							//xNEWLINEx to the console
							else { 
								wordList.addToFront("xNEWLINEx");
								System.out.println("0 " + "xNEWLINEx");
							}
						}
							//Check if any word exists in the wordList and if it does then move it to front
							// and output index to the console
						else if (wordList.hasWord(strArray[i])){ 
							index = wordList.getIndex(strArray[i]); 
							System.out.println(index);
							wordList.moveToFront(strArray[i]);
						}
						//if word doesn't exist in wordList then add it to the front of 
						//wordList and output 0 and the word to the console
						else { 
							wordList.addToFront(strArray[i]);
							System.out.println("0 " + strArray[i]);
						}
					}
					
					flag = "false"; // flag is set to false and a new line token is encoded into the output
					
					// The new line character is added to the wordList at the end of 
					// processing the line read in from the file.
					if (flag.equals("false")){
						int index2 = 0;
						if (wordList.hasWord("xNEWLINEx")){
							index2 = wordList.getIndex("xNEWLINEx");
							System.out.println(index2);
							wordList.moveToFront("xNEWLINEx");
						}
						else {
							wordList.addToFront("xNEWLINEx");
							System.out.println("0 " + "xNEWLINEx");
						}
					}
				}
			} catch (Exception e) { //catch exceptions if any from the try loop
				System.out.println("Unable to read from file! " + e);
			}	
		}
	}
}
