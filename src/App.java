import java.util.concurrent.Callable;

import controllers.ShortMetodos;
import models.Results;

public class App {
    public static void main(String[] args) {
        /*
         * long inicio = System.nanoTime();
         * for (int i = 0; i < 100000; i++) {
         * String s = "Numero: " + i;
         * System.out.println(s);
         * }
         * 
         * long fin = System.nanoTime();
         * 
         * long tiempoNano = fin - inicio;
         * double tiempoSeg = tiempoNano / 1_000_000_000.0;
         * System.out.println("Tiempo transcurrido: " + tiempoNano + " nanos");
         * System.out.println("Tiempo transcurrido: " + tiempoSeg + " segundos");
         * 
         * Results result = new Results(1, "Imprimir 100000 numeros", (int) tiempoSeg);
         * 
         * System.out.println(result.toString());
         */

        int[] originalArray = generate(50000);

        int[] array1000 = new int[1000];
        System.arraycopy(originalArray, 0, array1000, 0, 1000);

        int[] array5000 = new int[5000];
        System.arraycopy(originalArray, 0, array5000, 0, 5000);

        int[] array10000 = new int[10000];
        System.arraycopy(originalArray, 0, array10000, 0, 10000);

        int[][] arrays = { array1000, array5000, array10000, originalArray };

        ShortMetodos sorter = new ShortMetodos();

        System.out.println("===== RESULTADOS DE ORDENAMIENTO =====");

        for (int[] array : arrays) {

            int size = array.length;
            System.out.println("\n--- Tamaño del array: " + size + " ---");

            
            Callable<Void> funBubble = () -> {
                sorter.sortBubble(array.clone());
                return null;
            };
            Results rBubble = Benchmark.medir_tiempo(funBubble, size);
            System.out.println(rBubble);

           
            Callable<Void> funBubbleM = () -> {
                sorter.sortBubbleMejorado(array.clone());
                return null;
            };
            Results rBubbleM = Benchmark.medir_tiempo(funBubbleM, size);
            System.out.println(rBubbleM);

            
            Callable<Void> funShell = () -> {
                sorter.sortShell(array.clone());
                return null;
            };
            Results rShell = Benchmark.medir_tiempo(funShell, size);
            System.out.println(rShell);

           
            Callable<Void> funMerge = () -> {
                sorter.sortMerge(array.clone());
                return null;
            };
            Results rMerge = Benchmark.medir_tiempo(funMerge, size);
            System.out.println(rMerge);
        }
    }

    public static void function1() {
        for (int i = 0; i < 100000; i++) {
            String s = "Numero: " + i;
            System.out.println(s);
        }
    }

    public static int[] generate(int size) {
        int[] numeros = new int[size];
        for (int i = 0; i < size; i++) {
            numeros[i] = (int) (Math.random() * 1000);
        }
        return numeros;
    }
}
