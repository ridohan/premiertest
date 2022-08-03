package com.ridohan.testing;

import java.util.HashSet;
import java.util.Set;

public class Calculator
{

	public int add(int a, int b)
	{
		return a + b;
	}

	public int multiply(int a, int b)
	{
		return a * b;
	}

	public double add(double a, double b)
	{
		return a + b;
	}

	public Set<Integer> digitsSet(int number)
	{
		final Set<Integer> integers = new HashSet<Integer>();
		final String numberString = String.valueOf(number);

		for (int i = 0; i < numberString.length(); i++)
		{
			if (numberString.charAt(i) != '-')
			{
				integers.add(Integer.parseInt(numberString, i, i + 1, 10));
			}
		}
		return integers;
	}
}
