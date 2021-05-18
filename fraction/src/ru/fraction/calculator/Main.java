package ru.fraction.calculator;

class Main  {

    public static void main(String[] args) {
        test();
        Console.connect();
    }

    public static void test() {
        Fraction fractionINT1 = Fraction.convert(4);
        System.out.println("Получение дроби из целого числа '4' -> " + fractionINT1.toString());
        Fraction fractionINT2 = Fraction.convert(-2);
        System.out.println("Получение дроби из целого числа '-2' -> " + fractionINT2.toString());

        Fraction fractionDOUBLE1 = Fraction.convert(4.58);
        System.out.println("Получение дроби из числа с плавающей точкой '4.58' -> " + fractionDOUBLE1.toString());
        Fraction fractionDOUBLE2 = Fraction.convert(-1.088);
        System.out.println("Получение дроби из числа с плавающей точкой '-1.088' -> " + fractionDOUBLE2.toString());

        Fraction fractionSTRING1 = Fraction.convert("8/5");
        System.out.println("Получение дроби  из строкового представления '8/5' -> " + fractionSTRING1.toString());
        Fraction fractionSTRING2 = Fraction.convert("-1/5");
        System.out.println("Получение дроби  из строкового представления '-1/5' -> " + fractionSTRING2.toString());
        Fraction fractionSTRING3 = Fraction.convert("7 5516/11820");
        System.out.println("Получение дроби  из строкового представления '7 5516/11820' -> " + fractionSTRING3.toString());
        Fraction fractionSTRING4 = Fraction.convert("98 8/7");
        System.out.println("Получение дроби  из строкового представления '98 8/7' -> " + fractionSTRING4.toString());

        System.out.println();

        Fraction fraction1 = Calculator.minus(Fraction.convert("1/2"), Fraction.convert("3/4"));
        System.out.println("Результат вычитания дробей '1/2' - '3/4' -> " + fraction1.toString());

        fraction1 = Calculator.sum(Fraction.convert("1/2"), Fraction.convert("3/4"));
        System.out.println("Результат сложения дробей '1/2' + '3/4' -> " + fraction1.toString());

        fraction1 = Calculator.divide(Fraction.convert("1/2"), Fraction.convert("3/4"));
        System.out.println("Результат деления дробей '1/2' / '3/4' -> " + fraction1.toString());

        fraction1 = Calculator.multiply(Fraction.convert("1/2"), Fraction.convert("3/4"));
        System.out.println("Результат умножения дробей '1/2' * '3/4' -> " + fraction1.toString());
    }

}






