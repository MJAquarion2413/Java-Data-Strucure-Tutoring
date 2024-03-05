package week3;

public class Shell_Sort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 1, 4 };
        shellSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}
