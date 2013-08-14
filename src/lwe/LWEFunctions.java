package lwe;

import math.*;

public class LWEFunctions
{
	public static Vector f(Vector v, int q, int t)
	{
		Vector v2 = v;
		int len = v2.length();
		for(int i = 0; i < len; ++i)
			v2.set(i, (int)(((double)v2.get(i) * ((double)q/(double)t)) % q));
		
		return v2;
	}
	
	public static Vector f_inv(Vector v, int q, int t)
	{
		return LWEFunctions.f(v, t, q);
	}
	
	public static Vector decrypt(CipherText ct, PrivateKey pk, int q, int t)
	{
		return LWEFunctions.f_inv(ct.getC().add(ct.getU().multiply(pk.getS().transpose())), q, t);
	}
	
}
