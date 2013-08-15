package lwe;

import math.*;

public class LWEFunctions
{
	public static Vector f(Vector v, LWEParams params)
	{
		Vector v2 = v;
		int len = v2.length();
		for(int i = 0; i < len; ++i)
			v2.set(i, (int)(((double)v2.get(i) * ((double)params.q/(double)params.t)) % params.q));
		
		return v2;
	}
	
	public static Vector f_inv(Vector v, LWEParams params)
	{
		return LWEFunctions.f(v, params);
	}
	
	public static Vector decrypt(CipherText ct, PrivateKey pk, LWEParams params)
	{
		return LWEFunctions.f_inv(ct.getC().add(ct.getU().multiply(pk.getS().transpose())), params);
	}
	
}
