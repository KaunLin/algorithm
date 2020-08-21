
import java.util.ArrayList;

public class LSPath7108056022 extends LSPath{
	int A[][];
	public LSPath7108056022(int A[][])
	{
		this.A = A;
	}
	public class Graph
	{
	   final int V;
	   private ArrayList<Integer>[] adj;
	   public Graph(int V)
	   {
	      this.V = V;
	      adj = (ArrayList<Integer>[])new ArrayList[V];
	      for (int v = 0; v < V; v++)
	         adj[v] = new ArrayList<Integer>();
	   }

	   public void addEdge(int v, int w)
	   {
	      adj[v].add(w);
	      adj[w].add(v);
	   }
	   public Iterable<Integer> adj(int v)
	   {  
		  return adj[v];  
	   }
	}
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

	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	private int bfs(Graph G, int s, int maxn) 
	{
		  marked = new boolean[maxn];
		  edgeTo = new int[maxn];
		  distTo = new int[maxn];
		  int smalllong = 0;
		  ArrayList<Integer> q = new ArrayList<Integer>();
	      q.add(s);
	      marked[s] = true;
	      distTo[s] = 0;
	      while (!q.isEmpty()) {
	         int v = q.remove(0);
	         for (int w : G.adj(v)) {
	            if (!marked[w]) {
	               q.add(w);
	               marked[w] = true;
	               edgeTo[w] = v;
	               distTo[w] = distTo[v] + 1;
	            }
	         }
	      }
	      QuickSort(distTo,0,distTo.length-1);
	      smalllong = distTo[distTo.length-1];
	      return smalllong;
	 }
	public static void main(String[] args) 
	{
		int A[][] = {{0,1},{0,2},{0,4},{1,3},{1,4},{2,5}};
		LSPath7108056022_1 test = new LSPath7108056022_1(A);
		System.out.println(test.Ans(A));
	}
	private int ans = 0;
	@Override
	public int Ans(int[][] array)
	{	
		int max = 0;
		for (int i = 0; i < array.length; i++) 
		{
            for (int j = 0; j < array[i].length; j++) 
            {
                if (max < array[i][j]) 
                {
                    max = array[i][j];
                }
            }
		}
		int n = max+1;
		int[] count;
		count = new int[n];
		Graph g = new Graph(n);
		for(int i = 0; i < array.length; i++)
		{
			g.addEdge(array[i][0], array[i][1]);
			count[array[i][0]]++;
			count[array[i][1]]++;
		}
		int numbermax = 0, maxlong = 0;
		for(int i = 0; i < n; i++)
		{
			if(count[i]!=0)
			{
				numbermax = bfs(g,i,n);
				if(numbermax > maxlong)
				{
					maxlong = numbermax;
				}
			}
		}
		ans = maxlong;
		return ans;
	}
}
