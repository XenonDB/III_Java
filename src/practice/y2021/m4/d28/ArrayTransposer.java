package practice.y2021.m4.d28;

public class ArrayTransposer {

	public static void main(String[] args) {
		
		int[][] arr = {
				{7,4,5,2,6},
				{7,8,9,8},
				{4,6,2,2},
				{3,3},
				{7,8},
				{8,7}
		};
		
		printArray(arr);
		arr = transpose(arr);
		System.out.println();
		if(arr != null)printArray(arr);
		
	}
	
	/**
	 * 可轉置矩陣的條件為：
	 * 對於任意的i: 0<=i<arr.length,任意的j: i<j<arr.length 皆有以下特性:
	 * arr[i].length >= arr[j].length
	 * */
	public static int[][] transpose(int[][] arr) {
		
		if(arr == null || arr.length < 1) return arr;
		
		if(!canTranspose(arr)) {
			System.out.println("無法轉置的二維陣列");
			return null;
		}
		
		int[][] newarr = new int[arr[0].length][];
		int[] newTmpArr;
		
		for(int i, j = 0 ; j < newarr.length ; j++) {
			i = 0;
			try {
				while(true) {
					test(arr[i][j]);
					i++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {}
			
			newTmpArr = new int[i];
			
			for(int k = 0 ; k < i ; k++) {
				newTmpArr[k] = arr[k][j];
			}
			newarr[j] = newTmpArr;
		}
		
		return newarr;
	}
	
	private static boolean canTranspose(int[][] arr) {
		boolean flag = true;
		int maxLength = arr[0].length;
		for(int i = 1 ; i < arr.length ; i++) {
			flag = maxLength >= arr[i].length;
			if(!flag) break;
			maxLength = arr[i].length;
		}
		return flag;
	}
	
	public static void printArray(int[][] arr) {
		for(int[] i : arr) {
			for(int j : i) {
				System.out.printf("%d ",j);
			}
			System.out.println();
		}
	}

	//單純用作嘗試存取二維陣列特定位置的測試函數
	private static void test(int a) {
		
	}
	
}
