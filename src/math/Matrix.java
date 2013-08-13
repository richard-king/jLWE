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
			for(int j = 0; j < this.n; ++j)
				d[i][j] += that.get(i, j);

		return new Matrix(d);
	}
	
	public Matrix multiply(int a)
	{
		int[][] d = this.data;
		
		for(int i = 0; i < this.m; ++i)
			for(int j = 0; j < this.n; ++j)
				d[i][j] *= a;

		return new Matrix(d);
	}
	
	public Matrix subtract(Matrix that)
	{
		return this.add(that.multiply(-1));
	}
	
	public Matrix premultiply(Matrix that)
	{
		int[][] d = new int[this.getCols()][that.getRows()];
		
		for(int i = 0; i < this.getCols(); ++i)
			for(int j = 0; j < that.getRows(); ++j)
				for(int k = 0; k < that.getCols(); ++k)
					d[i][j] += (this.data[i][k] * that.get(k, j));
		
		return new Matrix(d);
	}
	
	public Matrix postmultiply(Matrix that)
	{		
		return that.premultiply(this);
	}
	
	public Matrix transpose()
	{
		int[][] d = new int[this.n][this.m];
		
		for(int i = 0; i < this.m; ++i)
			for(int j = 0; j < this.n; ++j)
				d[j][i] = this.data[i][j];
		
		return new Matrix(d); 
	}
}
