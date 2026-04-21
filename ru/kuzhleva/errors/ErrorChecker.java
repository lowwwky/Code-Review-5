package ru.kuzhleva.errors;

import java.util.*;

/**
 * Класс для проверки корректности пользовательского ввода.
 * Содержит методы для считывания и проверки целых чисел,
 * вещественных чисел и строк. В случае некорректного ввода
 * пользователь получает сообщение об ошибке и приглашение
 * повторить ввод.
 *
 * @see Scanner
 */
public class ErrorChecker {
    Scanner keyboard = new Scanner(System.in);

    /**
     * Считывает и проверяет ввод целого числа.
     * Пока пользователь не введет корректное целое число,
     * метод будет выводить сообщение об ошибке и запрашивать ввод снова.
     *
     * @return корректно введенное целое число
     */
    public int checkInteger() {
        int checkNumber;
        String line;
        while (true) {
            line = keyboard.next().trim();
            try {
                checkNumber = Integer.parseInt(line);
                System.out.println();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введено неверное число.");
                System.out.print("Введите целое число: ");
            }
        }
        return checkNumber;
    }

    /**
     * Считывает строку, проверяет, что она является целым числом,
     * и возвращает ее в виде строки.
     * Пока пользователь не введет корректное целое число,
     * метод будет выводить сообщение об ошибке и запрашивать ввод снова.
     *
     * @return строка, содержащая корректное целое число
     */
    public String checkStringInteger() {
        int checkNumber;
        String line;
        while (true) {
            line = keyboard.next().trim();
            try {
                checkNumber = Integer.parseInt(line);
                System.out.println();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введено неверное число.");
                System.out.print("Введите целое число: ");
            }
        }
        return line;
    }

    /**
     * Считывает и проверяет ввод вещественного числа.
     * Пока пользователь не введет корректное число типа {@code double},
     * метод будет выводить сообщение об ошибке и запрашивать ввод снова.
     *
     * @return корректно введенное вещественное число
     */
    public double checkDouble() {
        double checkNumber;
        String line;
        while (true) {
            line = keyboard.next().trim();
            try {
                checkNumber = Double.parseDouble(line);
                System.out.println();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введено неверное число.");
                System.out.print("Введите целое число: ");
            }
        }
        return checkNumber;
    }

    /**
     * Считывает и проверяет ввод строки.
     * Строка считается корректной, если она состоит только из букв.
     * Пока пользователь не введет такую строку, метод будет выводить
     * сообщение об ошибке и запрашивать ввод снова.
     *
     * @return корректно введенная строка, состоящая только из букв
     */
    public String checkString() {
        String line;
        boolean valid;
        while (true) {
            line = keyboard.next().trim();
            valid = true;
            for (int i = 0; i < line.length(); i++ ){
                char character = line.charAt(i);
                if (!Character.isLetter(character)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return line;
            } else {
                System.out.println("Ошибка. Строка должна состоять только из букв.");
                System.out.print("Введите новое значение: ");
            }
        }
    }
}
