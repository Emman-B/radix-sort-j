package rsort;
import java.util.Random;
import java.util.ArrayList;

import java.text.NumberFormat;

public class TestA
{
    public static void main(String[] args)
    {
        // generate random 100 int array
        int[] array = generateRandomArray(10, Integer.MAX_VALUE);
        printArray(array);
        System.out.println();
        RadixSorter.sort(array);
        printArray(array);
        for (int i = 0; i < array.length - 1; i++)
        {
           if (array[i] > array[i] + 1)
           {
              throw new RuntimeException("Test failed: " + array[i] + " < " + array[i+1]);
           }
        }
    }

    // HELPER FUNCTIONS
    private static int[] generateRandomArray(int length, int max)
    {
        if (length < 0) throw new RuntimeException("Invalid length");
        int[] array = new int[length];
        Random rng = new Random();
        for (int i = 0; i < length; i++)
        {
            array[i] = rng.nextInt(max);
        }
        return array;
    }
    private static void printArray(int[] array)
    {
        String printedArray = "[";
        for (int i = 0; i < array.length; i++)
        {
            String result = NumberFormat.getIntegerInstance().format(array[i]);
            if (i != array.length - 1)
            {
                printedArray += result + "   ";
            }
            else
            {
                printedArray += result;
            }
        }
        printedArray += "]";
        System.out.println(printedArray);
    }
}