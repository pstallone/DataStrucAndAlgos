package arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ArrayAlgos {

	HashMap<Integer, Boolean> valMap = new HashMap<>();
	
	public ArrayAlgos() {
		
	}
	
	boolean findTwoValsSumToK(int[] arrayOfInts, int K) {
		
		// populate map
		for (Integer ival : arrayOfInts) {
			valMap.put(ival, true);
		}
		
		for (Integer ival : arrayOfInts) {
			int a = K - ival;
			// do not add to itself
			if (valMap.containsKey(a) && (a != ival)) {
				System.out.println("The two values that sum to " + K + " are: " + a + " and " + ival);
				return true;
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		final int MAX = 10; 
		int[] arrOfInts = new int[MAX];
		Random rand = new Random();
		for (int i=0; i < MAX; i++) {
			int rval = rand.nextInt(100);
			arrOfInts[i] = rval;
		}
		System.out.println(Arrays.toString(arrOfInts));
		ArrayAlgos arrAlgos = new ArrayAlgos();
		// make K equal to two ints in the array to test
		int K = arrOfInts[2] + arrOfInts[4];
		if (!arrAlgos.findTwoValsSumToK(arrOfInts, K)) {
			System.out.print("No two values in array add up to " + K);
		}
		
		
	}
}
