package com.chap01;

public class Rational {

	private int numerator;
	private int denominator;

	public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	// sum of this number and b
	public Rational plus(Rational b) {
		int denom = getDenominator();
		if (b.denominator != this.denominator) {
			denom = b.denominator * this.denominator;
		}
		int numer = ((getDenominator() / denom) * getNumerator()) + (b.getDenominator() / denom) * b.getNumerator();
		return new Rational(numer, denom);
	}

	// difference of this number and b
	public Rational minus(Rational b) {
		int denom = getDenominator();
		if (b.denominator != this.denominator) {
			denom = b.denominator * this.denominator;
		}
		int numer = ((getDenominator() / denom) * getNumerator()) - (b.getDenominator() / denom) * b.getNumerator();
		return new Rational(numer, denom);
	}

	// product of this number and b
	public Rational times(Rational b) {
		int numer = getNumerator() * b.getNumerator();
		int denom = getDenominator() * b.getDenominator();
		return new Rational(numer, denom);
	}

	// quotient of this number and b
	public Rational divides(Rational b) {
		int numer = getNumerator() * b.getDenominator();
		int denom = getDenominator() * b.getNumerator();
		return new Rational(numer, denom);
	}

	// is this number equal to that ?
	public boolean equals(Rational that) {
		return getNumerator() == that.getNumerator() && getDenominator() == that.getDenominator();
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	@Override
	public String toString() {
		return "Rational [numerator=" + numerator + ", denominator=" + denominator + "]";
	}

}