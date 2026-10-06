import java.util.Arrays;
import java.util.Random;

public class Sorting {

    static int[] generateArray(int length, int min, int max) {
        Random rnd = new Random();
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = min + rnd.nextInt(max - min + 1);
        }
        return a;
    }

    static void printArray(int[] a) {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < a.length; i++) {
            sb.append("[").append(a[i]).append("]");
            if (i < a.length - 1) sb.append(",");
        }
        sb.append("}");
        System.out.println(sb);
    }

    static boolean wrongOrder(int x, int y, boolean ascending) {
        return ascending ? x > y : x < y;
    }

    static void bubbleSort(int[] a, boolean ascending) {
        for (int pass = 0; pass < a.length - 1; pass++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - pass; j++) {
                if (wrongOrder(a[j], a[j + 1], ascending)) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break; 
        }
    }

    static void insertionSort(int[] a, boolean ascending) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && wrongOrder(a[j], key, ascending)) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    static void selectionSort(int[] a, boolean ascending) {
        for (int i = 0; i < a.length - 1; i++) {
            int best = i; 
            for (int j = i + 1; j < a.length; j++) {
                if (wrongOrder(a[best], a[j], ascending)) {
                    best = j;
                }
            }
            int tmp = a[i];
            a[i] = a[best];
            a[best] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] original = generateArray(1000, -500, 500);
        System.out.println("Original array:");
        printArray(original);

        int[] a = Arrays.copyOf(original, original.length);
        bubbleSort(a, true);
        System.out.println("\nBubble sort (ascending):");
        printArray(a);

        a = Arrays.copyOf(original, original.length);
        bubbleSort(a, false);
        System.out.println("\nBubble sort (descending):");
        printArray(a);

        a = Arrays.copyOf(original, original.length);
        insertionSort(a, true);
        System.out.println("\nInsertion sort (ascending):");
        printArray(a);

        a = Arrays.copyOf(original, original.length);
        insertionSort(a, false);
        System.out.println("\nInsertion sort (descending):");
        printArray(a);

        a = Arrays.copyOf(original, original.length);
        selectionSort(a, true);
        System.out.println("\nSelection sort (ascending):");
        printArray(a);

        a = Arrays.copyOf(original, original.length);
        selectionSort(a, false);
        System.out.println("\nSelection sort (descending):");
        printArray(a);
    }
}