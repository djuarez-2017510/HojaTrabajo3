import java.io.*;
import java.util.*;

public class BucketSort<T extends Comparable<T>> implements ISort<T> {

    @Override
    public T[] sort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int n = arr.length;

        int numBuckets = 3;
        List<List<T>> buckets = new ArrayList<>(numBuckets);

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new LinkedList<>());
        }

        for (T element : arr) {
            int bucketIndex = (int) Math.floor(Double.parseDouble(element.toString()) / numBuckets);
            buckets.get(bucketIndex).add(element);
        }

        for (List<T> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (List<T> bucket : buckets) {
            for (T element : bucket) {
                arr[index++] = element;
            }
        }
        return arr;
    }
}