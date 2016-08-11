import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Sort {
	
	private static ArrayList<Integer> notOrderedList = new ArrayList<Integer>();
	private static int[] array1;
	private static int[] array2;
	
	public static void main (String[] args){
		
				
		/** LÊ ARQUIVO E COLOCA ELEMENTOS NA LISTA**/
		
		String file = args[0];
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	notOrderedList.add( Integer.parseInt(line) );
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/** CRIA A VERSÃO ARRAY **/
		array1 = new int[notOrderedList.size()];
		array2 = new int[notOrderedList.size()];
		int counter = 0;
		for (int n : notOrderedList) {
			array1[counter] = n;
			array2[counter] = n;
			counter++;
		}
		
		/** Insertion Sort **/
		ArrayList<Integer> ISOredered = SortingMethods.insertionSort(notOrderedList);
		
		/* ESCRITA EM ARQUIVO*/
		
		PrintWriter writer;
		try {
			writer = new PrintWriter("insertion_sort_ordered_list.txt", "UTF-8");
			for (Integer n : ISOredered) {
				writer.println(n);
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/** Selection Sort **/
		ArrayList<Integer> SSOredered = SortingMethods.selectionSort(notOrderedList);
		
		/* ESCRITA EM ARQUIVO*/
		
		PrintWriter writer2;
		try {
			writer2 = new PrintWriter("selection_sort_ordered_list.txt", "UTF-8");
			for (Integer n : SSOredered) {
				writer2.println(n);
			}
			writer2.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/** Quick Sort **/
		// Pivô arbitrariamente escolhido como sendo a moda
		QuickSort.quickSort(array1, 0, array1.length - 1, "mode");
		
		/* ESCRITA EM ARQUIVO*/
		
		PrintWriter writer3;
		try {
			writer3 = new PrintWriter("quick_sort_ordered_list.txt", "UTF-8");
			for (Integer n : array1) {
				writer3.println(n);
			}
			writer3.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/** Merge Sort **/
		MergeSort.Recursive(array2, 0, array2.length);
		
		/* ESCRITA EM ARQUIVO*/
		
		PrintWriter writer4;
		try {
			writer4 = new PrintWriter("merge_sort_ordered_list.txt", "UTF-8");
			for (Integer n : ISOredered) {
				writer4.println(n);
			}
			writer4.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
