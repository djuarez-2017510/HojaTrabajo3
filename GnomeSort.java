public class GnomeSort<T extends Comparable<T>> implements ISort<T>{
    @Override
    public T[] sort(T[] Arr) {
        int index = 0;
        int n = Arr.length;

        while (index < n) {
            if (index == 0)
                index++;
            if (Arr[index].compareTo(Arr[index - 1]) >= 0)
                index++;
            else {
                // Realizar el intercambio de elementos para un array genérico
                T temp = Arr[index];
                Arr[index] = Arr[index - 1];
                Arr[index - 1] = temp;
                index--;
            }
        }

        return Arr;


        }
    }

