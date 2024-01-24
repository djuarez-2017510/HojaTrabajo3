import java.io.*;
import java.util.*;
import java.lang.Comparable;
public interface ISort<T extends Comparable<T>> {
    public T[] sort(T[] Arr);
}
