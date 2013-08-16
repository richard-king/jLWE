package math;

import java.util.Random;

public class Vector
{
	private int[] data;
	private int modulus;

	public Vector(int size, int mod)
	{
		this.data = new int[size];
		this.modulus = mod;
		Random r = new Random();
		for(int i = 0; i < size; i++)
		{
			this.data[i] = ((r.nextInt() % this.modulus) + this.modulus) % this.modulus;
		}
	}

	public Vector(int size, int range, int mod)
	{
		this.data = new int[size];
		this.modulus = mod;
		Random r = new Random();
		for(int i = 0; i < size; i++)
		{
			this.data[i] = r.nextInt(2 * range + 1) - range;
		}
	}

	public int get(int i)
	{
		return this.data[i];
	}

	public void set(int i, int n)
	{
		this.data[i] = ((n % this.modulus) + this.modulus) % this.modulus;
	}

	public int length()
	{
		return this.data.length;
	}

	public int getModulus()
	{
		return this.modulus;
	}

	public void print()
	{
		for (int i = 0; i < this.data.length; i++)
		{
			System.out.print(this.data[i]);
			if(i != this.data.length - 1)
			{
				System.out.print(", ");
			}
		}
		System.out.println(".");
	}

	public static Vector f(Vector v, int q, int t)
	{
		double res = (double)q / t;
		Vector vcopy = new Vector(v.length(), q);

		for(int i = 0; i < v.length(); i++)
		{
			vcopy.set(i, ((int)(v.get(i) * res)));
		}

		return vcopy;
	}

	public static Vector multiply(Matrix m1, Vector v1)
	{
		Vector v = new Vector(m1.getRows(), m1.getModulus());

		for(int i = 0; i < m1.getRows(); i++)
		{
			int tmp = 0;
			for(int j = 0; j < m1.getCols(); j++)
			{
				tmp += m1.get(i, j) * v1.get(j);
			}
			v.set(i, tmp);
		}

		return v;
	}

	public static Vector add(Vector v1, Vector v2)
	{
		Vector v = new Vector(v1.length(), v1.getModulus());

		for(int i = 0; i < v1.length(); i++)
		{
			v.set(i, v1.get(i) + v2.get(i));
		}

		return v;
	}

	public static Vector subtract(Vector v1, Vector v2)
	{
		Vector v = new Vector(v1.length(), v1.getModulus());

		for(int i = 0; i < v1.length(); i++)
		{
			v.set(i, v1.get(i) - v2.get(i));
		}

		return v;
	}
}