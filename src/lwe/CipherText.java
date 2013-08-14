package lwe;

import math.*;

public class CipherText
{
	private Vector u, c, a;
	private PublicKey p;
	
	public CipherText(Vector v, PublicKey p, int r)
	{
		this.p = p;
		this.a = new Vector(this.p.getA().getRows(), r);
		
	}
}
