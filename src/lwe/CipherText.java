package lwe;

import math.*;

public class CipherText
{
	private Vector u, c, a;
	
	public CipherText(Vector v, PublicKey p, LWEParams params)
	{
		this.a = new Vector(p.getA().getRows(), params.r, params.q);
		this.u = Vector.multiply(Matrix.transpose(p.getA()), a);
		this.c = Vector.add(Vector.multiply(Matrix.transpose(p.getP()), a), Vector.f(v, params.q, params.t));
	}
	
	public Vector getC()
	{
		return this.c;
	}
	
	public Vector getU()
	{
		return this.u;
	}
}
