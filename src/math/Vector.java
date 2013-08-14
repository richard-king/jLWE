package math;

import java.util.Random;

public class Vector
{
	private int[] v;
	private int m, r;
	
	public Vector(int m, int r)
	{
		this.m = m;
		this.v = new int[m];
		this.r = r;
		init();
	}
	
	public Vector(int[] v, int r)
	{
		this.v = v;
		this.r = r;
		this.m = v.length;
	}
	
	private void init()
	{
		Random random = new Random();
		for(int i = 0; i < this.m; ++i)
			this.v[i] = random.nextInt(this.r) - this.r;
	}
	
	public int get(int i)
	{
		return this.v[i];
	}
	
	public void set(int i, int n)
	{
		this.v[i] = n;
	}
	
	public int length()
	{
		return this.m;
	}
	
	public Matrix multiply(Matrix m)
	{
		int[][] data = new int[1][this.m];
		data[0] = this.v;
		
		Matrix vector = new Matrix(data, m.getQ());
		
		return m.premultiply(vector);
	}
}
