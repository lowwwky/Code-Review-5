package ru.kuzhleva.weapons;

/**
 * Класс, представляющий автомат с возможностью стрельбы очередью.
 * Класс наследуется от {@link ReloadGun} и хранит значение
 * скорострельности автомата. Поддерживает создание автомата
 * с параметрами по умолчанию и с заданной вместимостью магазина
 * и скорострельностью.
 *
 * @see ReloadGun
 */
public class Automat extends ReloadGun {
    private final int speed;
        /**
         * Создает автомат со значениями по умолчанию.
         * Значения по умолчанию:
         * <ul>
         *     <li>количество патронов — 5</li>
         *     <li>вместимость магазина — 30</li>
         *     <li>скорострельность — 30</li>
         * </ul>
         */
    public Automat() {
        super();
        setCartridge(5);
        setMagazineCapacity(30);
        this.speed = 30;
    }

    /**
     * Создает автомат с указанной вместимостью магазина.
     * Количество патронов устанавливается равным 5,
     * а скорострельность вычисляется как половина
     * вместимости магазина.
     *
     * @param magazineCapacity вместимость магазина
     * @throws IllegalArgumentException если вместимость магазина
     *         меньше или равна нулю
     */
    public Automat(int magazineCapacity) {
        super();
        if (magazineCapacity > 0) {
            setCartridge(5);
            setMagazineCapacity(magazineCapacity);
            this.speed = magazineCapacity / 2;
        } else {
            throw new IllegalArgumentException("Вместимость магазина не может быть меньше единицы.");
        }
    }

    /**
     * Создает автомат с указанной вместимостью магазина
     * и скорострельностью.
     * Количество патронов устанавливается равным 5.
     *
     * @param magazineCapacity вместимость магазина
     * @param speed скорострельность автомата
     * @throws IllegalArgumentException если скорострельность
     *         меньше или равна нулю
     */
    public Automat(int magazineCapacity, int speed) {
        super();
        if (speed > 0) {
            setMagazineCapacity(magazineCapacity);
            setCartridge(5);
            this.speed = speed;
        } else {
            throw new IllegalArgumentException("Скорострельность не может быть меньше нуля.");
        }
    }


    /**
     * Возвращает скорострельность автомата.
     *
     * @return скорострельность автомата
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Производит стрельбу в течение указанного количества секунд.
     * За каждую секунду выполняется число выстрелов, равное
     * скорострельности автомата. Если патроны заканчиваются,
     * вместо выстрелов выводится сообщение {@code "Клац!"}.
     *
     * @param amountOfSeconds количество секунд стрельбы
     * @throws IllegalArgumentException если количество секунд
     *         меньше или равно нулю
     */
    // FIX_ME: названия переменных должны быть содержательными.
    // public void shoot(int n) {
    public void shoot(int amountOfSeconds) {
        if (amountOfSeconds <= 0) {
            throw new IllegalArgumentException("Количество секунд должно быть положительным числом.");
        } else {
            int bullets = getCartridge();
            int totalAmount = amountOfSeconds * speed;
            for (int i = 0; i < totalAmount; i++) {
                if (bullets > 0) {
                    System.out.println(i+1 +" Бах!");
                } else {
                    System.out.println(i+1 + " Клац!");
                }
                bullets--;
            }
            if (bullets >= 0) {
                setCartridge(bullets);
            } else {
                setCartridge(0);
            }
        }
    }

    /**
     * Производит стрельбу очередью длительностью в одну секунду.
     * <p>
     * Количество выстрелов равно значению скорострельности.
     * Если патроны заканчиваются, вместо выстрелов выводится
     * сообщение {@code "Клац!"}.
     * </p>
     */
    @Override
    public void shoot() {
        int bullets = getCartridge();
        for (int i = 0; i < speed; i++) {
            if (bullets > 0) {
                System.out.println(i+1 + " Бах!");
            } else {
                System.out.println(i+1 + " Клац!");
            }
            bullets--;
        }
        if (bullets >= 0) {
            setCartridge(bullets);
        } else {
            setCartridge(0);
        }
    }

    /**
     * Возвращает строковое представление автомата.
     * <p>
     * В строке указывается текущее количество патронов,
     * скорострельность и вместимость магазина.
     * </p>
     *
     * @return строковое представление автомата
     */
    @Override
    public String toString() {
        if (cartridge % 10 == 1 && cartridge % 100 != 11) {
            return "Cтреляет пистолет с " + cartridge + " патроном" + '\n'
                   + "Скорость пистолета: " + speed + '\n'
                   + "Вместимость пистолета: " + magazineCapacity;
        } else {
            return "Стреляет пистолет с " + cartridge + " патронами" + '\n'
                  + "Скорость пистолета: " + speed + '\n'
                   + "Вместимость пистолета: " + magazineCapacity;
        }
    }
}
