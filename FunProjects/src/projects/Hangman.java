package projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random randomindex = new Random();
		ArrayList<String> inputArr = new ArrayList<>();
		
		HashSet<String> hs1 = new HashSet<>();
		HashSet<String> hs2 = new HashSet<>();
		
		String[] words = { "newton", "eddison", "einsten", "ramanujam", "aaryabhatta" };
		String wordToGuess = words[randomindex.nextInt(words.length)];
		hs1.addAll(Arrays.asList(wordToGuess.split("")));
		
		System.out.println("Guess the Scientist Name");
		for (int i = 0; i < wordToGuess.length(); i++) {
			System.out.print("_ ");
		}

//		System.out.println("Random words: " + wordToGuess);
		int wrongChoice = 3;
		int wordsFound = 0;
		boolean retry = false;
		String userInput = "";

		while (!retry && wrongChoice != 0 && wordsFound < wordToGuess.length()) {
			boolean validInput = true;
			while (validInput) {
				System.out.println("\nType ! to EXIT \nNo of Lives Left : " + wrongChoice);
				System.out.println("Enter a character : ");
				userInput = scan.next();

				if (!inputArr.contains(userInput)) {
					if (userInput != "!") {
						inputArr.add(userInput);
						break;
					}
				} else {
					validInput = false;
					System.out.println("Already Guessed Alphabet !! ");
				}
			}
			if (validInput) {
				if (wordToGuess.toLowerCase().contains(userInput.toLowerCase())) {
						hs2.add(userInput.toLowerCase());
					System.out.println("Correct Guess");
					String[] splitstr = wordToGuess.split("");
					System.out.println("Updated Word is ");
					for (int i = 0; i < wordToGuess.length(); i++) {
						if (splitstr[i].equalsIgnoreCase(userInput) || inputArr.contains(splitstr[i])) {
							System.out.print(splitstr[i] + " ");
						} else {
							System.out.print("_ ");
						}
					}
				} else {
					if (userInput != "!") {
						System.out.println("Wrong Guess");
						wrongChoice--;
						if (wrongChoice == 0) {
							System.out.println("Maximum Guesses Reached You Have Lost \n --------Exiting Game----------");
							System.out.println("The Answer is :"+wordToGuess.toUpperCase());
						}
					}
				}

			}

			if (userInput.equals("!") || hs1.size() == hs2.size()) {
				if(userInput != "!") {
					System.out.println(" ############### YOU WON !!! CONGRATS ################## ");
				}
				retry = true;
				System.out.println("Exiting Game");
			}

		}
	}

}
