import java.util.Arrays;
import java.util.Scanner;

/**
 * Dominykas Stunžėnas
 * PRIf-22/3
 */
public class JavaBasics {

    //psvm - shortcut for main method
    //CTRL+ALT+L - format code

    public static void main(String[] args) {
        String name, surname;
        int n, m, a = 0, b = 0;


        //3. User inputs its name and surname and based on its length two-dimensional array is created
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = sc.nextLine().toLowerCase().trim();
        System.out.println("Enter your surname: ");
        surname = sc.nextLine().toLowerCase().trim();
        n = name.length();
        m = surname.length();
        int[][] myArray = new int[n][m];

        //4. Populates a and b variables based on the condition in the given task
        //Populates two-dimensional array with randoms elements from a to b and prints it in a table format
        b = n + m;
        for (int i = 0; i < n; i++) {
            if (name.charAt(i) == 'a' || name.charAt(i) == 'i' || name.charAt(i) == 'e' || name.charAt(i) == 'u' || name.charAt(i) == 'y' || name.charAt(i) == 'o')
                a++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                myArray[i][j] = (int) ((Math.random() * (b - a)) + a);
                System.out.print("\t" + myArray[i][j]);
            }
            System.out.print("\n");
        }

        //5. Creates two arrays and then calculates rows averages and columns averages and prints them
        double[] rowAverages = new double[n];
        double[] columnAverages = new double[m];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += myArray[i][j];
            }
            rowAverages[i] = (double) sum / m;
            System.out.printf("Row average is %.4f \n", rowAverages[i]);
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += myArray[j][i];
            }
            columnAverages[i] = (double) sum / n;
            System.out.printf("Column average is %.4f \n", columnAverages[i]);
        }

        //6. Calculates how many numbers are bigger than average of the row
        for(int i = 0; i < n; i++){
            int bigger = 0;
            for(int j = 0; j < m; j++){
                if(myArray[i][j] > rowAverages[i]) bigger++;
            }
            System.out.println("Bigger numbers in the row than average: " + bigger);
        }

        //7. Finds and print the biggest number of the two-dimensional array without a-th row and column
        int max = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == a || j == a) continue;;
                if(myArray[i][j] > max) max = myArray[i][j];
            }
        }
        System.out.println("Max value: " + max);

        //8. Sorts and print a-th row of the two-dimensional array
        int[] arrayToBeSorted = myArray[a];
        Arrays.sort(arrayToBeSorted);
        System.out.print("Sorted array of a-th row: ");
        for (int i : arrayToBeSorted) {
            System.out.print("\t" + i);
        }
        System.out.println();

        //9. Finds and prints the smallest number of the column with the smallest average
        double minColumn = columnAverages[0];
        int index = 1;
        for(int i = 1; i < columnAverages.length; i++){
            if(minColumn > columnAverages[i]){
                minColumn = columnAverages[i];
                index = i;
            }
        }
        int minElement = 1000000;
        for(int i = 0; i < n; i++){
            if(minElement > myArray[i][index]) minElement = myArray[i][index];
        }
        System.out.println("Smallest number of a column with smallest average: " + minElement);
    }
}
