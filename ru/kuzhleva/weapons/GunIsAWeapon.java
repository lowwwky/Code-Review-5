package ru.kuzhleva.weapons;

import ru.kuzhleva.weapons.Weapon;

/**
 * Класс, представляющий пистолет с ограниченной вместимостью магазина.
 * Класс наследует {@link Weapon} и предоставляет возможности
 * стрельбы, перезарядки, разрядки магазина, проверки состояния
 * оружия и вывода информации о количестве патронов.
 *
 * @see Weapon
 */
public class GunIsAWeapon extends Weapon {
   // private int cartridge;
    private final int magazineCapacity;

//    public ru.kuzhleva.weapons.GunIsAWeapon() {
//        this.cartridge = 5;
//        this.magazineCapacity = 10;
//        // Так как в задаче не написана максимальная вместимость,
//        // а в изначальной задаче в пистолете 5 патронов если не указано
//        // иначе, я выбрала 10.
//}
//    // Пистолет имеет максимальное количество патронов, которое нельзя изменить после его создания.
//    public ru.kuzhleva.weapons.GunIsAWeapon(int cartridge, int magazineCapacity) {
//        if (cartridge >= 0) {
//            this.cartridge = cartridge;
//            if (magazineCapacity > 0) {
//                this.magazineCapacity = magazineCapacity;
//            } else {
//                throw new IllegalArgumentException("Вместимость пистолета не может быть равна нулю или отрицательной.");
//            }
//        } else {
//            throw new IllegalArgumentException("Количество патронов не может быть отрицательным.");
//        }
//    }
//    public void setCartridge(int cartridge) {
//        this.cartridge = cartridge;
//    }
//    public ru.kuzhleva.weapons.ReloadAGun(int cartridge) {
//        if (cartridge >= 0) {
//            this.cartridge = cartridge;
//        } else {
//            System.out.println("Ошибка! Количество патронов не может быть отрицательным числом.");
//            this.cartridge = 0;
//        }
//    }
//    public int Reload(int newCartridge) {
//        int excess = 0;
//        if (newCartridge >= 0) {
//            this.cartridge = newCartridge;
//        } else {
//            throw new IllegalArgumentException("Количество заряжаемых патронов не может быть меньше 0");
//        }
//        if (newCartridge > magazineCapacity) {
//            this.cartridge = magazineCapacity;
//            excess = magazineCapacity - newCartridge;
//        }
//
//        return excess;
//    }
//    public void shoot() {
//        if (cartridge > 0) {
//            System.out.println("Бах!");
//            cartridge--;
//        } else {
//            System.out.println("Клац!");
//        }
//    }
//    public int unload() {
//        int current = this.cartridge;
//        this.cartridge = 0;
//        return current;
//    }
//    public void printStatus() {
//        if (cartridge != 0) {
//            System.out.println("Текущее количество заряженных патронов: " + cartridge + "/" + magazineCapacity);
//        } else {
//            System.out.println("Магазин разряжен.");
//            System.out.println("Текущее количество патронов: 0/"+ magazineCapacity);
//        }
//    }
//    public boolean isLoaded() {
//        return cartridge > 0;
//    }
//    public boolean isEmpty() {
//        return cartridge == 0;
//    }
//    public void loaded() {
//        if (isLoaded()) {
//            if (cartridge%10==1 && cartridge%100!=11) {
//                System.out.println("Магазин заряжен на " + cartridge + " патрон" );
//            } else {
//                System.out.println("Магазин заряжен на  " + cartridge + " патронов");
//            }
//        } else {
//            System.out.println("Магазин разряжен.");
//        }
//    }
//    @Override
//    public String toString() {
//        if (cartridge % 10 == 1 && cartridge % 100 != 11) {
//            return "Cтреляет пистолет с " + cartridge + " патроном";
//        } else {
//            return "Стреляет пистолет с " + cartridge + " патронами";
//        }
//    }


    /**
     * Создает пистолет со значениями по умолчанию.
     * Значения по умолчанию:
     * <ul>
     *     <li>количество патронов — 5</li>
     *     <li>вместимость магазина — 10</li>
     * </ul>
     */
    public GunIsAWeapon() {
        super(5);
        this.magazineCapacity = 10;
        // В изначальной задаче 1.5.1 количество патронов 5.
        // Так как в 2.1.5 не указывается максимальное количество патронов по умолчанию, то я его устанавливаю как 10.
    }

    /**
     * Корректирует количество патронов так, чтобы оно
     * не превышало вместимость магазина.
     *
     * @param cartridge количество патронов
     * @param magazineCapacity вместимость магазина
     * @return допустимое количество патронов
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
     * оно автоматически уменьшается до максимально допустимого значения.
     *
     * @param cartridge количество патронов
     * @param magazineCapacity вместимость магазина
     * @throws IllegalArgumentException если вместимость магазина
     *         меньше или равна нулю
     */
    public GunIsAWeapon(int cartridge, int magazineCapacity) {
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
    public GunIsAWeapon(int magazineCapacity) {
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
     * магазин заряжается полностью, а количество лишних патронов
     * возвращается как остаток.
     *
     * @param newCartridge количество патронов для перезарядки
     * @return количество лишних патронов, не поместившихся в магазин
     * @throws IllegalArgumentException если количество патронов
     *         меньше или равно нулю
     */
    public int reload(int newCartridge) {
        if (newCartridge <= 0) {
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
     * Разряжает магазин и возвращает количество патронов,
     * которое было в нем до разрядки.
     *
     * @return количество извлеченных патронов
     */
    public int unload() {
        int current = ammo();
        load(0);
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
     * @return {@code true}, если в магазине нет патронов,
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

