import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementación de Bucket Sort para ordenar un array de elementos comparables.
 *
 * @param <T> Tipo de elementos a ordenar, deben ser comparables entre sí.
 */
public class BucketSort<T extends Comparable<T>> implements ISort<T> {

    /**
     * Ordena el array utilizando el algoritmo Bucket Sort.
     *
     * @param arr El array que se va a ordenar.
     * @return El array ordenado.
     */
    @Override
    public T[] sort(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr; // No es necesario ordenar
        }

        bucketSort(arr);

        return arr;
    }

    /**
     * Implementación del algoritmo Bucket Sort.
     *
     * @param arr El array que se va a ordenar.
     */
    private void bucketSort(T[] arr) {
        int n = arr.length;
        T maxVal = findMaxValue(arr);

        List<T>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (T value : arr) {
            int index = getIndex(value, maxVal, n);
            buckets[index].add(value);
        }

        int currentIndex = 0;
        for (List<T> bucket : buckets) {
            Collections.sort(bucket);
            for (T value : bucket) {
                arr[currentIndex++] = value;
            }
        }
    }

    /**
     * Calcula el índice del cubo para un valor dado.
     *
     * @param value  El valor para el cual se calculará el índice del cubo.
     * @param maxVal El valor máximo en el array.
     * @param n      El tamaño del array.
     * @return El índice del cubo para el valor dado.
     */
    private int getIndex(T value, T maxVal, int n) {
        double normalizedValue = ((double) (value.compareTo(maxVal) + 1)) / (maxVal.compareTo(value) + 1);
        return (int) (normalizedValue * (n - 1));
    }

    /**
     * Encuentra el valor máximo en el array.
     *
     * @param arr El array del cual se busca el valor máximo.
     * @return El valor máximo en el array.
     */
    private T findMaxValue(T[] arr) {
        T max = arr[0];
        for (T value : arr) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }
}
