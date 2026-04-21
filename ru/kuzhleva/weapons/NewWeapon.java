package ru.kuzhleva.weapons;

/**
 * Абстрактный класс, представляющий оружие с некоторым количеством патронов.
 * Класс хранит текущее количество патронов и задает общее поведение
 * для оружия: возможность узнать число патронов, изменить его
 * и выполнить выстрел.
 * Конкретная реализация выстрела определяется в наследниках.
 */
abstract class NewWeapon {
    //private int ammo;
    protected int ammo;

    /**
     * Создает оружие с указанным количеством патронов.
     *
     * @param ammo начальное количество патронов
     * @throws IllegalArgumentException если количество патронов меньше 0
     */
    public NewWeapon(int ammo) {
        if (ammo < 0) {
            //throw new RuntimeException();
            throw new IllegalArgumentException("Количество патронов не может быть меньше 0.");
        }
        this.ammo = ammo;
    }

    /**
     * Выполняет выстрел.
     * Конкретная реализация метода определяется в подклассах.
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
        // fix_me: названия переменных должны быть осмысленными.
        // int temporary = ammo;
        int temporary = ammo;
        this.ammo = ammo;
        return temporary;
    }
}
