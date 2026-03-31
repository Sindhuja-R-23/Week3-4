import java.util.Arrays;

public class Problem6 {
    public static void main(String[] args) {
        int[] risks = {10, 25, 50, 100};
        Arrays.sort(risks);
        System.out.println("Sorted Risks: " + Arrays.toString(risks));

        // Linear Search
        linearSearch(risks, 30);

        // Binary Search for floor/ceiling
        binaryFloorCeiling(risks, 30);
    }

    static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Search: Found at index " + i + " (" + comparisons + " comparisons)");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Linear Search: Target not found (" + comparisons + " comparisons)");
        }
    }

    static void binaryFloorCeiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1, comparisons = 0;
        int floor = -1, ceiling = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (arr[mid] == target) {
                floor = arr[mid];
                ceiling = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceiling = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Binary Search: Floor=" + floor + ", Ceiling=" + ceiling +
                " (" + comparisons + " comparisons)");
    }
}
