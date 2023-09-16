import java.util.ArrayList;
import java.util.List;

public class FindSumZeroElements {
    // Time Complexity O(n^2) and Space complexity O(1).
    public static List<Integer> findElementsSumToZero(int[] arr) {
        List<Integer> result = new ArrayList<>();

        // Check for edge case with no elements
        if (arr.length == 0) {
            result.add(0); // Adding 0 to indicate "No Elements found"
            return result;
        }

        // Iterate through the array and find a pair of elements whose sum is 0
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    result.add(arr[i]);
                    result.add(arr[j]);
                    return result;
                }
            }
        }

        // If no such pair is found, add 0 to indicate "No Elements found"
        result.add(0);
        return result;
    }

    public static void main(String[] args) {
        int[] inputArray = { -4, 1, 3, -2, -1 };
        List<Integer> result = findElementsSumToZero(inputArray);

        if (result.get(0) == 0) {
            System.out.println("No Elements found");
        } else {
            System.out.println("Elements whose sum is 0: " + result);
        }
    }
}