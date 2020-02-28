package eg.edu.alexu.csd.datastructure.hangman;

import java.io.*;
import java.util.*;

public class HangmanGame implements IHangman{
	
	private static String[] words;
	private static String secretWord;
	private static String guessWord;
	private static int maxWrongGuesses;
	private static int n;
	private boolean[] visible = new boolean[secretWord.length()];
    private static List<String> dictionary = new ArrayList<String>();
    private char[] upAlphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private char[] lowAlphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
   
	
	public static void main(String[] arg) throws Exception {
		// Game UI
		                  /* Start Menu */
		System.out.println("Enter '1' for starting the game");
		Scanner scan = new Scanner(System.in);
		int start = scan.nextInt(); 
		while(true) {
			if(start == 1) {
				scan.close();
				break;
			}
			else {
				start = scan.nextInt(); 
			}
		}
		readWords();
		HangmanGame obj = new HangmanGame();
		obj.setDictionary(words);
		obj.selectRandomSecretWord();
		System.out.println("Enter the max number of wrong guesses");
		int max = scan.nextInt();
		obj.setMaxWrongGuesses(max);
		                      /* Game loop */
		char[] lettersI = new char[secretWord.length()];
		for(int i=0 ; i<(secretWord.length()) ; i++) {
				lettersI[i] = '-';
		}
		String initialWord = String.copyValueOf(lettersI);
		System.out.println(initialWord);
		System.out.println("Enter your guess");
		while(true) {
			char Guess = scan.next().charAt(0);
			obj.guess(Guess);
			if(maxWrongGuesses == -1) {
				System.out.println("You lose!");
				break;
			}
			else if(guessWord == secretWord) {
				System.out.println("You win!");
				break;
			}
		}
		
	}

	public static void readWords() {
		// Creation of the "myWords" File
		try {
			File myWords = new File ("myWords.txt");
			if(myWords.createNewFile()) {
				System.out.println("File created: " + myWords.getName());
			}
			else {
				System.out.println("File already exists.");
			}
		}
		catch(IOException e){
			System.out.println("An error occured.");
			e.printStackTrace();
		}
		// Reading words from the "myWords" file
		try {
			File myWords = new File("myWords.txt");
			Scanner myReader = new Scanner(myWords); 
			String nString = myReader.nextLine();
			n = Integer.parseInt(nString);
			for(int i=1 ; i<=n ; i++) {
				String data = myReader.nextLine();
				words[i] = data;
			}
			myReader.close();
		}
		catch (FileNotFoundException e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
		
		catch(NullPointerException e){
			System.out.println("Null pointer Exception");
		}
	}
	
	public void setDictionary(String[] words) {
		dictionary = Arrays.asList(words);
	}
    
	public String selectRandomSecretWord() {
		String secretWord = dictionary.get(new Random().nextInt(dictionary.size()));
		return secretWord;
	}

	public String guess(Character c) throws Exception {
		if(maxWrongGuesses == -1) {
			throw new Exception("Exceeds max number of wrong guesses!");
		}
		else if(c == null) {
			return null;
		}
		else {
			// Converting the secretWord into an array of characters
			char[] letters = secretWord.toCharArray();
			// Comparing between the secretWord and the character guessed
			boolean exists = false;
			for(int i=0 ; i<(secretWord.length()) ; i++) {
				if(letters[i] == c) {
					exists = true;
					visible[i] = true;
				}
			}
			if(exists == false) {
				System.out.println("The character does not exist in the word");
				maxWrongGuesses--;
			}
			// Converting the word guessed into a String
			char[] lettersII = new char[secretWord.length()];
			for(int i=0 ; i<(secretWord.length()); i++) {
				if(visible[i] == true) {
					lettersII[i] = letters[i];
				}
				else {
					lettersII[i] = '-';
				}
			}
			guessWord = String.copyValueOf(lettersII);
			return guessWord;
		}
	}

	public void setMaxWrongGuesses(Integer max) {
		if(max == null) {
			maxWrongGuesses = 1;
		}
		else {
			maxWrongGuesses = max;
		}
	}
}