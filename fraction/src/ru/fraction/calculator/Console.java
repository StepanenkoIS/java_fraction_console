package ru.fraction.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

  private static String info = "Список достпуных команд: \n" +
      "- exit - выход из приложения \n" +
      "- info - получить список команд \n" +
      "- example - примеры работы программы \n" +
      "- sum - выполнить сложение 'value#1 sum value#2' \n" +
      "- min - выполнить вычитание 'value#1 min value#2' \n" +
      "- mul  - выполнить умножение 'value#1 mul value#2' \n" +
      "- div -  - выполнить деление. 'value#1 div value#2' \n";

  private static String example = "Пример преобразования числа к дроби: 0.5 -> 1/2 \n" +
      "Пример сложения: 1/2 sum 3/4 -> 1 1/4 \n" +
      "Пример вычитания: 1/2 min 3/4 -> -1/4 \n" +
      "Пример умножения: 1/2 mul 3/4 -> 3/8 \n" +
      "Пример деления: 1/2 div 3/4 -> 2/3 \n";

  public static void connect() {


    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String line;
      boolean flag = true;
      System.out.println("Для получения списка доступных команд введите 'info'");

      while (flag) {
        System.out.print("Введите значение: -> ");
        try {
          switch (line = reader.readLine()) {
            case "exit":
              flag = false;
              break;
            case "info":
              System.out.println(info);
              break;
            case "example":
              System.out.println(example);
              break;
            default:
              System.out.println("Результат: -> " + parseConsole(line) + "\n");
              break;
          }
        } catch (NumberFormatException ex) {
          System.out.println("Введенное значение неверно. Повторите ввод. \n");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String parseConsole(String line) {

    if (line.contains("sum")) {
      String[] values = line.split("sum");
      return Calculator.sum(parseValue(values[0].trim()), parseValue(values[1].trim())).toString();
    }
    if (line.contains("min")) {
      String[] values = line.split("min");
      return Calculator.minus(parseValue(values[0].trim()), parseValue(values[1].trim())).toString();
    }
    if (line.contains("mul")) {
      String[] values = line.split("mul");
      return Calculator.multiply(parseValue(values[0].trim()), parseValue(values[1].trim())).toString();
    }
    if (line.contains("div")) {
      String[] values = line.split("div");
      return Calculator.divide(parseValue(values[0].trim()), parseValue(values[1].trim())).toString();
    }

    return parseValue(line).toString();
  }

  private static Fraction parseValue(String value) {
    return Fraction.convert(value);
  }

}
