package com.yourname;

import java.util.ArrayList;

public class OperationsApp {
  
  private static int myMaximum(final int[] a, int curUsage) {
	if(curUsage == 0) {
		return Integer.MIN_VALUE; // Returns this if empty array
	}
	int max = 0;
	for(int i = 0; i < a.length-1; i++) {
	  if(a[i] < a[i+1]) { // Checking if the element is greater than previous
		  max = a[i+1]; // If yes, max stores it
	  }
	}
	return max;
  }
  
  private static void appendArrayList(ArrayList<Integer> v, final ArrayList<Integer> w) {
	v.addAll(w); // Adds the arraylist to the current
	System.out.println("\n" + "The ArrayList after appending " + v);
  }
  
  private static int countOccurrences(final int[] v, int k) {
	int count = 0;
	for(int i = 0; i < v.length; i++) {
	  if(v[i] == k) {
		  ++count; // Counter to count
	  }
	}
	return count;  
  }
  
  private static boolean isAllZeros(final int[][] a) {
	  
	 if(a.length == 0) {
		 return false;
	 }
	 boolean zeros = false;
	 for(int i = 0; i < 10; i++) {
		for(int j = 0; j < 20; j++) {
		  if(a[i][j] == 0) {
			  zeros = true;
		  }
		}
	  }
	return zeros;  
  }
  
  private static boolean areIdentical(final int[] a, final int[] b) {
	if(a.length != b.length) {
		return false;
	}
	
	for(int i = 0; i < a.length; i++) {
		if(a[i] != b[i]) {
		  return false;
		}
	}
	return true;  
  }
  
  private static double myAverage (final int[] v) {
	if(v.length == 0) {
		return 0;
	}
	int sum = 0;
	for(int i = 0; i < v.length; i++) {
	  sum = sum + v[i];
	}
	return (double)sum/v.length;
  }
  
  private static boolean isStrictlyIncreasing(final int[] v) {
	boolean isIncrease = false; 
	for(int i = 0; i < v.length-1; i++) {
      if(v[i] < v[i+1]) { // Checking if next element is bigger
    	  isIncrease = true;
      }
      else {
    	  isIncrease = false;
      }
	}
	return isIncrease;  
  }
  
  private static void reverseArray(int[] v) {
	  System.out.println("\n" + "The array before reversal");
	  for(int i = 0; i < v.length; i++) {
	      System.out.print(v[i] + " ");
	  }
	  //Swapping
	  for (int i = 0; i < v.length / 2; i++) {
		  int temp = v[i];
		  v[i] = v[v.length - 1 - i];
		  v[v.length - 1 - i] = temp;
	  }
	  System.out.println("\n" + "The array after reversal");
	  for(int i = 0; i < v.length; i++) {
	      System.out.print(v[i] + " ");
	  }
  }
  
  public static void main(String[] args) {
  // Test the above methods with sample data
	  //Test 1 - Maximyum in array
	  final int[] arr = {1,5,3,7,5};
	  final int[] emptyArr = {};
	  int maxOfArr = myMaximum(arr,arr.length);
	  System.out.println("Maximum number in array is " + maxOfArr);
	  int maxOfEmptyArr = myMaximum(emptyArr,emptyArr.length);
	  System.out.println("Maximum number in empty array is " + maxOfEmptyArr);
	  
	  //Test 2 - Append arraylist
	  ArrayList<Integer> a = new ArrayList<>();
	  a.add(4);
	  a.add(2);
	  a.add(5);
	  final ArrayList<Integer> b = new ArrayList<>();
	  b.add(11);
	  b.add(3);
	  appendArrayList(a, b);
	  
	  //Test 3 - Counting occurences
	  int num = 5;
	  int noOfOcc = countOccurrences(arr, num);
	  System.out.println("\n\n" + "The number of occurences of " + num
	     + " is " + noOfOcc);
	  
	  //Test 4 - Is all zeros checking
	  int[][] zeroArr = new int[10][20];
	  for(int i = 0; i < 10; i++) {
		  for(int j = 0; j < 20; j++) {
		    zeroArr[i][j] = 0;
		  }
	  }
	  System.out.println("\n" + "Checking for zeros in a zeros array is " 
	     + isAllZeros(zeroArr));
	  int[][] nonZeroArr = new int[10][20];
	  for(int i = 0; i < 10; i++) {
		  for(int j = 0; j < 20; j++) {
		    nonZeroArr[i][j] = 5;
		  }
	  }
	  System.out.println("Checking for zeros in non-zeros array is " 
			     + isAllZeros(nonZeroArr));
	  int[][] emp2dArr = {};
	  System.out.println("Checking for zeros in empty array is " 
			     + isAllZeros(emp2dArr));
	  
	  //Test 5 - Are arrays identical?
	  final int[] incArr = {1,2,3,4,5};
	  System.out.println("\n" + "While passing identical arrays, the result is "
			  	 + areIdentical(arr,arr));
	  System.out.println("While passing non-identical arrays, the result is "
			     + areIdentical(arr,incArr));
	  System.out.println("While passing empty arrays, the result is "
			     + areIdentical(emptyArr,emptyArr));
	  
	  //Test 6 - Average of arrays
	  System.out.println("\n" + "The average of the array is " + myAverage(arr));
	  System.out.println("Passing an empty array gives an average of "
			     + myAverage(emptyArr));
	  
	  //Test 7 - Is arrays increasing?
	  System.out.println("\n" + "While passing increasing array, the result is "
	     + isStrictlyIncreasing(incArr));
	  System.out.println("While passing non-increasing array, the result is "
		 + isStrictlyIncreasing(arr));
	  
	  //Test 8 - Reverse an array within it
      reverseArray(arr);
  }
}
