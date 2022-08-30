package pkg;
import java.util.Scanner;
import java.util.Random;


public class BaseClass {
	
	public BaseClass() {
		
		
	}
	
	public static void Randomize(int[] arr){
		for(int c = 0; c < arr.length; c++){
			int a = (int)(Math.random()*200000);
			arr[c] = a;
		}
	}
	
	public static boolean Search(int[] arr){
		int random = (int)(Math.random()*200000);
		boolean equal = false;
		
		for(int c = 0; c < arr.length; c++){
			if(c == random){
				equal = true;
				break;
			} else {
				equal = false;
			}
		}
		
		return equal;
	}
	
	public static void bubbleSort(int [] arr){
		for(int outer = 0; outer < arr.length-1; outer++){
			for(int inner = 0; inner < arr.length-outer-1; inner++){
				if(arr[inner] > arr[inner+1]){
					int temp = arr[inner];
					arr[inner] = arr[inner+1];
					arr[inner+1] = temp;
				}
			}
		}
	}
	
	public static void selectionSort(int [] arr){
		int outer, inner, min_index;
		
		for(outer = 0; outer < arr.length; outer++){
			min_index = outer;
			for(inner = outer+1; inner < arr.length; inner++){
				if(arr[inner] < arr[min_index]){
					min_index = inner;
				}
			}
			int temp = arr[outer];
			arr[outer] = arr[min_index];
			arr[min_index] = temp;
		}
	}
	
	public static void insertionSort(int[] arr){
		int outer, inner, key;
		
		for(outer = 1; outer < arr.length; outer++){
			key = arr[outer];
			inner = outer-1;
			
			while(inner >= 0 && arr[inner] > key){
				arr[inner+1] = arr[inner];
				inner = inner - 1;
			}
			arr[inner+1] = key;
		}
	}

}
