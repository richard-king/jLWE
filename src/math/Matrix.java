package math;

public class Matrix
{
	private int m, n;
	private int[][] data;
	
	public Matrix(int n, int m)
	{
		this.m = m;
		this.n = n;
		this.data = new int[m][n];
	}
	
	public Matrix(int[][] d)
	{
		this.data = d;
		this.m = data.length;
		this.n = data[0].length;
	}
	
	public int getRows()
	{
		return this.m;
	}
	
	public int getCols()
	{
		return this.n;
	}
	
	public int get(int i, int j)
	{
		return this.data[i][j];
	}
	
	public void set(int i, int j, int v)
	{
		this.data[i][j] = v;
	}
	
	public Matrix add(Matrix that)
	{
		int[][] d = this.data;
		for(int i = 0; i < this.m; ++i)
		{
			for(int j = 0; j < this.n; ++j)
			{
				d[i][j] += that.get(i, j);
			}
		}
		
		return new Matrix(d);
	}
}
