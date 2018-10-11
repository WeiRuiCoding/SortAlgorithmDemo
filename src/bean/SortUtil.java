package bean;

/** 
 * @ClassName: SortUtil 
 * @Description: 排序工具类
 * @author HongDa
 * @date 2018年9月21日 下午3:08:38 
 */
public class SortUtil {
	
	public static String printArray(int[] array){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		
		for(int i = 0; i < array.length; i++){
			if(i != array.length - 1){
				sb.append(array[i]);
				sb.append("-");
			}else{
				sb.append(array[i]);
			}
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
