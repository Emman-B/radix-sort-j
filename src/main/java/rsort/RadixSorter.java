package rsort;

import java.util.Random;
import java.util.ArrayList;

public class RadixSorter {
    public static void sort(int[] array)
    {
		ArrayList[] bucket = new ArrayList[10]; //10 array lists for each integer

		int maxDigits = 0; //if largest number is 5, this is 1; if it's 10, this is 2, etc
		//maxDigits will be used to decide how often to add to the bucket and to remove from it

		//bucket initialization
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList<Integer>();//initialization
		}

		//redefining maxDigits
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if(max < array[i]) {
				max = array[i];
			}
			maxDigits = String.valueOf(max).length();
		}

		//placing numbers into buckets
		for (int d = 0; d < maxDigits; d++) {
			for (int n = 0; n < array.length; n++) {
				try {
					bucket[getDigit(array[n], d)].add(array[n]);
				} catch (Exception e) {
					bucket[0].add(array[n]); //justs adds to bucket 0
				}
			}

			//putting it back into the array 
			//ai = array index, bi = bucket index, ci = bucket content index
			int ai = 0;
			for (int bi = 0; bi < bucket.length; bi++) { //accessing all buckets
				for (int ci = 0; ci < bucket[bi].size(); ci++) { //accessing each bucket's contents
					array[ai] = (Integer)bucket[bi].get(ci);
					ai++;
				}
			}
			
			for (int i = 0; i < bucket.length; i++) {
				bucket[i].clear();
			}
		}
	}

    // HELPER FUNCTION
	private static int getDigit(int number, int index) {
		//Note that this is somewhat reversed
		//getDigit(5932, 2) will return 9 for example
		String s = String.valueOf(number);
		char c = s.charAt(s.length() - 1 - index);
		return Character.getNumericValue(c);
	}
}
