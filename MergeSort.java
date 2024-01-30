/**
 * Implementación genérica del algoritmo de ordenamiento Merge Sort para arreglos.
 *
 * @param <T> Tipo de elementos en el arreglo, debe ser comparable.
 */

public class MergeSort<T extends Comparable<T>> implements ISort<T> {
    /**
     * Ordena el arreglo utilizando el algoritmo Merge Sort.
     *
     * @param array Arreglo a ser ordenado.
     */
    public T[] sort(T[] array) {
        if (array == null || array.length <= 1) {
            return array; // Ya está ordenado
        }

        int length = array.length;
        int middle = length / 2;

        // Dividir el arreglo en dos mitades
        T[] leftArray = (T[]) new Comparable[middle];
        T[] rightArray = (T[]) new Comparable[length - middle];
        System.arraycopy(array, 0, leftArray, 0, middle);
        System.arraycopy(array, middle, rightArray, 0, length - middle);

        // Ordenar recursivamente cada mitad
        sort(leftArray);
        sort(rightArray);

        // Combinar las mitades ordenadas
        merge(array, leftArray, rightArray);
        return array;

    }

    /**
     * Combina dos mitades ordenadas en un solo arreglo ordenado.
     *
     * @param array      Arreglo original que se está combinando.
     * @param leftArray  Mitad izquierda ordenada.
     * @param rightArray Mitad derecha ordenada.
     */
    private void merge(T[] array, T[] leftArray, T[] rightArray) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copiar elementos restantes de leftArray, si los hay
        while (i < leftLength) {
            array[k++] = leftArray[i++];
        }

        // Copiar elementos restantes de rightArray, si los hay
        while (j < rightLength) {
            array[k++] = rightArray[j++];
        }
    }

}
