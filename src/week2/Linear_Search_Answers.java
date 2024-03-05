package week2;

public class Linear_Search_Answers {

    /**
     * Given a String str, return true if str is a palindrome, and false otherwise.
     * This method demonstrates linear time complexity, O(n),
     * where n is the length of the string.
     *
     * @param str The string to check for palindrome.
     * @return true if str is a palindrome, and false otherwise.
     */
    public static boolean ispalidrone(String str){
        // Edge case: if the string is empty or null, return false. Constant O(1)
        if (str == null || str.isEmpty()) {
            return false;
        }

        // Initialize two pointers, one at the start of the string, and the other at the end.
        int left = 0;
        int right = str.length() - 1;

        // Iterate through the string, comparing characters at the left and right pointers.
        while (left < right) {
            // If the characters at the left and right pointers are different, return false.
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            // Move the left pointer to the right, and the right pointer to the left.
            left++;
            right--;
        }

        // If the loop completes without returning false, the string is a palindrome.
        return true;
    }

    /**
     * Finds and returns the maximum value in an array.
     * This method demonstrates linear time complexity, O(n),
     * where n is the number of elements in the array.
     *
     * @param numbers The array of integers to search.
     * @return The maximum value found in the array.
     */
    public static int findMaximum(int[] numbers) {
        // Edge case: if the array is empty, return Integer.MIN_VALUE as indication
        if (numbers == null || numbers.length == 0) {
            return Integer.MIN_VALUE; // This value indicates that the array is empty or null.
        }

        // Initialize max with the first value of the array.
        int max = numbers[0];

        // Iterate through the array, starting from the second element.
        for (int i = 1; i < numbers.length; i++) {
            // If the current element is greater than max, update max.
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        // Return the largest number found in the array.
        return max;
    }

    /**
     * Given an array of integers, sort the array in-place.
     * This method demonstrates linear time complexity, O(n),
     * where n is the number of elements in the array.
     *
     * @param nums The array of integers to sort.
     */
    public static void sortColors(int[] nums) {
        // Edge case: if the array is empty or null, return without sorting.
        if (nums == null || nums.length == 0) {
            return;
        }

        // Initialize three pointers to keep track of the positions of 0, 1, and 2.
        int low = 0; // Pointer to the leftmost position of 0.
        int mid = 0; // Pointer to the current position being checked.
        int high = nums.length - 1; // Pointer to the rightmost position of 2.

        // Iterate through the array, moving the mid pointer until it reaches the high pointer.
        while (mid <= high) {
            // If the current element is 0, swap it with the element at the low pointer.
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            }
            // If the current element is 1, move the mid pointer to the next position.
            else if (nums[mid] == 1) {
                mid++;
            }
            // If the current element is 2, swap it with the element at the high pointer.
            else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }
}
