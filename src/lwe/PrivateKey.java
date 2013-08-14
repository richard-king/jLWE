package lwe;

import math.Matrix;

public class PrivateKey
{
	private Matrix s;
	
	public PrivateKey(int n, int l, int q)
	{
		generate(n, l, q);
	}
	
	private void generate(int n, int l, int q)
	{
		this.s = new Matrix(n, l, true, q);
	}
	
	public Matrix getS()
	{
		return this.s;
	}
}
