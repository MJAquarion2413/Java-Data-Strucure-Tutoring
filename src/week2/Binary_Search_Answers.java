package week2;

public class Binary_Search_Answers {
    /**
     * Given an interger x, return the square root of x.
     * If x is not a perfect square, return the integer part of the square root.
     * This method demonstrates logarithmic time complexity, O(log n),
     * where n is the value of x.
     *
     * @param x
     * @return greatest number with square less than or equal to x
     */
    public int mySqrt(int x) {
        // Edge case: if x is 0 or 1, return x.
        if (x == 0 || x == 1) {
            return x;
        }

        // Initialize the left and right pointers.
        int left = 1;
        int right = x;

        // Iterate through the array, starting from the second element.
        while (left <= right) {
            // Calculate the mid point.
            int mid = left + (right - left) / 2;

            // If the mid point is the square root, return mid.
            if (mid == x / mid) {
                return mid;
            }

            // If the mid point is less than the square root, move the left pointer to mid + 1.
            if (mid < x / mid) {
                left = mid + 1;
            } else {
                // If the mid point is greater than the square root, move the right pointer to mid - 1.
                right = mid - 1;
            }
        }

        // If the loop completes without finding the square root, return right.
        return right;
    }
}
