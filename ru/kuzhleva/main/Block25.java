package ru.kuzhleva.main;

import ru.kuzhleva.weapons.GunIsAWeapon;
import ru.kuzhleva.weapons.MachineGun;
import ru.kuzhleva.weapons.Shooter;

/**
 * Класс для работы со стрелком и его оружием.
 * Содержит методы, позволяющие выполнять выстрел,
 * задавать имя стрелку, выдавать ему оружие разных типов
 * и получать строковое представление состояния стрелка.
 *
 * @see Shooter
 * @see GunIsAWeapon
 * @see MachineGun
 */
public class Block25 {

    /**
     * Выполняет выстрел от имени указанного стрелка.
     *
     * @param shooter стрелок, который должен произвести выстрел
     */
    public void makeShoot(Shooter shooter) {
        shooter.shoot();
    }

    /**
     * Устанавливает имя указанному стрелку.
     *
     * @param shooter стрелок, которому задается имя
     * @param name имя стрелка
     */
    public void setName(Shooter shooter,String name) {
        shooter.setName(name);
    }

    /**
     * Выдает стрелку оружие типа {@link GunIsAWeapon}
     * с указанным количеством патронов и вместимостью.
     *
     * @param shooter стрелок, которому выдается оружие
     * @param cartridge количество патронов
     * @param storage вместимость оружия
     */
    public void setGun(Shooter shooter, int cartridge, int storage) {
        shooter.setWeapon(new GunIsAWeapon(cartridge,storage));
    }

    /**
     * Выдает стрелку оружие типа {@link MachineGun}
     * с указанным количеством патронов и вместимостью.
     *
     * @param shooter стрелок, которому выдается автомат
     * @param cartridge количество патронов
     * @param storage вместимость оружия
     */
    public void setAutomat(Shooter shooter, int cartridge, int storage) {
        shooter.setWeapon(new MachineGun(cartridge,storage));
    }

    /**
     * Возвращает строковое представление стрелка.
     * Если у стрелка есть оружие, в строку добавляется информация о нем.
     * Иначе указывается, что стрелок без оружия.
     *
     * @param shooter стрелок, для которого формируется строковое представление
     * @return строковое представление стрелка
     */
    public String toString(Shooter shooter) {
        return "Стрелок " + shooter.getName() + (shooter.getWeapon()!= null ? " с оружием " + shooter.getWeapon() : " без оружия.");
    }
}
