package lwe;

import math.*;

public class CipherText
{
	private Vector u, c, a;
	
	public CipherText(Vector v, PublicKey p, int r)
	{
		this.a = new Vector(p.getA().getRows(), r);
		this.u = a.multiply(p.getA().transpose());
		this.c = a.multiply(p.getP().transpose());
		this.c.add(v);
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
