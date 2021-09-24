/*
Author: Denoon, Derek
Date: September 23, 2021
Assignment: Puzzle
 */

package apcsjava;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner object
        Scanner input = new Scanner(System.in);
        // outputs the first 20 rows of the triangle
        System.out.println("First 20 Rows: ");
        for (int i = 1;i < 21; i++){
            System.out.println(RowGeneration.generateRow(i));
        }

        // takes in user input n and outputs row n
        int toGenerate;
        System.out.println("What row number would you like to know: ");
        toGenerate = input.nextInt();
        System.out.println(RowGeneration.generateRow(toGenerate));






    }
}
