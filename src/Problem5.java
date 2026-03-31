import java.util.Arrays;

public class Problem5 {
    public static void main(String[] args) {
        String[] logs = {"accB", "accA", "accB", "accC"};

        // Linear Search
        linearSearch(logs, "accB");

        // Sort logs for Binary Search
        Arrays.sort(logs);
        System.out.println("Sorted Logs: " + Arrays.toString(logs));

        // Binary Search
        binarySearch(logs, "accB");
    }

    static void linearSearch(String[] arr, String target) {
        int comparisons = 0;
        int firstIndex = -1, lastIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                if (firstIndex == -1) firstIndex = i;
                lastIndex = i;
            }
        }
        if (firstIndex != -1) {
            System.out.println("Linear Search: First occurrence at index " + firstIndex +
                    ", Last occurrence at index " + lastIndex +
                    " (" + comparisons + " comparisons)");
        } else {
            System.out.println("Linear Search: Target not found (" + comparisons + " comparisons)");
        }
    }

    static void binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1, comparisons = 0;
        int foundIndex = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (arr[mid].equals(target)) {
                foundIndex = mid;
                break;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (foundIndex != -1) {
            int count = 1;
            int left = foundIndex - 1;
            while (left >= 0 && arr[left].equals(target)) { count++; left--; }
            int right = foundIndex + 1;
            while (right < arr.length && arr[right].equals(target)) { count++; right++; }
            System.out.println("Binary Search: Found at index " + foundIndex +
                    ", Count=" + count + " (" + comparisons + " comparisons)");
        } else {
            System.out.println("Binary Search: Target not found (" + comparisons + " comparisons)");
        }
    }
}
