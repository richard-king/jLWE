package lwe;

public class KeyPair
{
	private PrivateKey privateKey;
	private PublicKey publicKey;
	
	public KeyPair(LWEParams params)
	{
		this.privateKey = new PrivateKey(params);
		this.publicKey = new PublicKey(params, this.privateKey);
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
