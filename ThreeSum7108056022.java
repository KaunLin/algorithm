package algHW;

public class ThreeSum7108056022 extends ThreeSum{
	int[] A;
	public ThreeSum7108056022(int[] A)
	{
		this.A = A;
	}
	public void quickysort(int[] A)
	{
		 sort(A, 0, A.length-1);
	}
	private void sort(int[] number, int left, int right) 
	{
        if(left < right) { 
            int q = partition(number, left, right); 
            sort(number, left, q-1); 
            sort(number, q+1, right); 
        } 

    }
	private int partition(int number[], int left, int right)
	{  
        int i = left - 1; 
        for(int j = left; j < right; j++) { 
            if(number[j] <= number[right]) { 
                i++; 
                swap(number, i, j); 
            } 
        } 
        swap(number, i+1, right); 
        return i+1; 
    }
	private void swap(int[] number, int i, int j) 
	{
        int t = number[i]; 
        number[i] = number[j]; 
        number[j] = t;
    }
	
	public static void main(String[] args) 
	{
		int[] A = {-3,-2,-5,0,1,2,3,7,8,5};
		ThreeSum7108056022 test = new ThreeSum7108056022(A);
		System.out.println(test.T_sum(A));
	}
	
	private int count = 0;
	@Override
	public  int T_sum(int[] A) {
		quickysort(A);
        for (int i = 0; i < A.length - 2; i++) {
            if (i > 0 && A[i] == A[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = A.length - 1;
            while (left < right) {
                int tmp = A[left] + A[right];
                if (tmp + A[i] == 0) {
                    count++;
                    left++;
                    while (left < right && A[left] == A[left - 1]) {
                        left++;
                    }
                } else if (tmp + A[i] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
	
}
