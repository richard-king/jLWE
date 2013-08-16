package math;

import java.util.Random;

public class Matrix
{
	private int[][] data;
	private int modulus;

	public Matrix(int rows, int cols, int mod)
	{
		this.data = new int[rows][cols];
		this.modulus = mod;
		Random r = new Random();

		for(int i = 0; i < this.data.length; i++)
		{
			for(int j = 0; j < this.data[i].length; j++)
			{
				this.data[i][j] = ((r.nextInt() % this.modulus) + this.modulus) % this.modulus;
			}
		}
	}

	public Matrix(int rows, int cols, int mod, double a)
	{
		this.data = new int[rows][cols];
		this.modulus = mod;
		Random r = new Random();

		for(int i = 0; i < this.data.length; i++)
		{
			for(int j = 0; j < this.data[i].length; j++)
			{
				this.data[i][j] = ((((int)(r.nextGaussian() * ((a * this.modulus)/(Math.sqrt(2 * Math.PI))))) % this.modulus) + this.modulus) % this.modulus;
			}
		}
	}

	public int get(int i, int j)
	{
		return this.data[i][j];
	}

	public void set(int i, int j, int n)
	{
		this.data[i][j] = ((n % this.modulus) + this.modulus) % this.modulus;
	}

	public int getRows()
	{
		return this.data.length;
	}

	public int getCols()
	{
		return this.data[0].length;
	}

	public int getModulus()
	{
		return this.modulus;
	}

	public static Matrix add(Matrix m1, Matrix m2)
	{
		Matrix m = new Matrix(m1.getRows(), m1.getCols(), m1.getModulus());

		for (int i = 0; i < m1.getRows(); i++)
		{
			for (int j = 0; j < m1.getCols(); j++)
			{
				m.set(i, j, m1.get(i, j) + m2.get(i, j));
			}
		}

		return m;
	}

	public static Matrix transpose(Matrix m1)
	{
		Matrix m = new Matrix(m1.getCols(), m1.getRows(), m1.getModulus());

		for (int i = 0; i < m1.getRows(); i++)
		{
			for (int j = 0; j < m1.getCols(); j++)
			{
				m.set(j, i, m1.get(i, j));
			}
		}

		return m;
	}

	public static Matrix multiply(Matrix m1, Matrix m2)
	{
		Matrix m = new Matrix(m1.getRows(), m2.getCols(), m1.getModulus());

		for (int i = 0; i < m1.getRows(); i++)
		{
			for (int j = 0; j < m2.getCols(); j++)
			{
				int tmp = 0;
				for (int k = 0; k < m1.getCols(); k++)
				{
					tmp += m1.get(i, k) * m2.get(k, j);
				}
				m.set(i, j, tmp);
			}
		}

		return m;
	}


}