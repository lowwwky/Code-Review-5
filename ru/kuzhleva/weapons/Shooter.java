package ru.kuzhleva.weapons;

import ru.kuzhleva.weapons.Weapon;

/**
 * Класс, представляющий стрелка с именем и оружием.
 * Объект данного класса хранит имя стрелка и ссылку на его оружие.
 * Стрелок может менять имя, получать оружие и выполнять выстрел,
 * если оружие у него есть.
 *
 * @see Weapon
 */
public class Shooter {
    private String name;
    private Weapon weapon;

    /**
     * Создает стрелка с указанным именем.
     *
     * @param name имя стрелка
     */
    public Shooter(String name) {
        this.name = name;
    }

    /**
     * Возвращает имя стрелка.
     *
     * @return имя стрелка
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает оружие стрелка.
     *
     * @return оружие стрелка
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Устанавливает новое имя стрелка.
     *
     * @param name новое имя стрелка
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Устанавливает оружие стрелку.
     *
     * @param weapon оружие стрелка
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Выполняет выстрел от имени стрелка.
     * Если у стрелка нет оружия, выводится сообщение о том,
     * что он не может участвовать в перестрелке.
     * Если оружие есть, выводится имя стрелка,
     * после чего вызывается метод выстрела у оружия.
     */
    public void shoot() {
        if (weapon == null) {
            System.out.println(name + " не может участвовать в перестрелке");
        } else {
            System.out.println(name + " ");
            weapon.shoot();
        }
    }

    /**
     * Возвращает строковое представление стрелка.
     * Если у стрелка есть оружие, в строку добавляется информация о нем.
     * Иначе указывается, что стрелок без оружия.
     *
     * @return строковое представление стрелка
     */
    @Override
    public String toString() {
        return "Стрелок " + name + (weapon != null ? " с оружием " + weapon : " без оружия.");
    }

}
