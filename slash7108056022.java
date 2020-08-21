
public class slash7108056022 extends slash{
	private int sep = 0;
	@Override
	public int slash_min(int[] A)
	{
		int i = 0, j = 0;
        int end = A.length-1;
        int index = 0;
        j = end;
        i = 0;        
        while(true)
        {
        	index = (i+j) >> 1;
        	if(A[index] > A[i])
        	{
        		i = index;
        		if((j-i+1)==2)
        		{
        			sep = j;
        			break;
        		}
        	}
        	else
        	{
        		j = index;
        		if((j-i+1)==2)
        		{
        			sep = j;
        			break;
        		}
        	}
        }
        sep = (A.length-1)-sep;
        return sep;
	}
}
