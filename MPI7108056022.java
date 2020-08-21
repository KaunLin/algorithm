
public class MPI7108056022 extends MPI{

	public void counting(int[] array, int[] count)
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] <= 0 || array[i] > array.length)
			{
				continue;
			}
			else
			{
				count[array[i]]++;
			}
		}
	}
	
	private int min = 0;
	@Override
	public int min(int[] array)
	{
		int[] count;
		count = new int[array.length];
		counting(array, count);
		for(int i = 1; i < array.length; i++)
		{
			if(count[i] == 0)
			{
				min = i;
				break;
			}
		}
		return min;
	}
}
