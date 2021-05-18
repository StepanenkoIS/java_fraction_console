package ru.fraction.calculator;

import java.util.Objects;

public class Fraction {
  private int numerator;
  private int denominator;
  private int intNum;
  private int sign;

  public Fraction(int sign, int numerator, int denominator) {
    this.sign = sign;
    this.numerator = numerator;
    this.denominator = denominator;
    nodMethod();
  }

  public Fraction(int sign, int intNum, int numerator, int denominator) {
    this.sign = sign;
    this.numerator = numerator;
    this.denominator = denominator;
    this.intNum = intNum;
    nodMethod();
  }

  public static Fraction convert(int num) {
    int sign = 1;
    if (num < 0) {
      sign = -1;
      num = -num;
    }
    Fraction fraction = new Fraction(sign, num, 1);
    fraction.nodMethod();
    return fraction;
  }

  public static Fraction convert(Double num) {
    int sign = 1;

    if (num < 0) {
      sign = -1;
      num = -num;
    }
    String s = num.toString();
    String[] strings = s.split("\\D");
    int intNum = Integer.parseInt(strings[0]);
    int numerator = Integer.parseInt(strings[1]);
    if (numerator == 0) {
      return convert(intNum);
    }
    int denominator = (int) Math.pow(10, strings[1].length());
    Fraction fraction = new Fraction(sign, intNum, numerator, denominator);
    fraction.nodMethod();
    return fraction;
  }

  public static Fraction convert(String value) {
    if (value.contains(".")) {
      return Fraction.convert(Double.parseDouble(value));
    }
    if (!value.contains(".") && !value.contains("/")) {
      return Fraction.convert(Integer.parseInt(value));
    }

    int sign = 1;
    int intNum;
    int numerator;
    int denominator;

    if (value.startsWith("-")) {
      value = value.substring(1);
      sign = -1;
    }

    String[] strings = value.split("\\D");

    if (strings.length == 2) {
      numerator = Integer.parseInt(strings[0]);
      denominator = Integer.parseInt(strings[1]);
      return new Fraction(sign, numerator, denominator);
    }

    intNum = Integer.parseInt(strings[0]);
    numerator = Integer.parseInt(strings[1]);
    denominator = Integer.parseInt(strings[2]);
    return new Fraction(sign, intNum, numerator, denominator);
  }

  private void nodMethod() {
    numerator += intNum * denominator;
    intNum = 0;

    if (numerator == 0 || denominator == 0) {
      numerator = denominator = 0;
      return;
    }

    int b = Math.abs(denominator);
    if (b == 1) {
      return;
    }

    int a = Math.abs(numerator);
    while (a != b) {
      if (a > b) {
        a -= b;
      }
      if (b > a) {
        b -= a;
      }
    }
    numerator /= a;
    denominator /= a;

    if (numerator > denominator) {
      intNum = numerator / denominator;
      numerator = numerator - (denominator * intNum);
    }
  } //алгоритм Евклида

  public String toString() {
    if (numerator == 1 && denominator == 1) {
      return "1";
    }
    if (numerator == 0 && denominator == 0) {
      return "0";
    }
    if (numerator == 0) {
      return intNum * sign + "/" + denominator;
    }
    if (intNum == 0) {
      return numerator * sign + "/" + denominator;
    }
    return intNum * sign + " " + numerator + "/" + denominator;
  }

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  public int getIntNum() {
    return intNum;
  }

  public void setSign(int sign) {
    this.sign = sign;
  }

  public int getSign() {
    return sign;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Fraction fraction = (Fraction) o;
    return numerator == fraction.numerator &&
        denominator == fraction.denominator &&
        intNum == fraction.intNum &&
        sign == fraction.sign;
  }

  @Override
  public int hashCode() {
    return Objects.hash(numerator, denominator, intNum, sign);
  }
}