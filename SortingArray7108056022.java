

public class SortingArray7108056022 extends SortingArray{
	
	public void QuickSort(int[] arr, int left, int right)
	{
		int i, j, s , Temp;
	    if(left < right) {
	        s = arr[(left+right)/2];
	        i = left - 1;
	        j = right + 1;
	        while(true) {
	            while(arr[++i] < s) ;  
	            while(arr[--j] > s) ;  
	            if(i >= j) break;
	               Temp = arr[i];
	               arr[i] = arr[j];
	               arr[j] = Temp;
	        }
	        QuickSort(arr, left, i-1);   
	        QuickSort(arr, j+1, right);  
	    }
	}
	
	@Override
	public int[] sorting(int[] A)
	{
		int n = A.length;
		QuickSort(A, 0, n-1);
		return A;
	}
}
