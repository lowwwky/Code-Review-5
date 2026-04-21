package ru.kuzhleva.lists;

import java.util.Arrays;

/**
 * Класс, представляющий неизменяемый список целых значений.
 * Объект данного класса хранит массив целых чисел, содержимое которого
 * нельзя изменить напрямую после создания объекта.
 * Все изменения выполняются через создание нового объекта.
 *
 * @see Arrays
 */
public class ImmutableListOfValues {
    private final int[] values;

    /**
     * Создает неизменяемый список на основе переданного набора значений.
     * Значения передаются как массив или как список аргументов
     * переменной длины.
     *
     * @param elements массив значений для создания списка
     * @throws IllegalArgumentException если переданный массив равен {@code null}
     */
    public ImmutableListOfValues(int... elements) {
        if (elements == null) {
            throw new IllegalArgumentException("Массив значений не может быть пустым.");
        }
        this.values = Arrays.copyOf(elements, elements.length);
    }

    /**
     * Создает неизменяемый список как копию другого списка.
     *
     * @param list список, значения которого нужно скопировать
     * @throws IllegalArgumentException если переданный список равен {@code null}
     */
    public ImmutableListOfValues(ImmutableListOfValues list) {
        if (list == null) {
            throw new IllegalArgumentException("Массив значений не может быть пустым.");
        }
        this.values = Arrays.copyOf(list.values,list.size());
    }

    /**
     * Возвращает значение элемента по указанному индексу.
     *
     * @param index индекс элемента
     * @return значение элемента по указанному индексу
     * @throws IndexOutOfBoundsException если индекс меньше 0
     *         или выходит за границы списка
     */
    public int positionN(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Значение индекса не может выходить за диапазон значений массива.");
        }
        return values[index];
    }

    /**
     * Возвращает новый список, в котором значение по указанному индексу
     * заменено на новое.
     * Текущий объект при этом не изменяется.
     * @param index индекс заменяемого элемента
     * @param value новое значение элемента
     * @return новый объект {@code ImmutableListOfValues} с измененным значением
     * @throws IndexOutOfBoundsException если индекс меньше 0
     *         или выходит за границы списка
     */
    public ImmutableListOfValues setValue(int index, int value) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Значение индекса не может выходить за диапазон значений массива.");
        }
        int[] newArr = Arrays.copyOf(values,values.length);
        newArr[index] = value;
        return new ImmutableListOfValues(newArr);
    }

    /**
     * Возвращает копию внутреннего массива значений.
     *
     * @return массив значений списка
     */
    public int[] toArray() {
        return Arrays.copyOf(values,values.length);
    }

    /**
     * Проверяет, пуст ли список.
     *
     * @return {@code true}, если список пуст, иначе {@code false}
     */
    public boolean isEmpty() {
        return (values.length == 0);
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return размер списка
     */
    public int size() {
        return values.length;
    }

    /**
     * Возвращает строковое представление списка.
     * Формат строки соответствует стандартному представлению массива.
     *
     * @return строковое представление списка
     */
    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
