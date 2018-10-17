package demo;

import bean.SortUtil;

/**
 * @ClassName: TestSortDemo
 * @Description: 测试排序算法DEMO
 * @author HongDa
 * @date 2018年9月25日 下午5:48:53
 */
public class TestSortDemo {
	public static void main(String[] args) {
		
		int[] array = { 72, 33, 56, 81, 22, 65, 15, 99, 100 };
		System.out.println("排序前:" + SortUtil.printArray(array));
//		bubbleSort(array);
//		selectSort(array);
//		quickSort(array, 0, array.length - 1);
//		mergeSort(array, 0, array.length - 1);
//		directInsertSort(array);
//		shellSort(array);
//		System.out.println("排序后:" + SortUtil.printArray(countSort(array)));
		radixSort(array, 3);
		System.out.println("排序后:" + SortUtil.printArray(array));
	}
	
	//计数排序
	public static void radixSort(int[] array,int max){
		
		if(array == null || array.length == 0)
			return;
		
		int[][] temp = new int[10][array.length];
		int[] order = new int[10];
		
		int m = 1,n = 1,k = 0;
		
		while(m <= max){
			
			for(int i = 0; i < array.length; i++){
				int index = (array[i] / n) % 10;
				temp[index][order[index]] = array[i];
				order[index]++;
			}
			
			for(int i = 0; i < 10; i++){
				while(order[i] != 0){
					for(int j = 0; j < order[i]; j++){
						array[k] = temp[i][j];
						k++;
					}
					order[i] = 0;
				}
			}
			
			m++;
			n *= 10;
			k = 0;
		}
	}
	
	//计数排序
	public static int[] countSort(int[] array){
		
		int[] b = new int[array.length];
		int min = array[0],max = array[0];
		for(int a : array){
			if(a < min)
				min = a;
			if(a > max)
				max = a;
		}
		int[] c = new int[max - min + 1];
		
		for(int i = 0; i < array.length; i++)
			c[array[i] - min]++;
		
		for(int i = 1; i < c.length; i++)
			c[i] = c[i] + c[i - 1];
		
		for(int i = 0; i < array.length; i++)
			b[--c[array[i] - min]] = array[i];
		
		return b;
	}
	
	//希尔排序
	public static void shellSort(int[] array){
		
		if(array == null || array.length == 0)
			return;
		
		int step = array.length;
		
		while(step != 1){
			
			step = step / 2;
			
			for(int k = 0; k < step; k++){
				for(int i = k + step; i < array.length; i = i + step){
					int key = array[i];
					int j = i - step;
					for(;j >= 0 && array[j] > key; j = j - step)
						array[j + step] = array[j];
					array[j + step] = key;
				}
			}
		}
	}
	
	//直接插入排序
	public static void directInsertSort(int[] array){
		
		if(array == null || array.length == 0)
			return;
		
		for(int i = 1; i < array.length; i++){
			int key = array[i];
			int j = i - 1;
			for(;j >= 0 && array[j] > key; j--)
				array[j + 1] = array[j];
			array[j + 1] = key;
		}
	}
	
	//归并排序
	public static void mergeSort(int[] array,int low,int high){
		
		if(array == null || array.length == 0)
			return;
		
		int mid = (low + high) / 2;
		
		if(low < high){
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}
	
	public static void merge(int[] array,int low,int mid,int high){
		
		if(array == null || array.length == 0)
			return;
		
		int[] temp = new int[high - low + 1];
		int i = low,j = mid + 1,k = 0;
		
		while(i <= mid && j <= high){
			if(array[i] < array[j])
				temp[k++] = array[i++];
			else
				temp[k++] = array[j++];
		}
		
		while(i <= mid)
			temp[k++] = array[i++];
		
		while(j <= high)
			temp[k++] = array[j++];
		
		for(int x = 0; x < temp.length; x++){
			array[low + x] = temp[x];
		}
	}
	
	//快速排序
	public static void quickSort(int[] array,int start,int end){
		
		if(array == null || array.length == 0)
			return;
		
		int i = start,j = end,key = array[i];
		
		while(i < j){
			
			while(i < j && array[j] > key)
				j--;
			if(i < j){
				array[i] = array[j];
				i++;
			}
			
			while(i < j && array[i] < key)
				i++;
			if(i < j){
				array[j] = array[i];
				j--;
			}
		}
		
		array[i] = key;
		
		if(i > start)
			quickSort(array, start, i - 1);
		if(j + 1 < end)
			quickSort(array, j + 1, end);
	}
	
	//选择排序
	public static void selectSort(int[] array){
		
		if(array == null || array.length == 0)
			return;
		
		for(int i = 0; i < array.length - 1; i++){
			int min = i;
			for(int j = i; j < array.length - 1; j++){
				if(array[j + 1] < array[min]){
					min = j + 1;
				}
			}
			if(min != i){
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
		}
	}
	
	//冒泡排序
	public static void bubbleSort(int[] array){
		
		if(array == null || array.length == 0)
			return;
		
		for(int i = 0; i < array.length - 1; i++){
			for(int j = 0; j < array.length - 1 - i; j++){
				if(array[j] > array[j + 1]){
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
}
