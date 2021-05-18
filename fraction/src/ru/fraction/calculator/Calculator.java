package ru.fraction.calculator;

public class Calculator {

  public static Fraction multiply(Fraction fr1, Fraction fr2) {
    int numerator = (fr1.getIntNum() * fr1.getDenominator() + fr1.getNumerator()) * (fr2.getIntNum() * fr2.getDenominator() + fr2.getNumerator());
    int denominator = fr1.getDenominator() * fr2.getDenominator();
    int sign = fr1.getSign() * fr2.getSign();

    return new Fraction(sign, numerator, denominator);
  }

  public static Fraction divide(Fraction fr1, Fraction fr2) {
    int numerator = (fr1.getIntNum() * fr1.getDenominator() + fr1.getNumerator()) * fr2.getDenominator();
    int denominator = fr1.getDenominator() * (fr2.getIntNum() * fr2.getDenominator() + fr2.getNumerator());
    int sign = fr1.getSign() * fr2.getSign();

    return new Fraction(sign, numerator, denominator);
  }

  public static Fraction sum(Fraction fr1, Fraction fr2) {

    if (fr1.getNumerator() == 0) {
      return fr2;
    }
    if (fr2.getNumerator() == 0) {
      return fr1;
    }

    int numerator = fr1.getSign() * (fr1.getIntNum() * fr1.getDenominator() + fr1.getNumerator())
        * fr2.getDenominator() + fr2.getSign() * (fr2.getIntNum() * fr2.getDenominator() + fr2.getNumerator()) * fr1.getDenominator();

    int denominator = fr1.getDenominator() * fr2.getDenominator();

    int sign = 1;
    if (numerator < 0) {
      sign = -1;
      numerator = -numerator;
    }

    if (numerator == 0 || denominator == 0) {
      return new Fraction(0, 0, 0);
    }

    return new Fraction(sign, numerator, denominator);
  }

  public static Fraction minus(Fraction fr1, Fraction fr2) {

    if (fr1.getNumerator() == 0 && fr2.getNumerator() == 0) {
      new Fraction(0, 0, 0, 0);
    }

    if (fr1.getNumerator() == 0) {
      fr2.setSign(fr2.getSign() * (-1));
      return fr2;
    }

    if (fr2.getNumerator() == 0) {
      return fr1;
    }

    int numerator = fr1.getSign() * (fr1.getIntNum() * fr1.getDenominator() + fr1.getNumerator()) * fr2.getDenominator()
        - fr2.getSign() * (fr2.getIntNum() * fr2.getDenominator() + fr2.getNumerator()) * fr1.getDenominator();

    int denominator = fr1.getDenominator() * fr2.getDenominator();

    int sign = 1;
    if (numerator < 0) {
      sign = -1;
      numerator = -numerator;
    }

    if (numerator == 0 || denominator == 0) {
      return new Fraction(0, 0, 0);
    }

    return new Fraction(sign, numerator, denominator);
  }
}