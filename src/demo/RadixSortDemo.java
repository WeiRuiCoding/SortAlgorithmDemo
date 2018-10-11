package demo;

import bean.SortUtil;

/** 
 * @ClassName: RadixSortDemo 
 * @Description: 基数排序测试DEMO
 * @author HongDa
 * @date 2018年9月26日 下午3:25:08 
 */
public class RadixSortDemo {
	public static void main(String[] args){
		
		int[] array = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81};

		System.out.println("排序前:" + SortUtil.printArray(array));
		radixSort(array, 2);
		System.out.println("排序后:" + SortUtil.printArray(array));
	}
	
	/**
	 * @Description 基数排序算法
	 * @author HongDa
	 * @version 1.1.0
	 * @date 2018年9月26日 下午6:39:00
	 * @param array
	 * @param max
	 * @throws
	 */
	public static void radixSort(int[] array,int max){
		
		int k = 0;
		int m = 1;//代表数值的位数
		int n = 1;//用于辅助计算m位上数值的值
		
		int[][] temp = new int[10][array.length];
		int[] order = new int[10];
		
		while(m <= max){
			
			//按照位数对数组进行桶[0-9]存储
			for(int i = 0; i < array.length; i++){
				int lsd = (array[i] / n) % 10;
				temp[lsd][order[lsd]] = array[i];
				order[lsd]++;
			}
			
			//对桶中的数据遍历按照桶中的位置重新存入原数组
			for(int i = 0; i < 10; i++){
				if(order[i] != 0){
					for(int j = 0; j < order[i]; j++){
						array[k] = temp[i][j];
						k++;
					}
					order[i] = 0;
				}
			}
			
			n = n * 10;
			k = 0;
			m++;
		}
	}
}
