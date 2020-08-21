
public class PCL7108056022 extends PCL{
	public boolean checkPCL(int[][] A){
		mergesorty(A,0,A.length-1);
		for(int i=0;i<A.length-2;i++)
		{
			if(A[i][1]==A[i+1][1])
			{
				if(A[i][1]==A[i+2][1])
					return true;
				else
					i++;
			}
		}
		mergesortx(A,0,A.length-1);
		for(int i=0;i<A.length-2;i++)
		{
			if(A[i][0]==A[i+1][0])
			{
				if(A[i][0]==A[i+2][0])
					return true;				
				else
					i++;
			}
		}
		double line[]=new double[A.length];
		for(int i=0;i<A.length-2;i++){
			for(int j=0;j<A.length;j++){
				if((A[j][0]-A[i][0])==0)
					line[j]=0;
				else
					line[j]=(double)(A[j][1]-A[i][1])/(double)(A[j][0]-A[i][0]);
			}
			mergesortline(line,0,A.length-1);
			for(int j=0;j<A.length-1;j++)
				if(line[j]==line[j+1]&&line[j]!=0)
					return true;
		}
		return false;
	}
	
	public void mergesortx(int A[][],int left,int right){
		if(left<right){
			int mid=left+(right-left)/2;
			mergesortx(A,left,mid);
			mergesortx(A,mid+1,right);
			mergex(A,left,mid,right);
		}
	}
	public void mergesorty(int A[][],int left,int right){
		if(left<right){
			int mid=left+(right-left)/2;
			mergesorty(A,left,mid);
			mergesorty(A,mid+1,right);
			mergey(A,left,mid,right);
		}
	}
	public void mergesortline(double A[],int left,int right){
		if(left<right){
			int mid=left+(right-left)/2;
			mergesortline(A,left,mid);
			mergesortline(A,mid+1,right);
			mergeline(A,left,mid,right);
		}
	}
	public int comparex(int x[],int y[]){
		if(x[0]>y[0])
			return 1;
		else if(x[0]<y[0])
			return -1;		
		else if(x[1]>y[1])
			return 1;
		else if(x[1]<y[1])
			return -1;
		else
			return 0;
	}
	public int comparey(int x[],int y[]){
		if(x[1]>y[1])
			return 1;
		else if(x[1]<y[1])
			return -1;
		else
			return 0;
	}
	public void mergex(int A[][],int left,int mid,int right){
		int length_left=mid-left+1;
		int length_right=right-mid;
		int temp_left[][]=new int[length_left][2];
		int temp_right[][]=new int[length_right][2];
		int i,j,k;
		for(i=0;i<length_left;i++)
			for(j=0;j<2;j++)
				temp_left[i][j]=A[left+i][j];
		for(i=0;i<length_right;i++)
			for(j=0;j<2;j++)
				temp_right[i][j]=A[mid+1+i][j];
		i=0;
		j=0;
		k=left;
		while(i<length_left&&j<length_right){
			if(comparex(temp_left[i],temp_right[j])==1){
				A[k][0]=temp_right[j][0];
				A[k][1]=temp_right[j][1];
				j++;
			}
			else{
				A[k][0]=temp_left[i][0];
				A[k][1]=temp_left[i][1];
				i++;
			}
			k++;
		}
		while(i<length_left){
			A[k][0]=temp_left[i][0];
			A[k][1]=temp_left[i][1];
			i++;
			k++;
		}
		while(j<length_right){
			A[k][0]=temp_right[j][0];
			A[k][1]=temp_right[j][1];
			j++;
			k++;
		}
	}
	public void mergey(int A[][],int left,int mid,int right){
		int length_left=mid-left+1;
		int length_right=right-mid;
		int temp_left[][]=new int[length_left][2];
		int temp_right[][]=new int[length_right][2];
		int i,j,k;
		for(i=0;i<length_left;i++)
			for(j=0;j<2;j++)
				temp_left[i][j]=A[left+i][j];
		for(i=0;i<length_right;i++)
			for(j=0;j<2;j++)
				temp_right[i][j]=A[mid+1+i][j];
		i=0;
		j=0;
		k=left;
		while(i<length_left&&j<length_right){
			if(comparey(temp_left[i],temp_right[j])==1){
				A[k][0]=temp_right[j][0];
				A[k][1]=temp_right[j][1];
				j++;
			}
			else{
				A[k][0]=temp_left[i][0];
				A[k][1]=temp_left[i][1];
				i++;
			}
			k++;
		}
		while(i<length_left){
			A[k][0]=temp_left[i][0];
			A[k][1]=temp_left[i][1];
			i++;
			k++;
		}
		while(j<length_right){
			A[k][0]=temp_right[j][0];
			A[k][1]=temp_right[j][1];
			j++;
			k++;
		}
	}
	public void mergeline(double A[],int left,int mid,int right){
		int length_left=mid-left+1;
		int length_right=right-mid;
		double temp_left[]=new double[length_left];
		double temp_right[]=new double[length_right];
		int i,j,k;
		for(i=0;i<length_left;i++)
			temp_left[i]=A[left+i];
		for(i=0;i<length_right;i++)
			temp_right[i]=A[mid+1+i];
		i=0;
		j=0;
		k=left;
		while(i<length_left&&j<length_right){
			if(temp_left[i]>temp_right[j]){
				A[k]=temp_right[j];
				j++;
			}
			else{
				A[k]=temp_left[i];
				i++;
			}
			k++;
		}
		while(i<length_left){
			A[k]=temp_left[i];
			i++;
			k++;
		}
		while(j<length_right){
			A[k]=temp_right[j];
			j++;
			k++;
		}
	}
}