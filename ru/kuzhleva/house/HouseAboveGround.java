package ru.kuzhleva.house;

/**
 * Класс, представляющий наземный дом с заданным количеством этажей.
 * Объект данного класса хранит количество этажей дома.
 * При создании выполняется проверка, что количество этажей
 * является положительным числом.
 */
public class HouseAboveGround {
    private final int floors;

    /**
     * Создает объект дома с указанным количеством этажей.
     *
     * @param floors количество этажей в доме
     * @throws IllegalArgumentException если количество этажей
     *         отрицательное или равно нулю
     */
    public HouseAboveGround(int floors) {
        if (floors < 0) {
            throw new IllegalArgumentException("Количество этажей не может быть отрицательным числом.");
        }
        if (floors == 0) {
            throw new IllegalArgumentException("Количество этажей не может быть равно нулю.");
        }
        this.floors = floors;
    }

    /**
     * Возвращает количество этажей в доме.
     *
     * @return количество этажей
     */
    public int getFloors() {
        return floors;
    }

    /**
     * Возвращает слово, согласованное с количеством этажей.
     * Для числа, оканчивающегося на 1, кроме 11,
     * возвращается {@code "этажом"}.
     * Во всех остальных случаях возвращается {@code "этажами"}.
     *
     * @return слово, согласованное с количеством этажей
     */
    public String word() {
        if (floors % 10 == 1 && floors%100!=11) {
            return "этажом";
        } else {
            return "этажами";
        }
    }

    /**
     * Возвращает строковое представление объекта HouseAboveGround.
     * Формат строки:
     * {@code Дом с N этажом} или {@code Дом с N этажами}.
     *
     * @return строковое представление дома
     */
    @Override
    public String toString() {
        return "Дом с " + floors + " " + word();
    }
}
