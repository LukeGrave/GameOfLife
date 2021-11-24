package com.gameoflife;

import java.util.Scanner;

public class GameOfLife {

   /*  Rules --- John Conway's Game of Life
    deadCell    -->   neighbours == 3   -->   livingCell    [birth]
    livingCell  -->   neighbours < 2    -->   deadCell      [death]
    livingCell  -->   neighbours > 3    -->   deadCell      [death]
    livingCell  -->   2 <= nbs <= 3     -->   livingCell    [stasis]

    livingCell [#]     deadCell [+]
*/

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Define Row: ");
        int row = sc1.nextInt();
        System.out.print("Define Columns: ");
        int col = sc1.nextInt();

        int[][] city = new int[row][col]; //erstelle 100*100 Feld

        for (int i = 0; i < city.length; i++)    //Belebe die Stadt
        {
            for (int j = 0; j < city[i].length; j++)
            {
                city[i][j] = (int)(Math.random() * 2);    //0, 1
            }
        }
        displayGen(city, row, col);

        for (int i = 1; i < 50; i++){

            System.out.println("Generation " + i);
            city = nextGen(city, row, col);
            displayGen(city, row, col);

            try { Thread.sleep(900); } catch (InterruptedException ex) { ex.printStackTrace(); } //Verzögerung
        }
    }

    public static void displayGen(int[][] city, int row, int col)
    {
        final String BLUE_BACKGROUND = "\u001B[44m";    // Backgroundcolor for following output!!!
        final String BLUE_BRIGHT_BACKGROUND = "\033[0;104m";
        final String WHITE_BACKGROUND = "\033[0;107m";  //Farbcode für JAVA
        final String ANSI_RESET = "\u001B[0m";  // reset of Bckgrd
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (city[i][j] == 0)
                    System.out.print(WHITE_BACKGROUND + "   " + ANSI_RESET);
                else
                    System.out.print(BLUE_BACKGROUND + "   " + ANSI_RESET);
            }
            System.out.println();
        }
    }

    public static int[][] nextGen(int city[][], int row, int col)
    {
        int[][] next = new int[row][col];
//  loop through every spot
        for(int x = 0; x < row; x++)
        {
            for (int y = 0; y < col; y++)
            {
//  add up states on neighbours
                int neighbours = 0;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            try {
                                neighbours += city[x + i][y + j];
                            }catch(Exception e) {
                                neighbours += 0;
                            }
                        }
                    }

//  Substract cell from count
                neighbours -= city[x][y];
//  rules of life
                if      ((city[x][y] == 1) && (neighbours < 2))    //death by loneliness
                {   next[x][y] = 0;}
                else if ((city[x][y] == 1) && (neighbours > 3))    //death by overpopulation
                {   next[x][y] = 0;}
                else if ((city[x][y] == 0) && (neighbours == 3))   //birth
                {   next[x][y] = 1;}
                else                                               //stasis
                {   next[x][y] = city[x][y];}
            }
        }
        return next;
    }
}
