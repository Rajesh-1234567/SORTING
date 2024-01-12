public class CountingSort {
    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        countingSort(array);
        
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    public static void countingSort(int[] array) {
        int max = Arrays.stream(array).max().orElse(0);
        int min = Arrays.stream(array).min().orElse(0);

        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[array.length];

        // Count the occurrences of each element
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }

        // Calculate the cumulative count
        
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        // Copy the sorted elements back to the original array
        System.arraycopy(output, 0, array, 0, array.length);
    }
}

