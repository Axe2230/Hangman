
   import java.util.Scanner;
   import java.io.*;

   public class Hangman
   {
      public static void main(String[] args) throws IOException
      {
         Scanner keyboard = new Scanner(System.in);
         char again = 'n';
         String secret;
         StringBuffer dashes;
         final int maxparts = 6;
         int bodyparts;
         boolean done;
         String guess;
         String guesses;
         char letter;
      	
         Scanner infile = new Scanner(new FileReader("hangman.txt"));
         System.out.println("Let's play Hangman!");
         do {
         
            secret = infile.next();
            guesses = "";
            done = false;
            bodyparts = maxparts;
         
         
            dashes = makeDashes(secret);
           
            while (! done)
            {
               System.out.println("Here is your word: " + dashes);
               System.out.println("Letters used up so far: " + guesses);
               System.out.print("Guess a letter one at a time: ");
               guess = keyboard.next();
            
            
               if (guess.length() > 1)  
               {
                  if (guess.equals(secret))
                     System.out.println("You win!");
                  else
                     System.out.println("You lose");
                  done=true;
               }
               else 
               {
                  letter = guess.charAt(0);
                  guesses += letter;
                  if (secret.indexOf(letter) < 0)  
                  {	--bodyparts;
                     System.out.print("Wrong guess - ");
                  }
                  else 
                  {
                  	
                     matchLetter(secret, dashes, letter);                                   
                  }
                  System.out.println(bodyparts + " bodyparts are left");
                  if (bodyparts == 0)
                  {	System.out.println("You lost");
                     done = true;
                  }
                  if (secret.equals(dashes.toString()))
                  {	System.out.println("You won!");
                     done = true;
                  }
               } 
            
            } 
         
            if (infile.hasNext())
            {
               System.out.print("Do you want to play again? Enter Y for Yes / N for No ");
               again = keyboard.next().charAt(0);
            }
            
            else
               System.out.println("Thanks for playing");
            System.out.println();
            System.out.println("On my honor as a South Lakes High School student,");
            System.out.println("I, Harshil Patel, have neither given nor received");
            System.out.println("unauthorized assistance on this work.");
            
            
         } while (infile.hasNext() && (again == 'Y' || again == 'y'));
      } 
   
   
   
   
      public static void matchLetter(String secret, StringBuffer dashes, char letter)
      {
         for (int index = 0; index < secret.length(); index++)
            if (secret.charAt(index) == letter)
               dashes.setCharAt(index, letter);
         System.out.print("Good Guess - ");
      }
   
      public static StringBuffer makeDashes(String s)
      {
         StringBuffer dashes = new StringBuffer(s.length());
         for (int count=0; count < s.length(); count++)
            dashes.append('-');
         return dashes;
      }
   	
   
   }  
