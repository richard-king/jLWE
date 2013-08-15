package lwe;

import math.Matrix;

public class PrivateKey
{
	private Matrix s;
	
	public PrivateKey(LWEParams params)
	{
		generate(params.n, params.l, params.q);
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
