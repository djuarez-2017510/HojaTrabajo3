import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GnomeSort<Integer> gnomeSort = new GnomeSort<>();
        QuickSort <Integer> quickSort = new QuickSort<>();
        MergeSort<Integer> mergeSort= new MergeSort<>();
        RadixSort<Integer> radixSort = new RadixSort<>();
        BucketSort<Integer> bucketSort = new BucketSort<>();

        Scanner scanner = new Scanner(System.in);

        try {
            FileWriter writer = new FileWriter("random.txt");
            Set<Integer> numeros = new HashSet<>();
            Random random = new Random();
            while (numeros.size() < 3000) {
                int randomnum = random.nextInt(5001);
                if (numeros.add(randomnum)) {
                    writer.write(randomnum + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crear un array de tamaño 3000
        Integer[] numerosArray = new Integer[3000];
        int indice = 0;

        try {
            // Crear un objeto File para representar el archivo
            File archivo = new File("random.txt");

            // Crear un objeto Scanner para leer el archivo
            Scanner filescanner = new Scanner(archivo);

            // Leer el archivo línea por línea y agregar los números al array
            while (filescanner.hasNextLine() && indice < 3000) {
                String linea = filescanner.nextLine();
                int numero = Integer.parseInt(linea);
                numerosArray[indice] = numero;
                indice++;

            }


        } catch (FileNotFoundException e) {
            // En caso de que el archivo no se encuentre
            e.printStackTrace();
        }
        Integer[] numerosArrayCopia = Arrays.copyOf(numerosArray, numerosArray.length);

        // Ordenar el array copiado
        Arrays.sort(numerosArrayCopia);
      




        //gnomeSort.sort(numerosArray);
        //gnomeSort.sort(numerosArrayCopia);

        while (true) {

            System.out.println("\n*** Menú ***");
            System.out.println("\nEliga el sort que desea utilizar");
            System.out.println("1. Gnome sort");
            System.out.println("2. Merge sort");
            System.out.println("3. Quick sort");
            System.out.println("4. Radix sort");
            System.out.println("5. Bucket sort");
            System.out.println("0. Salir");

            try {
                
                int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                gnomeSort.sort(numerosArray);
                //Array ya ordenado
                gnomeSort.sort(numerosArrayCopia);

                    break;
                case 2:
                    mergeSort.sort(numerosArray);
                    //Array ya ordenado
                    mergeSort.sort(numerosArrayCopia);

                    break;
                case 3:
                    quickSort.sort(numerosArray);
                    //Array ya ordenado
                    quickSort.sort(numerosArrayCopia);

                    break;
                case 4:
                    radixSort.sort(numerosArray);
                    //Array ya ordenado
                    radixSort.sort(numerosArrayCopia);

                    break;
                case 5:
                    bucketSort.sort(numerosArray);
                    //Array ya ordenado
                    bucketSort.sort(numerosArrayCopia);
                    break;
                case 0:
                System.out.println("Saliendo del programa");
                System.exit(0);
                default:
                    System.out.println("No es una opción valida");
            }
            } catch (Exception e) {
                System.out.println("Debe ingresar un valor numerico");
                scanner.nextLine();
            }
        }
    }
}
