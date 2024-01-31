import java.util.Arrays;

public class RadixSort<T extends Comparable<T>> implements ISort<T> {

    @Override
    public T[] sort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int maxDigits = findMaxDigits(arr);

        for (int exp = 1; exp <= maxDigits; exp *= 10) {
            countingSort(arr, exp);
        }

        return arr;
    }

    private void countingSort(T[] arr, int exp) {
        int n = arr.length;
        T[] output = Arrays.copyOf(arr, n);

        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (T element : arr) {
            int index = getDigit(element, exp);
            count[index]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = getDigit(arr[i], exp);
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    private int getDigit(T element, int exp) {
        int value = Integer.parseInt(element.toString());
        return (value / exp) % 10;
    }

    private int findMaxDigits(T[] arr) {
        int maxDigits = 0;
        for (T element : arr) {
            int numDigits = element.toString().length();
            maxDigits = Math.max(maxDigits, numDigits);
        }
        return maxDigits;
    }
}
