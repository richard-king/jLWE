package math;

import java.util.Random;

public class Matrix
{
	private int m, n, q;
	private int[][] data;
	
	public Matrix(int m, int n, boolean b, int q)
	{
		this.m = m;
		this.n = n;
		this.q = q;
		this.data = new int[m][n];
		if(b) rand();
	}
	
	public Matrix(int m, int n, double alpha, int q)
	{
		this.m = m;
		this.n = n;
		this.q = q;
		this.data = new int[m][n];
		psi((alpha * q)/Math.sqrt(2 * Math.PI));
	}
	
	public Matrix(int[][] d, int q)
	{
		this.data = d;
		this.m = data.length;
		this.n = data[0].length;
		this.q = q;
		for(int i = 0; i < m; ++i)
			for(int j = 0; j < n; ++j)
				data[i][j] = data[i][j] % q;
	}
	
	private void rand()
	{
		Random random = new Random();
		for(int i = 0; i < this.m; ++i)
			for(int j = 0; j < this.n; ++j)
				this.data[i][j] = random.nextInt() % q;
	}
	
	private void psi(double sd)
	{
		Random random = new Random();
		for(int i = 0; i < this.m; ++i)
			for(int j = 0; j < this.n; ++j)
				this.data[i][j] = (int) (random.nextGaussian() * sd) % q;
	}
	
	public int getRows()
	{
		return this.m;
	}
	
	public int getCols()
	{
		return this.n;
	}
	
	public int getQ()
	{
		return this.q;
	}
	
	public int[][] getData()
	{
		return this.data;
	}
	
	public int get(int i, int j)
	{
		return this.data[i][j];
	}
	
	public void set(int i, int j, int v)
	{
		this.data[i][j] = v % this.q;
	}
	
	public Matrix add(Matrix that)
	{
		int[][] d = this.data;
		
		for(int i = 0; i < this.m; ++i)
			for(int j = 0; j < this.n; ++j)
				d[i][j] += that.get(i, j) % this.q;

		return new Matrix(d, q);
	}
	
	public Matrix multiply(int a)
	{
		int[][] d = this.data;
		
		for(int i = 0; i < this.m; ++i)
			for(int j = 0; j < this.n; ++j)
				d[i][j] *= a % this.q;

		return new Matrix(d, q);
	}
	
	public Matrix subtract(Matrix that)
	{
		return this.add(that.multiply(-1));
	}
	
	public Matrix premultiply(Matrix that)
	{
		int[][] d = new int[this.getCols()][that.getRows()];
		
		for(int i = 0; i < this.getRows(); ++i)
			for(int j = 0; j < that.getRows(); ++j)
				for(int k = 0; k < that.getCols(); ++k)
					d[i][j] += (this.data[i][k] * that.get(k, j)) % this.q;
		
		return new Matrix(d, q);
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
				d[j][i] = this.data[i][j] % this.q;
		
		return new Matrix(d, q); 
	}
}
