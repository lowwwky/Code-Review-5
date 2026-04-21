package ru.kuzhleva.weapons;

/**
 * Класс, представляющий пистолет с возможностью перезарядки.
 * Объект данного класса хранит текущее количество патронов
 * и максимальную вместимость магазина. Класс позволяет
 * стрелять, перезаряжать оружие, разряжать его, проверять
 * состояние магазина и выводить информацию о нем.
 */
public class ReloadAGun {
    private int cartridge;
    private final int magazineCapacity;

    /**
     * Создает пистолет со значениями по умолчанию.
     * Значения по умолчанию:
     * <ul>
     *     <li>количество патронов — 5</li>
     *     <li>вместимость магазина — 10</li>
     * </ul>
     */
    public ReloadAGun() {
        this.cartridge = 5;
        this.magazineCapacity = 10;
        // Так как в задаче не написана максимальная вместимость,
        // а в изначальной задаче в пистолете 5 патронов если не указано
        // иначе, я выбрала 10.
    }



    /**
     * Создает пистолет с указанным количеством патронов
     * и вместимостью магазина.
     *
     * @param cartridge количество патронов
     * @param magazineCapacity вместимость магазина
     * @throws IllegalArgumentException если количество патронов отрицательное
     *         или вместимость магазина меньше либо равна нулю
     */
    public ReloadAGun(int cartridge, int magazineCapacity) {
        if (cartridge >= 0) {
            this.cartridge = cartridge;
            if (magazineCapacity > 0) {
                this.magazineCapacity = magazineCapacity;
            } else {
                throw new IllegalArgumentException("Вместимость пистолета не может быть равна нулю или отрицательной.");
            }
        } else {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным.");
        }
    }

    /**
     * Создает пистолет с указанной вместимостью магазина
     * и количеством патронов по умолчанию.
     * Количество патронов по умолчанию равно 5.
     *
     * @param magazineCapacity вместимость магазина
     */
    public ReloadAGun(int magazineCapacity) {
        this.cartridge = 5;
        this.magazineCapacity = magazineCapacity;
    }
    // У пистолета можно узнать максимальную вместимость
    public int getMagazineCapacity() {
        return magazineCapacity;
    }

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

    // FIX_ME: названия методов в виде lowerCase
    //public int Reload(int newCartridge) {
    /**
     * Перезаряжает пистолет указанным количеством патронов.
     * Если количество патронов превышает вместимость магазина,
     * магазин заполняется полностью, а лишние патроны
     * возвращаются как остаток.
     *
     * @param newCartridge количество патронов для перезарядки
     * @return количество лишних патронов, не поместившихся в магазин
     * @throws IllegalArgumentException если количество патронов меньше 0
     */
    public int reload(int newCartridge) {
        int excess = 0;
        if (newCartridge >= 0) {
            this.cartridge = newCartridge;
        } else {
            throw new IllegalArgumentException("Количество заряжаемых патронов не может быть меньше 0");
        }
        if (newCartridge > magazineCapacity) {
            this.cartridge = magazineCapacity;
            excess = newCartridge - magazineCapacity;
        } else {
            this.cartridge = newCartridge;
        }
        return excess;
    }

    /**
     * Производит выстрел.
     * Если патроны есть, выводится {@code "Бах!"},
     * и количество патронов уменьшается на единицу.
     * Если патронов нет, выводится {@code "Клац!"}.
     */
    public void shoot() {
        if (cartridge > 0) {
            System.out.println("Бах!");
            cartridge--;
        } else {
            System.out.println("Клац!");
        }
    }


    /**
     * Разряжает магазин и возвращает количество патронов,
     * которое было в нем до разрядки.
     *
     * @return количество извлеченных патронов
     */
    public int unload() {
        int current = this.cartridge;
        this.cartridge = 0;
        return current;
    }

    /**
     * Выводит текущее состояние магазина.
     * Если магазин не пуст, выводится текущее число патронов
     * и максимальная вместимость. Если магазин пуст,
     * дополнительно выводится сообщение о разрядке.
     */
    public void printStatus() {
        if (cartridge != 0) {
            System.out.println("Текущее количество заряженных патронов: " + cartridge + "/" + magazineCapacity);
        } else {
            System.out.println("Магазин разряжен.");
            System.out.println("Текущее количество патронов: 0/"+ magazineCapacity);
        }
    }

    /**
     * Проверяет, заряжен ли магазин.
     *
     * @return {@code true}, если в магазине есть патроны,
     *         иначе {@code false}
     */
    public boolean isLoaded() {
        return cartridge > 0;
    }

    /**
     * Проверяет, пуст ли магазин.
     *
     * @return {@code true}, если магазин пуст,
     *         иначе {@code false}
     */
    public boolean isEmpty() {
        return cartridge == 0;
    }

    /**
     * Выводит информацию о состоянии магазина.
     * Если магазин заряжен, выводится сообщение о количестве патронов.
     * Если магазин пуст, выводится сообщение о том, что магазин разряжен.
     */
    public void loaded() {
        if (isLoaded()) {
            if (cartridge%10==1 && cartridge%100!=11) {
                System.out.println("Магазин заряжен на " + cartridge + " патрон" );
            } else {
                System.out.println("Магазин заряжен на  " + cartridge + " патронов");
            }
        } else {
            System.out.println("Магазин разряжен.");
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
        if (cartridge % 10 == 1 && cartridge % 100 != 11) {
            return "Cтреляет пистолет с " + cartridge + " патроном";
        } else {
            return "Стреляет пистолет с " + cartridge + " патронами";
        }
    }
}
