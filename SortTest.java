import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class SortTest {

    @Test
    public void testGnomeSort() {

        Integer[] arr = {4, 2, 6, 1, 9, 3, 8, 7, 5};
        GnomeSort<Integer> gnomeSort = new GnomeSort<>();

        // Llamar al método 
        gnomeSort.sort(arr);

        // Verificar que este ordenado correctamente
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSort() {
    
        Integer[] arr = {4, 3, 6, 8, 9, 2, 1, 5, 7};
        MergeSort<Integer> mergeSort = new MergeSort<>();

        // Llamar al método 
        mergeSort.sort(arr);

        // Verificar que este ordenado correctamente
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSort() {

        Integer[] arr = {5, 8, 3, 1, 9, 6, 2, 7, 4};
        QuickSort<Integer> quickSort = new QuickSort<>();

        // Llamar al método
        quickSort.sort(arr);

        // Verificar que este ordenado correctamente
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRadixSort() {
  
        Integer[] arr = {4, 6, 2, 1, 9, 5, 8, 7, 3};
        RadixSort<Integer> radixSort = new RadixSort<>();

        // Llamar al método
        radixSort.sort(arr);

        // Verificar que este ordenado correctamente
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testBucketSort() {

        Integer[] arr = {1, 3, 6, 4, 5, 2, 8, 7, 9};
        BucketSort<Integer> bucketSort = new BucketSort<>();

        // Llamar al método 
        bucketSort.sort(arr);

        // Verificar que este ordenado correctamente
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, arr);
    }
}