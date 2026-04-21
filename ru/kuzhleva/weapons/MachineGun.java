package ru.kuzhleva.weapons;

/**
 * Класс, представляющий автомат с возможностью стрельбы очередью.
 * Класс наследует {@link GunIsAWeapon} и переопределяет
 * поведение выстрела и строковое представление объекта.
 *
 * @see GunIsAWeapon
 */
public class MachineGun extends GunIsAWeapon {
    private static final int defaultCartridge = 10;
    private static final int defaultStorage = 20;

    /**
     * Создает автомат с указанным количеством патронов
     * и вместимостью магазина.
     *
     * @param cartridge количество патронов
     * @param storage вместимость магазина
     */
    public MachineGun(int cartridge, int storage) {
        super(cartridge, storage);
    }

    /**
     * Создает автомат со значениями по умолчанию.
     * Значения по умолчанию:
     * <ul>
     *     <li>количество патронов — 10</li>
     *     <li>вместимость магазина — 20</li>
     * </ul>
     */
    public MachineGun() {
        super(defaultCartridge,defaultStorage);
    }

    /**
     * Производит выстрел очередью.
     * Если патроны есть, выводится {@code "Та-та-та!"},
     * и количество патронов уменьшается на единицу.
     * Если патронов нет, выводится {@code "Клац-клац-клац!"}.
     */
    @Override
    public void shoot() {
        if (ammo() > 0) {
            System.out.println("Та-та-та!");
            getAmmo();
        } else {
            System.out.println("Клац-клац-клац!");
        }
    }

    /**
     * Возвращает строковое представление автомата.
     * В строке указывается текущее количество патронов
     * с правильной формой слова.
     *
     * @return строковое представление автомата
     */
    @Override
    public String toString() {
        if (ammo() % 10 == 1 && ammo() %100 != 11) {
            return "Автомат с " + ammo() + " патроном.";
        } else {
            return "Автомат с " + ammo() + " патронами.";
        }
    }
}
