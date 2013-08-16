package lwe;

import math.*;

public class LWE
{
	
	public static void main(String[] args)
	{
		KeyPair keypair = new KeyPair(LWEFunctions.set1);
		Vector m = new Vector(LWEFunctions.set1.l, LWEFunctions.set1.t);
		
		CipherText c = new CipherText(m, keypair.getPublicKey(), LWEFunctions.set1);
		
		System.out.println("Wahoo!");
	}

}
