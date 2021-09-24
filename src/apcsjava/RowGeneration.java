/*
Author: Denoon, Derek
Date: September 23, 2021
Assignment: Puzzle
 */

package apcsjava;

import java.util.ArrayList;
import java.util.HashMap;


public class RowGeneration {

    public static ArrayList<Integer> generateRow(int n){
        // hashmap to check if boxes are filled 0 is empty and 1 is full (all boxes are empty to start)
        HashMap<Integer,Integer> fillCheck = new HashMap<>();
        for(int i = 1; i <= n;i++){
            fillCheck.put(i,0);
        }

        // contains integers 1-n
        HashMap<Integer,Integer> pool = new HashMap<>();
        for (int i = 1;i <= n; i++ ){
            pool.put(i,i);
        }
        // used to build the row
        HashMap<Integer,Integer> builder = new HashMap<>();

        // puts one as the first entry
        builder.put(1,1);
        fillCheck.put(1,1);

        int lastEntry = 1;
        for (int i = 0; i < n-1;i++){
            // finds the position of the next variable
            int indexToInsert = nextPositionExpanded(fillCheck,lastEntry,1,n);
            // inserts the variable
            builder.put(
                    indexToInsert,
                    pool.get(i+2));
            // stores the position entered to generate the next position
            lastEntry = indexToInsert;
            // marks the position as filled
            fillCheck.put(indexToInsert,1);
        }

        // converts the hashmap into an arraylist
        ArrayList<Integer> toReturn = new ArrayList<>();
        for (int i = 0;i < n; i++){
            toReturn.add(builder.get(i+1));
        }

        return toReturn;

    }


    public static int nextPositionExpanded(HashMap<Integer,Integer> fillStatus, int currentIndex,int skip,int n){
        // finds the position of the next number
        boolean found = false;
        int search = currentIndex + 1;
        // if the skipping overflows n (the number of numbers)
        if(search > n ){
            search = 1;
        }
        int nextFree = 0;
        int opensFound = 0;

        // searches until it finds the position
        while (!found){
            // looks to see if positions are filled and calculates the position of the next open after the skips
            if(fillStatus.get(search) == 0){
                nextFree = search;
                opensFound++;
                if(skip < opensFound){
                    found = true;
                }else{
                    search++;
                    if(search > n){
                        search = 1;
                    }
                }
            }else{
                search++;
                if(search > n){
                    search = 1;
                }
                }
            }

        return nextFree;
    }

}
