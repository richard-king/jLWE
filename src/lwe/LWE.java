package lwe;

import math.*;

public class LWE
{
	
	public static void main(String[] args)
	{
		KeyPair keypair = new KeyPair(LWEFunctions.set1);
		int[] ints = new int[LWEFunctions.set1.l];
		for(int i = 0; i < ints.length; ++i) ints[i] = i;
		Vector m = new Vector(ints, ints.length);
		
		CipherText c = new CipherText(m, keypair.getPublicKey(), LWEFunctions.set1);
		
		System.out.println("Wahoo!");
	}

}
