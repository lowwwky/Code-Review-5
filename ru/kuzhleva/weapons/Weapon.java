package ru.kuzhleva.weapons;

/**
 * Абстрактный класс, представляющий оружие с некоторым количеством патронов.
 * Класс хранит текущее количество патронов и задает общее поведение
 * для оружия: возможность узнать число патронов, изменить его
 * и выполнить выстрел.
 * Конкретная реализация выстрела определяется в наследниках.
 */
abstract class Weapon{
    private int ammo;

    /**
     * Создает оружие с указанным количеством патронов.
     *
     * @param ammo начальное количество патронов
     * @throws RuntimeException если количество патронов меньше 0
     */
    public Weapon(int ammo) {
        if (ammo < 0) {
            throw new RuntimeException();
        }
        this.ammo = ammo;
    }

    /**
     * Выполняет выстрел.
     * Конкретная реализация метода определяется в наследниках.
     */
    abstract void shoot();

    /**
     * Возвращает текущее количество патронов.
     *
     * @return текущее количество патронов
     */
    public int ammo() {
        return ammo;
    }


    /**
     * Уменьшает количество патронов на единицу,
     * если патроны еще есть.
     *
     * @return {@code false}, если патронов нет,
     *         и {@code false} после уменьшения количества патронов
     */
    public boolean getAmmo() {
        if (ammo == 0) {
            return false;
        }
        ammo--;
        return false;
    }

    /**
     * Устанавливает новое количество патронов.
     *
     * @param ammo новое количество патронов
     * @return установленное количество патронов
     * @throws RuntimeException если количество патронов меньше 0
     */
    public int load(int ammo) {
        if (ammo < 0) {
            throw new RuntimeException();
        }
        int tmp = ammo;
        this.ammo = ammo;
        return tmp;
    }
}