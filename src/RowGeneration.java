import java.util.ArrayList;
import java.util.HashMap;


public class RowGeneration {

    public static ArrayList<Integer> generateRow(int n){
        // hashmap to check if boxes are filled 0 is empty and 1 is full (all boxes are empty to start)
        HashMap<Integer,Integer> fillCheck = new HashMap<>();
        for(int i = 1; i <= n;i++){
            fillCheck.put(i,0);
        }

        HashMap<Integer,Integer> pool = new HashMap<>();
        for (int i = 1;i <= n; i++ ){
            pool.put(i,i);
        }

        HashMap<Integer,Integer> builder = new HashMap<>();

        builder.put(1,1);
        fillCheck.put(1,1);

        int lastEntry = 1;
        for (int i = 0; i < n-1;i++){
            int indexToInsert = nextPositionExpanded(fillCheck,lastEntry,1,n);
            builder.put(
                    indexToInsert,
                    pool.get(i+2));
            lastEntry = indexToInsert;
            fillCheck.put(indexToInsert,1);
        }


        ArrayList<Integer> toReturn = new ArrayList<>();
        for (int i = 0;i < n; i++){
            toReturn.add(builder.get(i+1));
        }

        return toReturn;

    }

    public static void nextOpen(HashMap<Integer,Integer> fillStatus, int currentIndex){
        boolean found = false;
        int search = currentIndex;
        int nextFree;
        while (!found){
            if(fillStatus.get(search) == 0){
                System.out.println("found the number is " + search);
                found = true;
                nextFree = search;
            }else{
                System.out.println("checked" + search + "it was incorrect ");
                search++;
            }
        }

    }

    public static void nextPosition(HashMap<Integer,Integer> fillStatus, int currentIndex,int skip){
        boolean found = false;
        int search = currentIndex + 1;
        int nextFree;
        int opensFound = 0;

        while (!found){
            if(fillStatus.get(search) == 0){
                System.out.println("found the number is " + search);
                nextFree = search;
                opensFound++;
                if(skip == opensFound){
                    found = true;
                }else{
                    search++;
                }
            }else{
                System.out.println("checked" + search + "it was incorrect ");
                search++;
            }
        }

    }

    public static int nextPositionExpanded(HashMap<Integer,Integer> fillStatus, int currentIndex,int skip,int n){
        boolean found = false;
        int search = currentIndex + 1;
        if(search > n ){
            search = 1;
        }
        int nextFree = 0;
        int opensFound = 0;

        while (!found){
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

    public static int nextPositionExpandedCopy(HashMap<Integer,Integer> fillStatus, int currentIndex,int skip,int n){
        boolean found = false;
        int search = currentIndex + 1;
        if(search > n ){
            search = 1;
        }
        int nextFree = 0;
        int opensFound = 0;

        while (!found){
            if(fillStatus.get(search) == 0){
                System.out.println("found the number is " + search);
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
                System.out.println("checked" + search + "it was incorrect ");
                search++;
                if(search > n){
                    search = 1;
                }
            }
        }


        return nextFree;
    }

}
