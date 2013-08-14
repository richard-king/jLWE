package lwe;

import math.*;

public class LWEFunctions
{

	public static void f(Vector v, int q, int t)
	{
		int len = v.length();
		for(int i = 0; i < len; ++i)
			v.set(i, (int)(((double)v.get(i) * ((double)q/(double)t)) % q));
	}
	
	public static void f_inv(Vector v, int q, int t)
	{
		f(v, t, q);
	}
	
}
