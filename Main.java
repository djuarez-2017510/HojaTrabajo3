import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
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

        // Press Mayús+F10 or click the green arrow button in the gutter to run the code.

    }
}
