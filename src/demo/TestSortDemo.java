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
//		radixSort(array, 3);
		System.out.println("排序后:" + SortUtil.printArray(array));
	}
	
	//冒泡排序
	public static void bubbleSort(int[] a){
		
		if(a == null || a.length == 0)
			return;
		
		for(int i = 0; i < a.length - 1; i++){
			for(int j = 0; j < a.length - 1 - i; j++){
				if(a[j] > a[j + 1]){
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	
	//选择排序
	public static void selectSort(int[] a){
		
		if(a == null || a.length == 0)
			return;
		
		for(int i = 0; i < a.length - 1; i++){
			
			int min = i;
			
			for(int j = i; j < a.length - 1; j++){
				if(a[j + 1] < a[min]){
					min = j + 1;
				}
			}
			
			if(min != i){
				int temp = a[min];
				a[min] = a[i];
				a[i] = temp;
			}
		}
	}
	
	//快速排序
	public static void quickSort(int[] a,int start,int end){
		
		if(a == null || a.length == 0)
			return;
		
		int i = start,j = end,key = a[i];
		
		while(i < j){
			
			//从后向前搜索比key小的值
			while(i < j && a[j] > key)
				j--;
			
			if(i < j){
				a[i] = a[j];
				i++;
			}
			
			//从前向后搜索比key大的值
			while(i < j && a[i] < key)
				i++;
			
			if(i < j){
				a[j] = a[i];
				j--;
			}
		}
		
		a[i] = key;
		
		//对比key小的部分进行快速排序
		if(i > start)
			quickSort(a, start, i - 1);
		//对比key大的部分进行快速排序
		if(j + 1 < end)
			quickSort(a, j + 1, end);
	}
	
	//归并排序
	public static void mergeSort(int[] a,int low,int high){
		
		if(a == null || a.length ==0 )
			return;
		
		int mid = (low + high) / 2;
		
		if(low < high){
			//对序列左半部分进行分组
			mergeSort(a, low, mid);
			//对序列右半部分进行分组
			mergeSort(a, mid + 1, high);
			//对左右两部分进行归并
			merge(a, low, mid, high);
		}
	}
	
	public static void merge(int[] a,int low,int mid,int high){
		
		if(a == null || a.length == 0)
			return;
		int[] temp = new int[high - low + 1];
		int i = low,j = mid + 1,k = 0;
		
		while(i <= mid && j <= high){
			if(a[i] < a[j]){
				temp[k++] = a[i++];
			}else{
				temp[k++] = a[j++];
			}
		}
		
		while(i <= mid)
			temp[k++] = a[i++];
		
		while(j <= high)
			temp[k++] = a[j++];
		
		for(int x = 0; x < temp.length; x++){
			a[low + x] = temp[x];
		}
	}
	
	//直接插入排序
	public static void directInsertSort(int[] a){
		
		if(a == null || a.length == 0)
			return;
		
		for(int i = 1; i < a.length; i++){
			int key = a[i];
			int j = i - 1;
			
			for(;j >= 0 && a[j] > key; j--)
				a[j + 1] = a[j];
			
			a[j + 1] = key;
		}
	}
	
	//希尔排序
	public static void shellSort(int[] a){
		
		if(a == null || a.length == 0)
			return;
		
		int step = a.length;
		
		while(step != 1){
			
			step = step / 2;
			for(int k = 0; k < step; k++){
				for(int i = k + step; i < a.length; i = i + step){
					int key = a[i];
					int j = i - step;
					for(;j >= 0 && a[j + 1] > key; j = j -step)
						a[j + step] = a[j];
					a[j + step] = key;
				}
			}
		}
	}
	
	//计数排序
	public static int[] countSort(int[] a){
		
		int[] b = new int[a.length];
		int min = a[0],max = a[0];
		for(int var : a){
			if(var < min){
				min = var;
			}
			
			if(var > max){
				max = var;
			}
		}
		int[] c = new int[max - min + 1];
		
		for(int i = 0; i < a.length; i++)
			c[a[i] - min]++;
		
		for(int i = 1; i < c.length; i++)
			c[i] = c[i] + c[i - 1];
		
		for(int i = 0; i < a.length; i++)
			b[--c[a[i] - min]] = a[i];
		
		return b;
	}
	
	//基数排序
	public static void radixSort(int[] a,int max){
		
		if(a == null || a.length == 0)
			return;
		
		int[][] temp = new int[10][a.length];
		int[] order = new int[10];
		int m = 1,n = 1,k = 0;
		
		while(m <= max){
			
			for(int i = 0; i < a.length; i++){
				int index = (a[i] / n) % 10;
				temp[index][order[index]] = a[i];
				order[index]++;
			}
			
			for(int i = 0; i < 10; i++){
				while(order[i] != 0){
					for(int j = 0; j < order[i]; j++){
						a[k] = temp[i][j];
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
}
