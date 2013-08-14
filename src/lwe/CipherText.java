package lwe;

import math.*;

public class CipherText
{
	private Vector u, c, a;
	
	public CipherText(Vector v, PublicKey p, int r, int q, int t)
	{
		this.a = new Vector(p.getA().getRows(), r);
		this.u = a.multiply(p.getA().transpose());
		this.c = a.multiply(p.getP().transpose()).add(LWEFunctions.f(v, q, t));
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
