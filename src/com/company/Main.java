package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> slicesAvailable = new ArrayList<Integer>();
        Scanner inputNum = new Scanner(System.in);
        int playAgain = 1;
        boolean tookGoodSlice = false;
        int takeAnotherSlice = 0;
        int points = 0;
        int turns = 0;
        int slicesRemaining = 0;

        System.out.println("You have a pizza where every slice has disgusting ingredients except for one, your goal is to remove the unwanted slices so only the good slice is left. ");
        System.out.println("What slice you pick is decided at random each turn. The more turns you take, the greater the risk is of accidentally taking the good slice off the pizza. ");
        System.out.println("Your points are calculated for each bad slice taken away, a perfect score is when you manage to take away all the bad slices and are only left with the good slice. ");
        System.out.println("10 points are deducted for every bad slice still on the pizza. ");

        while(playAgain == 1){

            slicesAvailable = new ArrayList<Integer>(Arrays.asList(2, 1, 1, 1, 1, 1, 1, 1, 1, 1));
            points = 100;
            slicesRemaining = 9;
            takeAnotherSlice = 1;
            tookGoodSlice = false;
            turns = 0;

            while(!tookGoodSlice && takeAnotherSlice == 1) {


                turns = turns + 1;
                int selectedSlice = (int) (slicesAvailable.size() * Math.random() + 0);

                while(selectedSlice == 2 && turns == 1){
                    //this is a special case in which the good slice is chosen from the start,
                    // for the game's sake the selected slice will re-randomize.
                    // This ensures the player at least gets to do a turn instead of ending the game immediately.
                    selectedSlice = (int) (slicesAvailable.size() * Math.random() + 0);
                }

                if (slicesAvailable.get(selectedSlice) == 1) {
                    slicesAvailable.remove(selectedSlice);
                    System.out.println("You removed a bad slice! " + slicesAvailable.size() + " slices left!");
                    slicesRemaining = slicesRemaining - 1;
                    System.out.println("Take another Slice? (1 to take/0 to quit)");
                    takeAnotherSlice = inputNum.nextInt();
                }
                else
                {
                    tookGoodSlice = true;
                }

            }
            points = points - 10 * slicesRemaining;
            System.out.println("You selected the good slice! You scored " + points + " points. Play again? (1 to play again/0 to quit)");
            playAgain = inputNum.nextInt();
        }
    }
}
