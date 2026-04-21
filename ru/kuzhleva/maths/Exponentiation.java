package ru.kuzhleva.maths;

import static java.lang.Integer.parseInt;
import static java.lang.StrictMath.pow;

/**
 * Класс для вычисления степени числа.
 * Содержит статический метод для вычисления значения {@code x^y},
 * где основание и показатель степени передаются в виде строк.
 * Также содержит метод {@code main}, позволяющий запускать
 * программу из командной строки.
 *
 * @see Math
 */
public class Exponentiation {

    /**
     * Вычисляет степень числа на основе двух строковых аргументов.
     * Строки преобразуются в целые числа, после чего вычисляется
     * значение основания в степени показателя.
     * Если показатель степени равен нулю, метод возвращает {@code 1}.
     *
     * @param xStr строковое представление основания степени
     * @param yStr строковое представление показателя степени
     * @return результат возведения основания в степень
     * @throws NumberFormatException если одна из строк не является целым числом
     */
    public static double calculation(String xStr, String yStr) {
        int base = parseInt(xStr);
        int exponent = parseInt(yStr);
        if (exponent == 0) {
            return 1;
        } else {
            return pow(base, exponent);
        }
    }

}
