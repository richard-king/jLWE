package lwe;

import math.*;

public class LWEFunctions
{
	public static Vector decrypt(CipherText ct, PrivateKey pk, LWEParams params)
	{
		return Vector.f(Vector.add(Vector.multiply(Matrix.transpose(pk.getS()), ct.getU()), ct.getC()), params.t, params.q);
	}
	
	public static final LWEParams set1 = new LWEParams(136, 2008, 136, 2003, 1, 2, 0.0065);
	public static final LWEParams set2 = new LWEParams(166, 1319, 166, 4093, 4, 2, 0.0024);
	public static final LWEParams set3 = new LWEParams(192, 1500, 192, 8191, 5, 4, 0.0009959);
	public static final LWEParams set4 = new LWEParams(214, 1333, 214, 16381, 12, 4, 0.00045);
	public static final LWEParams set5 = new LWEParams(233, 1042, 233, 32749, 59, 2, 0.000217);
	public static final LWEParams set6 = new LWEParams(233, 4536, 233, 32749, 1, 40, 0.000217);
	
}
