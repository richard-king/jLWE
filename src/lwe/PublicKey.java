package lwe;

import math.Matrix;

public class PublicKey
{
	private Matrix a, p;
	
	public PublicKey(LWEParams params, PrivateKey s)
	{
		this.a = new Matrix(params.m, params.n, params.q);		
		this.p = Matrix.add(Matrix.multiply(a, s.getS()), new Matrix(params.m, params.l, params.q, params.alpha));		
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
