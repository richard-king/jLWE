package lwe;

public class KeyPair
{
	private PrivateKey privateKey;
	private PublicKey publicKey;
	
	public KeyPair(int m, int n, int l, int q, double alpha)
	{
		this.privateKey = new PrivateKey(n, l, q);
		this.publicKey = new PublicKey(m, n, l, q, alpha, this.privateKey);
	}
	
	public PrivateKey getPrivateKey()
	{
		return this.privateKey;
	}
	
	public PublicKey getPublicKey()
	{
		return this.publicKey;
	}
}
