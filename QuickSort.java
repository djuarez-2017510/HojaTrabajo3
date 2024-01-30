/**
 * Implementación de la interfaz ISort que utiliza el algoritmo QuickSort
 * para ordenar un array de elementos comparables.
 *
 * @param <T> Tipo de elementos que se deben ordenar (debe ser Comparable).
 */

public class QuickSort<T extends Comparable<T>> implements ISort<T> {

    /**
     * Ordena el array utilizando el algoritmo QuickSort.
     *
     * @param arr Array que se va a ordenar.
     * @return Array ordenado.
     */
    @Override
    public T[] sort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        quickSort(arr, 0, arr.length - 1);

        return arr;
    }

    /**
     * Método auxiliar para realizar el ordenamiento QuickSort recursivo.
     *
     * @param arr   Array que se está ordenando.
     * @param low   Índice más bajo del subarray actual.
     * @param high  Índice más alto del subarray actual.
     */
    private void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            // Obtener el índice de partición
            int pi = partition(arr, low, high);

            // Ordenar los elementos antes y después de la partición
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Dividira el array utilizando el último elemento como pivote. Coloca
     * los elementos menores que el pivote a la izquierda y los elementos
     * mayores a la derecha.
     *
     * @param arr   Array que se dividira
     * @param low   Índice más bajo del subarray que se está particionando.
     * @param high  Índice más alto del subarray que se está particionando.
     * @return      Índice de la posición final del pivote en el array.
     */
    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;

                // Intercambiar arr[i] y arr[j]
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambiar arr[i + 1] y arr[high]
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

