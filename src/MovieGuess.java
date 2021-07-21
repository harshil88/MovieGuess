import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.io.File;


public class MovieGuess {

    public static void main(String args[]) throws FileNotFoundException {

        int numberOfMovies = 0;
        int guesses = 10;
        String[] movies = new String[100];
        boolean hasWon = false;
        boolean isTrueGuess = false;

        //Determine the number of movies in a txt file.


        File movie = new File("movie.txt");
        Scanner scanner = new Scanner(movie);
        while (scanner.hasNextLine()) {
            movies[numberOfMovies] = scanner.nextLine();
            numberOfMovies++;
        }

        Random random = new Random();
        int randomMovie = random.nextInt(numberOfMovies);


        //Introductary statements.

        System.out.println("Welcome, amigos, welcome to this game");
        System.out.println("You will be shown a movie with blanks and spaces");
        System.out.println("Your job is to find the movie");
        System.out.println("You have only ten chances, use them wisely");
        System.out.println("When you became sure, you know the movie then press 1");



        System.out.println(movies[randomMovie]);
        StringBuilder selectedMovie = new StringBuilder(movies[randomMovie]);
        StringBuilder blankMovie = new StringBuilder(selectedMovie.length());
        StringBuilder wrongLetters = new StringBuilder();
        int wrongLettersCount = 0;

        for (int i = 0; i < selectedMovie.length(); i++) {
            if (selectedMovie.charAt(i) != ' ') {
                blankMovie.append('_');
            }
            else {
                blankMovie.append(' ');
            }
        }

        System.out.println("");

        Scanner letterScan = new Scanner(System.in);
        System.out.println(blankMovie.toString());
        System.out.print("Enter next letter: -");

        while (letterScan.hasNext()) {



            char currLetter = letterScan.next().charAt(0);

            if(currLetter!='1'){


                for(int i = 0 ; i < selectedMovie.length() ; i++){
                    if(selectedMovie.charAt(i)==currLetter){
                        blankMovie.setCharAt(i , currLetter);
                        isTrueGuess = true;
                    }
                }

                if(isTrueGuess){
                    isTrueGuess = false;
                }
                else {
                    wrongLetters.append(currLetter);
                    wrongLettersCount++;
                    System.out.println(wrongLetters.toString());
                    guesses--;
                }



                if(selectedMovie.toString().equals(blankMovie.toString())){
                    hasWon = true;
                    break;

                }



                if(guesses==0){
                    break;
                }

                System.out.println(blankMovie.toString());
                System.out.println("wrong letters : " + wrongLetters.toString());
                System.out.println("Chances remaining: " + guesses);
                System.out.println("Enter next letter: -");
            }

            else{
                System.out.println("You think you know the movie, eh");
                Scanner fullMovie = new Scanner(System.in);
                System.out.println("Please enter the name of the movie in proper format and everything in small cases");
                if(fullMovie.nextLine().equals(selectedMovie.toString())){
                    System.out.println("Whoopsy doopsy, mate you are a legend");
                }
                else{
                    System.out.println("You are just a loser boooooooooooo");
                    System.out.println(selectedMovie.toString());

                }
            }

        }

        if(hasWon){
            System.out.println("Lucky eh..");
        }

        else{
            System.out.println("That was just too pathetic to watch");
        }

    }


}
