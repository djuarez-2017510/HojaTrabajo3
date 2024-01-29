import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        GnomeSort<Integer> gnomeSort = new GnomeSort<>();



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
            Scanner scanner = new Scanner(archivo);

            // Leer el archivo línea por línea y agregar los números al array
            while (scanner.hasNextLine() && indice < 3000) {
                String linea = scanner.nextLine();
                int numero = Integer.parseInt(linea);
                numerosArray[indice] = numero;
                indice++;
            }

        } catch (FileNotFoundException e) {
            // En caso de que el archivo no se encuentre
            e.printStackTrace();
        }



        gnomeSort.sort(numerosArray);
    }





    }

