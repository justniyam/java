import java.util.Scanner;

public class TwoDArrayOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] array = acceptArray(rows, cols);

        System.out.println("Entered 2D array:");
        displayArray(array);

        System.out.print("Enter the first row number to exchange: ");
        int row1 = scanner.nextInt();
        System.out.print("Enter the second row number to exchange: ");
        int row2 = scanner.nextInt();
        exchangeRows(array, row1, row2);

        System.out.println("Array after exchanging rows:");
        displayArray(array);

        System.out.print("Enter the row number to sort: ");
        int sortRowNum = scanner.nextInt();
        sortRow(array, sortRowNum);

        System.out.println("Array after sorting the given row:");
        displayArray(array);

        System.out.print("Enter the row number to find the largest element: ");
        int rowNum = scanner.nextInt();
        int largestElement = largestElementInRow(array, rowNum);
        System.out.println("Largest element in the row: " + largestElement);

        System.out.print("Enter the row number to find the sum of elements: ");
        rowNum = scanner.nextInt();
        int sumOfRow = sumOfRow(array, rowNum);
        System.out.println("Sum of elements in the row: " + sumOfRow);

        int totalSum = totalSum(array);
        System.out.println("Total sum using the above method: " + totalSum);

        int principalDiagonalSum = principalDiagonalSum(array);
        System.out.println("Principal diagonal sum: " + principalDiagonalSum);

        int secondaryDiagonalSum = secondaryDiagonalSum(array);
        System.out.println("Secondary diagonal sum: " + secondaryDiagonalSum);
    }

    public static int[][] acceptArray(int rows, int cols) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            System.out.print("Enter " + cols + " elements for row " + (i + 1) + ": ");
            for (int j = 0; j < cols; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        return arr;
    }

    public static void displayArray(int[][] arr) {
        for (int[] row : arr) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void exchangeRows(int[][] arr, int row1, int row2) {
        int[] temp = arr[row1 - 1];
        arr[row1 - 1] = arr[row2 - 1];
        arr[row2 - 1] = temp;
    }

    public static void sortRow(int[][] arr, int row) {
        Arrays.sort(arr[row - 1]);
    }

    public static int largestElementInRow(int[][] arr, int row) {
        int max = Integer.MIN_VALUE;
        for (int element : arr[row - 1]) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public static int sumOfRow(int[][] arr, int row) {
        int sum = 0;
        for (int element : arr[row - 1]) {
            sum += element;
        }
        return sum;
    }

    public static int totalSum(int[][] arr) {
        int sum = 0;
        for (int[] row : arr) {
            for (int element : row) {
                sum += element;
            }
        }
        return sum;
    }

    public static int principalDiagonalSum(int[][] arr) {
        int sum = 0;
        int minSize = Math.min(arr.length, arr[0].length);
        for (int i = 0; i < minSize; i++) {
            sum += arr[i][i];
        }
        return sum;
    }

    public static int secondaryDiagonalSum(int[][] arr) {
        int sum = 0;
        int rows = arr.length;
        int cols = arr[0].length;
        int minSize = Math.min(rows, cols);
        for (int i = 0; i < minSize; i++) {
            sum += arr[i][cols - i - 1];
        }
        return sum;
    }
}
