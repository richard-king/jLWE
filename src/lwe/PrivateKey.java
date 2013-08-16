package lwe;

import math.Matrix;

public class PrivateKey
{
	private Matrix s;
	
	public PrivateKey(LWEParams params)
	{
		this.s = new Matrix(params.n, params.l, params.q);
	}
	
	public Matrix getS()
	{
		return this.s;
	}
}
