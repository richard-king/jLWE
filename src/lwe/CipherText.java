package lwe;

import math.*;

public class CipherText
{
	private Vector u, c, a;
	
	public CipherText(Vector v, PublicKey p, LWEParams params)
	{
		this.a = new Vector(p.getA().getRows(), params.r);
		this.u = a.multiply(p.getA().transpose());
		this.c = a.multiply(p.getP().transpose()).add(LWEFunctions.f(v, params));
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
