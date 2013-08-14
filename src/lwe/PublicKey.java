package lwe;

import math.Matrix;

public class PublicKey
{
	private Matrix a, p;
	
	public PublicKey(int m, int n, int l, int q, double a, PrivateKey s)
	{
		this.a = new Matrix(m, n, true, q);
		this.p = this.a.premultiply(s.getS()).add(new Matrix(m, l, a, q));		
	}
	
	public Matrix getA()
	{
		return this.a;
	}
	
	public Matrix getP()
	{
		return this.p;
	}
}
