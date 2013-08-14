package lwe;

public class LWEParams {
	
	public int l, m, n, q, r ,t;
	public double alpha;
	
	public LWEParams(int l, int m, int n, int q, int r, int t, double alpha)
	{
		this.l = l;
		this.m = m;
		this.n = n;
		this.q = q;
		this.r = r;
		this.t = t;
		this.alpha = alpha;
	}

}
