package ru.kuzhleva.weapons;

/**
 * Класс, представляющий пистолет с ограниченной вместимостью магазина.
 * Класс наследует {@link NewWeapon} и расширяет его возможностями
 * перезарядки, разрядки, проверки состояния магазина и вывода
 * информации о текущем количестве патронов.
 *
 * @see NewWeapon
 */
public class GunIsARealWeapon extends NewWeapon{
    private final int magazineCapacity;

    /**
     * Создает пистолет со значениями по умолчанию.
     * Значения по умолчанию:
     * <ul>
     *     <li>количество патронов — 5</li>
     *     <li>вместимость магазина — 10</li>
     * </ul>
     */
    public GunIsARealWeapon() {
        super(5);
        this.magazineCapacity = 10;
        // В изначальной задаче 1.5.1 количество патронов 5.
        // Так как в 2.1.5 не указывается максимальное количество патронов по умолчанию, то я его устанавливаю как 10.
    }


    /**
     * Корректирует количество патронов в соответствии
     * с максимальной вместимостью магазина.
     *
     * @param cartridge количество патронов
     * @param magazineCapacity максимальная вместимость магазина
     * @return количество патронов, не превышающее вместимость магазина
     */
    private static int adjustAmmo(int cartridge, int magazineCapacity) {
        if (cartridge > magazineCapacity) {
            return magazineCapacity;
        }
        return cartridge;
    }

    /**
     * Создает пистолет с указанным количеством патронов
     * и вместимостью магазина.
     * Если переданное количество патронов превышает вместимость магазина,
     * количество патронов уменьшается до максимально допустимого значения.
     *
     * @param cartridge количество патронов
     * @param magazineCapacity вместимость магазина
     * @throws IllegalArgumentException если вместимость магазина
     *         меньше или равна нулю
     */
    public GunIsARealWeapon(int cartridge, int magazineCapacity) {
        super(adjustAmmo(cartridge,magazineCapacity));
        if (magazineCapacity <= 0) {
            throw new IllegalArgumentException("Обойма не может быть отрицательным числом или равна нулю.");
        }
        this.magazineCapacity = magazineCapacity;
    }

    /**
     * Создает пистолет с указанной вместимостью магазина
     * и количеством патронов по умолчанию.
     * Количество патронов по умолчанию равно 5.
     *
     * @param magazineCapacity вместимость магазина
     */
    public GunIsARealWeapon(int magazineCapacity) {
        super(5);
        this.magazineCapacity = magazineCapacity;
    }


    /**
     * Возвращает максимальную вместимость магазина.
     *
     * @return вместимость магазина
     */
    public int getMagazineCapacity() {
        return magazineCapacity;
    }

    /**
     * Перезаряжает пистолет указанным количеством патронов.
     * Если количество патронов превышает вместимость магазина,
     * магазин заполняется полностью, а лишние патроны возвращаются
     * как остаток.
     *
     * @param newCartridge новое количество патронов для загрузки
     * @return количество лишних патронов, не поместившихся в магазин
     * @throws IllegalArgumentException если количество патронов меньше 0
     */
    public int reload(int newCartridge) {
        if (newCartridge < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть меньше 0.");
        }
        int excess = 0;
        if (newCartridge > magazineCapacity) {
            load(magazineCapacity);
            excess = newCartridge - magazineCapacity;
        } else {
            load(newCartridge);
        }
        return excess;
    }


    /**
     * Разряжает магазин и возвращает количество извлеченных патронов.
     *
     * @return количество патронов, которое было в магазине до разрядки
     */
    public int unload() {
        int current = ammo;
        ammo = 0;
        return current;
    }

    /**
     * Выводит текущее состояние магазина в формате
     * {@code текущее количество/максимальная вместимость}.
     */
    public void printStatus() {
        System.out.println("Текущее количество патронов: " + ammo() + "/" + magazineCapacity);
    }

    /**
     * Проверяет, заряжен ли магазин.
     *
     * @return {@code true}, если в магазине есть патроны,
     *         иначе {@code false}
     */
    public boolean isLoaded() {
        return ammo() > 0;
    }

    /**
     * Проверяет, пуст ли магазин.
     *
     * @return {@code true}, если магазин пуст,
     *         иначе {@code false}
     */
    public boolean isEmpty() {
        return ammo() == 0;
    }

    /**
     * Выводит информацию о состоянии магазина.
     * Если магазин заряжен, выводится сообщение о количестве патронов.
     * Если магазин пуст, выводится сообщение о том, что магазин разряжен.
     */
    public void loaded() {
        if (isLoaded()) {
            if (ammo() % 10 == 1  && ammo() % 100 != 11) {
                System.out.println("Магазин заряжен на " + ammo() + " патрон.");
            } else {
                System.out.println("Магазин заряжен на " + ammo() + " патронов.");
            }
        } else {
            System.out.println("Магазин разряжен.");
        }
    }

    /**
     * Производит выстрел.
     * Если патроны есть, выводится {@code "Бах!"},
     * и количество патронов уменьшается на единицу.
     * Если патронов нет, выводится {@code "Клац!"}.
     */
    public void shoot() {
        if (ammo() > 0) {
            System.out.println("Бах!");
            getAmmo();
        } else {
            System.out.println("Клац!");
        }
    }

    /**
     * Возвращает строковое представление пистолета.
     * В строке указывается текущее количество патронов
     * с правильной формой слова.
     *
     * @return строковое представление пистолета
     */
    @Override
    public String toString() {
        if (ammo() % 10 == 1 && ammo() % 100 != 11) {
            return "Пистолет с " + ammo() + " патроном.";
        } else {
            return "Пистолет с " + ammo() + " патронами.";
        }
    }
}
