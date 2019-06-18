import java.util.Scanner;


class Main {


  public static void main(String[] args) {
    
    String[] listOfWords = {"intel", "chip", "thinkpad", "optane", "folsom"};
    Scanner scan = new Scanner(System.in);
    String word = "";



    System.out.println("This is a hangman game");
    System.out.println("Please choose one of the options:");
    System.out.println("1. Enter your own word");
    System.out.println("2. Generate random word");

    int option = scan.nextInt();
    if(option == 1){
      System.out.println("Enter your word: ");
      word = scan.next();
    }
    else if(option == 2){
      System.out.println("A random word is generated.");
      word = listOfWords[(int)(Math.random() * listOfWords.length)];
    }
    
    char[] guessWord = new char[word.length()];
    for(int i = 0; i < word.length(); i++){
      guessWord[i] = '_';
    }
    char[] wordToGuess = new char[word.length()];
    for(int i = 0; i < word.length(); i++){
      wordToGuess[i] = word.charAt(i);
    }

    boolean complete = false;
    char letter = '0';
    int wrong = 0;
    while(!complete){
      System.out.println("Guess a letter: ");
      printArray(guessWord);
      System.out.println();
      letter = scan.next().charAt(0);
      if(isInArray(letter, guessWord)){
        System.out.println("Already guessed this letter!");
      }
      else if(isInArray(letter, wordToGuess)){
        for(int i = 0; i < word.length(); i++){
          if(wordToGuess[i] == letter){
            wordToGuess[i] = '_';
            guessWord[i] = letter;
          }
        }
        
      }
      else{
        System.out.println("X Sorry, you didn't get it right. ");
        wrong++;
      }

      if(wrong == 5){
        System.out.println("You are dead!");
        complete = true;
      }

      if(isCompleted(guessWord)){
        System.out.println("Congratulations!");
        printArray(guessWord);
        complete = true;

      }
      
    }
  }

  public static void printArray(char[] a){
    for(char x : a){
            System.out.print(x + " ");
          }
    System.out.print("\n");      
  }


  public static boolean isInArray(char a, char[] b){
    for(int i = 0; i < b.length; i++){
      if(a == b[i]){
        return true;
      }
    }
    return false;
  }

  public static boolean isCompleted(char[] b){
    for(int i = 0; i < b.length; i++){
      if(b[i] == '_'){
        return false;
      }
    }
    return true;
  }
  
}