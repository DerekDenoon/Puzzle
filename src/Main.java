import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("First 20 Rows: ");
        for (int i = 1;i < 21; i++){
            System.out.println(RowGeneration.generateRow(i));
        }

        int toGenerate;
        System.out.println("What row number would you like to know: ");
        toGenerate = input.nextInt();
        System.out.println(RowGeneration.generateRow(toGenerate));






    }
}
