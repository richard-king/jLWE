package lwe;

import math.Matrix;

public class PublicKey
{
	private Matrix a, p;
	
	public PublicKey(LWEParams params, PrivateKey s)
	{
		this.a = new Matrix(params.m, params.n, true, params.q);		
		this.p = this.a.premultiply(s.getS()).add(new Matrix(params.m, params.l, params.alpha, params.q));		
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
