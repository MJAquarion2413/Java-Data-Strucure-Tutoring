package week3;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 1, 4 };
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    System.out.println(arr[j] + " < " + arr[minIndex]);
                    System.out.println(j);
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
