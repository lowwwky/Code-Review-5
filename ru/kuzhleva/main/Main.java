package ru.kuzhleva.main;

import ru.kuzhleva.errors.ErrorChecker;

import ru.kuzhleva.weapons.Automat;
import ru.kuzhleva.weapons.GunIsARealWeapon;
import ru.kuzhleva.weapons.GunIsAWeapon;
import ru.kuzhleva.weapons.MachineGun;
import ru.kuzhleva.weapons.ReloadAGun;
import ru.kuzhleva.weapons.Shooter;


import ru.kuzhleva.dots.Dots;
import ru.kuzhleva.maths.Exponentiation;
import ru.kuzhleva.house.HouseAboveGround;
import ru.kuzhleva.lists.ImmutableListOfValues;

public class Main {
    public static void main(String[] args) {
        boolean run, runner, running;
        int choice, additionalChoice, cartridge, storage, speed, shoot, load, value, index;
        double  xDot1, yDot1, xDot2, yDot2;
        String userX, userY, userName;
        ErrorChecker errors = new ErrorChecker();
        run = true;
        while (run) {
            System.out.println("""
                Добро пожаловать!
                Перед вами 3 лабораторная работа по Java.
                Всего есть на выбор 8 Задач.
                1. Дом над землёй и перезарядка пистолета.
                2. Неизменяемый массив.
                3. Автомат.
                4. Оружие.
                5. Лучший стрелок.
                6. Сравнение точек.
                7. Навести порядок, главный метод, возведение в степень.
                8. Патроны с наследниками.
                0. ВЫХОД ИЗ ПРОГРАММЫ.
                """);
            System.out.print("Введите число - номер задачи: ");
            choice = errors.checkInteger();
            switch(choice) {
                case 0: {
                    System.out.println("Завершение работы программы...");
                    System.out.println("""
                            ...
                            ....
                            .....
                            ......
                            """);
                    run = false;
                    break;
                }
                case 1: {
                    runner = true;
                    while (runner) {
                        System.out.println("""
                                Задача 1 разделена на две:
                                1. Дом над землёй.
                                2. Перезарядка пистолета
                                0. Завершение задания.
                                """);
                        System.out.print("Введите число - номер подзадачи: ");
                        additionalChoice = errors.checkInteger();
                        switch (additionalChoice) {
                            case 1: {
                                System.out.println("""
                                        Дом над землей.
                                        Измените сущность Дом из задачи 1.4.3. Гарантируйте, что у дома всегда будет положительное
                                        количество этажей. В случае попытки указать отрицательное количество этажей должна
                                        выбрасываться соответствующая ошибка. Продемонстрируйте работоспособность решения на
                                        примерах.
                                        """);
                                try {
                                    HouseAboveGround house = new HouseAboveGround(12);
                                    System.out.println(house);
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                                try {
                                    HouseAboveGround wrongHouse = new HouseAboveGround(-2);
                                    System.out.println(wrongHouse);
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                                try {
                                    HouseAboveGround anotherHouse = new HouseAboveGround(0);
                                    System.out.println(anotherHouse);
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                                while (true) {
                                    System.out.println("Введите число больше 0 - количество этажей в доме: ");
                                    additionalChoice = errors.checkInteger();
                                    try {
                                        HouseAboveGround userHouse = new HouseAboveGround(additionalChoice);
                                        System.out.println(userHouse);
                                        break;
                                    } catch (IllegalArgumentException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                System.out.println();
                                break;
                            }
                            case 2: {
                                System.out.println("""
                                        Перезарядка Пистолета.
                                        Измените сущность Пистолет из задачи 1.5.1. Модификация предполагает внесение следующих
                                        дополнительных требований:
                                         Имеет максимальное количество патронов. Максимальное количество устанавливается во
                                        время создания пистолета и не может быть изменено позднее. У пистолета можно узнать,
                                        какое максимальное количество он вмещает.
                                         Может быть перезаряжен. Для перезарядки необходимо передать пистолету число,
                                        которое будет означать количество заряжаемых патронов. Если передано отрицательное
                                        число, необходимо выбросить ошибку, объясняющую, что отрицательного числа
                                        патронов быть не может. Если передано слишком большое число патронов – необходимо
                                        лишние вернуть.
                                         Может быть разряжен. Это приводит к обнулению патронов в пистолете и возврате
                                        нужного числа пользователю.
                                         Можно узнать сколько сейчас заряжено патронов.
                                         Можно узнать заряжен он или разряжен.
                                        Создайте пистолет вместимостью 7, зарядите три патрона, выстрелите из него пять раз, затем
                                        зарядите в него 8 патронов, выстрелите еще 2 раза, разрядите его, сделайте контрольный
                                        выстрел.
                                        Если все выполнено верно, то должно быть выведено: Бах! Бах! Бах! Клац! Клац! Бах! Бах! Клац!
                                        """);
                                System.out.println("Создаем пистолет вместимостью 7...");
                                ReloadAGun gun = new ReloadAGun(7);
                                System.out.println("Началась стрельба...");
                                gun.reload(3);
                                for (int i = 0; i < 5; i++ ) {
                                    gun.shoot();
                                }
                                System.out.println("Перезарядка магазина...");
                                gun.reload(8);
                                System.out.println("Перезарядка магазина завершена успешно.");
                                System.out.println("Началась стрельба...");
                                for (int i = 0; i < 2; i++) {
                                    gun.shoot();
                                }
                                System.out.println("Разряжаем магазин....");
                                gun.unload();
                                System.out.println("Магазин разряжен успешно...");
                                System.out.println("Началась стрельба...");
                                gun.shoot();
                                System.out.println();
                                System.out.println("""
                                Сейчас вам необходимо будет создать пистолет самостоятельно.
                                Для этого нужно указать два целых числа:
                                Количество пуль и вместимость магазина.
                                Вместимость магазина не может быть меньше 1.
                                Количество пуль не может быть меньше 0.
                                """);
                                while (true) {
                                    System.out.print("Введите целое неотрицательное число - количество пуль: ");
                                    cartridge = errors.checkInteger();
                                    if (cartridge < 0) {
                                        System.out.println("Введено неверное значение.");
                                    } else {
                                        break;
                                    }
                                }
                                while (true) {
                                    System.out.print("Введите целое положительное число - вместимость магазина: ");
                                    storage = errors.checkInteger();
                                    if (storage <= 0) {
                                        System.out.println("Введено неверное значение.");
                                    } else {
                                        break;
                                    }
                                }
                                System.out.println("Создаем пистолет...");
                                ReloadAGun userGun = new ReloadAGun(cartridge,storage);
                                System.out.println("Пистолет создан...");
                                while (true) {
                                    System.out.print("Введите число - количество выстрелов: ");
                                    shoot = errors.checkInteger();
                                    if (shoot < 0) {
                                        System.out.println("Введено неверное значение.");
                                    } else {
                                        break;
                                    }
                                }
                                System.out.println("Началась стрельба....");
                                for (int i = 0; i < shoot; i++) {
                                    userGun.shoot();
                                }
                                while (true) {
                                    System.out.print("Введите число - количество пуль, которые вы хотите зарядить: ");
                                    load = errors.checkInteger();
                                    if (load < 0) {
                                        System.out.println("Введено неверное значение.");
                                    } else {
                                        break;
                                    }
                                }
                                System.out.println("Перезаряжаем магазин...");
                                userGun.reload(load);
                                System.out.println("Пистолет успешно перезаряжен...");
                                while (true) {
                                    System.out.print("Введите число - количество выстрелов: ");
                                    shoot = errors.checkInteger();
                                    if (shoot < 0) {
                                        System.out.println("Введено неверное значение.");
                                    } else {
                                        break;
                                    }
                                }
                                System.out.println("Началась стрельба....");
                                for (int i = 0; i < shoot; i++) {
                                    userGun.shoot();
                                }
                                System.out.println(userGun);
                                System.out.println();
                                break;
                            }
                            case 0: {
                                System.out.println("Завершение задания...");
                                runner = false;
                                System.out.println();
                                break;
                            }
                            default: {
                                System.out.println("Введено неверное значение.");
                                System.out.println();
                                break;
                            }
                        }
                    }
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.println("""
                            Неизменяемый массив.
                            Необходимо разработать сущность НеизменяемыйСписокЗначений, представляющий собой
                            обертку над массивом целых чисел, который сохранит функциональные возможности массивов,
                            но добавит некоторые дополнительные возможности.
                            Состояние сущности описывают следующие сведения:
                             Имеет массив целых чисел. Именно он используется для хранения значений.
                            Инициализация сущности может быть выполнена следующим образом:
                             С указанием значений в виде массива целых чисел.
                             С указанием перечня чисел как независимых значений (через запятую)
                             С указанием другого Списка, в этом случае копируются все значения указанного списка.
                            Поведение сущности описывают следующие действия:
                             Получение значения из позиции N. Позиция должна попадать в диапазон от 0 до N-1, где
                            N–текущее количество значений, иначе выкинуть ошибку.
                             Замена значения в позиции N на новое значение. Позиция должна попадать в диапазон от
                            0 до N-1, где N–текущее количество значений, иначе выкинуть ошибку.
                             Может быть приведен к строке. Строка должна представлять собой полный перечень всех
                            хранимых чисел, причем первый символ строки это ”[“, а последний “]”.
                             Можно проверить пуст Список или нет. Список пуст если его размер 0.
                             Можно узнать текущий размер.
                             Все хранящиеся значения можно запросить в виде стандартного массива.
                            Продемонстрируйте работоспособность решения на примерах.
                            """);
                    int[] array1 = {1,2,3,4,5,6,7,8,9};
                    ImmutableListOfValues list1 = new ImmutableListOfValues(array1);
                    ImmutableListOfValues list2 = new ImmutableListOfValues(10,11,12,13,14);
                    ImmutableListOfValues list3 = new ImmutableListOfValues(list1);
                    ImmutableListOfValues list4 = new ImmutableListOfValues(7,7,7,7,7,7,7,7);

                    System.out.println("Первый массив: ");
                    System.out.println(list1);
                    System.out.println("Второй массив: ");
                    System.out.println(list2);
                    System.out.println("Третий массив: ");
                    System.out.println(list3);

                    System.out.print("Получим в первом массиве значение на позиции 3: ");
                    System.out.print(list1.positionN(2));
                    System.out.println();
                    System.out.println("Изменим во втором массиве элемент 11 на элемент 7.");
                    ImmutableListOfValues newList = list2.setValue(1,7);
                    System.out.print("Полученный список: ");
                    System.out.print(newList);
                    System.out.println();
                    System.out.println("Проверим, пуст ли новый список.");
                    System.out.print("Новый список пустой? " + newList.isEmpty());
                    System.out.println();
                    System.out.println("Узнаем размер третьего списка.");
                    System.out.print("Размер третьего списка: " + list3.size());
                    System.out.println();
                    System.out.println("Приведем первый массив к строке: ");
                    System.out.print(list1);
                    System.out.println();
                    System.out.println("Переведем массив класса ImmutableListOfValues в обычный массив: ");
                    int[] regularArray = list4.toArray();
                    for (int i = 0; i < regularArray.length; i++) {
                        System.out.print(regularArray[i] + " ");
                    }
                    System.out.println();


                    System.out.println("""
                            Создадим массив вместе.
                            Вам нужно будет ввести целое число больше либо равно 0 - количество элементов в массиве.
                            А потом ввести значения в этот массив.
                            """);
                    while (true) {
                        System.out.print("Введите число - количество элементов в массиве: ");
                        additionalChoice = errors.checkInteger();
                        if (additionalChoice < 0) {
                            System.out.println("Введено неверное значение.");
                        } else {
                            break;
                        }
                    }
                    if (additionalChoice != 0 ) {
                        int[] userArray = new int[additionalChoice];
                        for (int i = 0; i < additionalChoice; i++) {
                            System.out.println("Введите " + (i + 1) + "-ое значение: ");
                            value = errors.checkInteger();
                            userArray[i] = value;
                        }
                        ImmutableListOfValues userList = new ImmutableListOfValues(userArray);
                        while (true) {
                            try {
                                System.out.println("Есть индексы от 0 до " + (userList.size() - 1));
                                System.out.print("Введите число - индекс, а мы выведем значение находящееся под этим индексом: ");
                                additionalChoice = errors.checkInteger();

                                System.out.println("Значение: " + userList.positionN(additionalChoice));
                                break;
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Ошибка. Индекс не может быть вне диапазона значений");
                            } catch (Exception e) {
                                System.out.println("Неизвестная ошибка: " + e.getMessage());
                            }
                        }
                        System.out.println();
                        System.out.println("Размер массива: " + userList.size());
                        System.out.println("Пуст ли массив? " + userList.isEmpty());
                        System.out.println();
                        while (true) {
                            try {
                                System.out.println("На каком индексе от 0 до " + ((userList.size()) - 1) + " вы хотите установить новое значение? ");
                                System.out.print("Введите индекс: ");
                                index = errors.checkInteger();
                                System.out.print("Введите число - значение этого элемента: ");
                                value = errors.checkInteger();
                                ImmutableListOfValues newUser = userList.setValue(index, value);
                                System.out.println("Полученный массив:");
                                System.out.println(newUser);
                                break;
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Ошибка. Индекс не может быть вне диапазона значений.");
                            } catch (Exception e) {
                                System.out.println("Неизвестная ошибка: " + e.getMessage());
                            }
                        }

                        System.out.println();
                    } else {
                        System.out.println("Массив пустой. ");
                        System.out.println("Работа с массивом невозможна.");
                        System.out.println();
                    }
                    break;
                }
                case 3: {
                    System.out.println("""
                            Автомат. Создайте такой подвид сущности Пистолет из задачи 2.1.5, которая будет совпадать с
                            ней во всех отношениях, кроме следующего:
                             Имеет скорострельность (целое число, неизменяемое) которое обозначает количество
                            выстрелов в секунду, поддерживаемое данным автоматом. Скорострельность всегда
                            положительное число.
                             При вызове Стрелять количество выстрелов соответствует скорострельности (например,
                            при скорострельности 3 выводится три строки с текстом выстрела).
                             Умеет Стрелять N секунд, что приводит к количеству выстрелов равному N умноженное
                            на скорострельность.
                             Инициализация может быть выполнены следующими способами:
                            a) Без параметров. Скорострельность 30, вместимость 30.
                            b) С указанием максимального числа патронов. Скорострельность будет равна
                            половине обоймы
                            c) С указанием максимального количества патронов в обойме и скорострельности.\s
                            """);
                    Automat automat1 = new Automat();
                    System.out.println("Скорость первого пистолета: " + automat1.getSpeed());
                    System.out.println("Вместимость первого пистолета: " + automat1.getMagazineCapacity());
                    System.out.println("Количество патронов первого пистолета: " + automat1.getCartridge());
                    System.out.println("Стрельба началась...");
                    automat1.shoot();
                    System.out.println();
                    System.out.println("Перезаряжаем автомат.....");
                    automat1.Reload(10);
                    System.out.println("Автомат перезаряжен успешно.");
                    automat1.printStatus();
                    System.out.println("Стрельба на две секунды началась....");
                    automat1.shoot(2);
                    System.out.println(automat1);
                    System.out.println();

                    Automat automat2 = new Automat(10);
                    System.out.println("Скорость второго пистолета: " + automat2.getSpeed());
                    System.out.println("Вместимость второго пистолета: " + automat2.getMagazineCapacity());
                    automat2.setCartridge(7);
                    System.out.println("Количество патронов второго пистолета: " + automat2.getCartridge());
                    System.out.println("Стрельба началась....");
                    automat2.shoot();
                    automat2.printStatus();
                    System.out.println();
                    System.out.println("Стрельба на три секунды началась....");
                    automat2.shoot(3);
                    System.out.println(automat2);
                    System.out.println();

                    System.out.println("""
                            Создаём пистолет вместе.
                            Вам будет необходимо ввести три числа:
                            1. Скорость пистолета (целое положительное число).
                            Положительные числа начинаются с 1.
                            2. Вместимость магазина (целое положительное число).
                            Положительные числа начинаются с 1.
                            3. Количество пуль (целое неотрицательное число).
                            Неотрицательные числа начинаются с 0.
                            """);
                    while (true) {
                        System.out.print("Введите целое положительное число - скорость пистолета: ");
                        speed = errors.checkInteger();
                        if (speed <= 0) {
                            System.out.println("Введено неверное значение.");
                        } else {
                            break;
                        }
                    }
                    while (true) {
                        System.out.print("Введите целое положительное число - вместимость магазина: ");
                        storage = errors.checkInteger();
                        if (storage <= 0) {
                            System.out.println("Введено неверное значение.");
                        } else {
                            break;
                        }
                    }
                    System.out.println("Создаём пистолет....");
                    Automat userAutomat = new Automat(storage,speed);
                    System.out.println("Зарядим пистолет....");
                    while (true) {
                        System.out.print("Введите целое неотрицательное число - количество пуль: ");
                        cartridge = errors.checkInteger();
                        if (cartridge < 0) {
                            System.out.println("Введено неверное значение.");
                        } else {
                            break;
                        }
                    }
                    userAutomat.setCartridge(cartridge);
                    System.out.println("Характеристики вашего пистолета: ");
                    System.out.println("Скорость вашего пистолета: " + userAutomat.getSpeed());
                    System.out.println("Вместимость вашего пистолета: " + userAutomat.getMagazineCapacity());
                    System.out.println("Количество патронов вашего пистолета: " + userAutomat.getCartridge());
                    System.out.println("Стрельба началась....");
                    userAutomat.shoot();
                    while (true) {
                        try {
                            System.out.println("Введите целое число - количество выстрелов: ");
                            shoot = errors.checkInteger();
                            if (shoot % 10 == 1 && shoot % 100 == 1) {
                                System.out.println("Стрельба на " + shoot + " секунду со скорострельностью " + userAutomat.getSpeed() + " началась.");
                            } else {
                                System.out.println("Стрельба на " + shoot + " секунд со скорострельностью " + userAutomat.getSpeed() + " началось.");
                            }
                            userAutomat.shoot(shoot);
                            break;
                        } catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка: " + e.getMessage());
                        }
                    }

                    System.out.println(userAutomat);
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.println("""
                            Оружие.
                            Измените сущность Пистолет, полученную в задаче 2.1.5 таким образом, чтобы она наследовалась
                            от класса Weapon описанного на рисунке.
                            """);
                    GunIsAWeapon gun1 = new GunIsAWeapon();
                    System.out.println(gun1);
                    System.out.println("Пуст ли первый пистолет? " + gun1.isEmpty());
                    System.out.println("Вместимость магазина: " + gun1.getMagazineCapacity());
                    System.out.println("Заряжен ли магазин? " + gun1.isLoaded());
                    System.out.println("Стрельба началась....");
                    gun1.shoot();
                    System.out.println("Статус: ");
                    gun1.printStatus();
                    System.out.println("Разряжаем магазин...");
                    gun1.unload();
                    gun1.printStatus();
                    System.out.println("Стрельба началась....");
                    gun1.shoot();
                    System.out.println("Заряжаем магазин...");
                    gun1.reload(3);
                    gun1.printStatus();
                    System.out.println("Стрельба началась....");
                    for (int i = 0; i < 4; i++) {
                        gun1.shoot();
                    }
                    System.out.println(gun1);
                    System.out.println();

                    GunIsAWeapon gun2 = new GunIsAWeapon(4);
                    System.out.println(gun2);
                    System.out.println("Пуст ли второй пистолет? " + gun2.isEmpty());
                    System.out.println("Вместимость магазина: " + gun2.getMagazineCapacity());
                    System.out.println("Заряжен ли магазин? " + gun2.isLoaded());
                    System.out.println("Стрельба началась....");
                    gun2.shoot();
                    System.out.println("Статус: ");
                    gun2.printStatus();
                    System.out.println("Разряжаем магазин...");
                    gun2.unload();
                    gun2.printStatus();
                    System.out.println("Перезаряжаем магазин...");
                    gun2.reload(2);
                    gun2.printStatus();
                    System.out.println("Стрельба началась....");
                    gun2.shoot();
                    System.out.println(gun2);
                    System.out.println();

                    System.out.println("""
                            Сейчас вам необходимо будет создать пистолет самостоятельно.
                            Для этого нужно указать два целых числа:
                            Количество пуль и вместимость магазина.
                            Вместимость магазина не может быть меньше 1.
                            Количество пуль не может быть меньше 0.
                            """);
                    while (true) {
                        System.out.print("Введите целое неотрицательное число - количество пуль: ");
                        cartridge = errors.checkInteger();
                        if (cartridge < 0) {
                            System.out.println("Введено неверное значение.");
                        } else {
                            break;
                        }
                    }
                    while (true) {
                        System.out.print("Введите целое положительное число - вместимость магазина: ");
                        storage = errors.checkInteger();
                        if (storage <= 0) {
                            System.out.println("Введено неверное значение.");
                        } else {
                            break;
                        }
                    }
                    GunIsAWeapon userGun = new GunIsAWeapon(cartridge,storage);
                    System.out.println(userGun);
                    System.out.println("Пуст ли ваш пистолет? " + userGun.isEmpty());
                    System.out.println("Вместимость магазина: " + userGun.getMagazineCapacity());
                    System.out.println("Заряжен ли магазин? " + userGun.isLoaded());
                    System.out.println("Началась стрельба....");
                    userGun.shoot();
                    System.out.println("Статус: ");
                    userGun.printStatus();
                    System.out.println("Разряжаем магазин...");
                    userGun.unload();
                    userGun.printStatus();
                    userGun.shoot();
                    System.out.println("Заряжаем магазин....");
                    userGun.reload(5);
                    userGun.printStatus();
                    System.out.println("Началась стрельба....");
                    for (int i = 0; i < 10; i++) {
                        userGun.shoot();
                    }
                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.println("""
                            Лучший стрелок.
                            Создайте сущность Стрелок, которая описывается:
                             Имя, строка
                             Оружие, из задачи 2.4.1.
                             При создании объекта необходимо указать ему имя
                             Имя и оружие можно поменять и получить в любой момент без ограничения.
                            Основная способность Стрелка - умение стрелять. Если оружие есть, то выстрел происходит по
                            правилам оружия, если его нет – то выводится текст “не могу участвовать в перестрелке”.
                            Создайте трех стрелков: одного без оружия, одного с пистолетом и одного с автоматом, и пусть
                            каждый из них выстрелит.
                            """);
                    Shooter shooter1 = new Shooter("Алексей");
                    Shooter shooter2 = new Shooter("Михаил");
                    Shooter shooter3 = new Shooter("Александр");

                    shooter2.setWeapon(new GunIsAWeapon(3,5));
                    shooter3.setWeapon(new MachineGun(6,7));

                    System.out.println(shooter1);
                    System.out.println(shooter2);
                    System.out.println(shooter3);
                    System.out.println();
                    shooter1.shoot();
                    System.out.println();
                    shooter2.shoot();
                    System.out.println();
                    shooter3.shoot();
                    System.out.println();

                    shooter1.setName("Николай");
                    shooter1.setWeapon(new MachineGun(0,5));
                    System.out.println(shooter1);
                    System.out.println(shooter2);
                    System.out.println(shooter3);
                    System.out.println();
                    shooter1.shoot();
                    System.out.println();
                    shooter2.shoot();
                    System.out.println();
                    shooter3.shoot();
                    System.out.println();
                    runner = true;
                    while (runner) {
                        System.out.println("""
                                Давайте создадим вашего стрелка.
                                Вам нужно будет написать имя.
                                На выбор есть три варианта оружия:
                                1. Без оружия.
                                2. Пистолет.
                                3. Автомат.
                                0. ЗАВЕРШЕНИЕ ЗАДАНИЯ
                                """);
                        System.out.print("Выберите стрелку оружие: ");
                        additionalChoice = errors.checkInteger();
                        switch (additionalChoice) {
                            case 0: {
                                System.out.println("Завершение задания...");
                                runner = false;
                                break;
                            }
                            case 1: {
                                System.out.print("Напишите имя стрелка: ");
                                userName = errors.checkString();
                                Shooter userShooter = new Shooter(userName);
                                userShooter.shoot();
                                System.out.println(userShooter);
                                System.out.println();
                                break;
                            }
                            case 2: {
                                System.out.print("Напишите имя стрелка: ");
                                userName = errors.checkString();
                                Shooter userShooter = new Shooter(userName);
                                while (true) {
                                    System.out.print("Введите целое неотрицательное число - количество пуль: ");
                                    cartridge = errors.checkInteger();
                                    if (cartridge < 0) {
                                        System.out.println("Введено неверное значение.");
                                    } else {
                                        break;
                                    }
                                }
                                while (true) {
                                    System.out.print("Введите целое положительное число - вместимость магазина: ");
                                    storage = errors.checkInteger();
                                    if (storage <= 0) {
                                        System.out.println("Введено неверное значение.");
                                    } else {
                                        break;
                                    }
                                }
                                userShooter.setWeapon(new GunIsAWeapon(cartridge, storage));
                                userShooter.shoot();
                                System.out.println(userShooter);
                                System.out.println();
                                break;
                            }
                            case 3: {
                                System.out.print("Напишите имя стрелка: ");
                                userName = errors.checkString();
                                Shooter userShooter = new Shooter(userName);
                                while (true) {
                                    System.out.print("Введите целое неотрицательное число - количество пуль: ");
                                    cartridge = errors.checkInteger();
                                    if (cartridge < 0) {
                                        System.out.println("Введено неверное значение.");
                                    } else {
                                        break;
                                    }
                                }
                                while (true) {
                                    System.out.print("Введите целое положительное число - вместимость магазина: ");
                                    storage = errors.checkInteger();
                                    if (storage <= 0) {
                                        System.out.println("Введено неверное значение.");
                                    } else {
                                        break;
                                    }
                                }
                                userShooter.setWeapon(new MachineGun(cartridge, storage));
                                userShooter.shoot();
                                System.out.println(userShooter);
                                System.out.println();
                                break;
                            }
                            default: {
                                System.out.println("Введено неверное значение.");
                                System.out.println();
                                break;
                            }
                        }
                    }
                    System.out.println();
                    break;
                }
                case 6: {
                    System.out.println("""
                            Сравнение точек.
                            Измените сущность Точка из задачи 1.4.1. Переопределите метод сравнения объектов по
                            состоянию таким образом, чтобы две точки считались одинаковыми тогда, когда они
                            расположены в одинаковых координатах.
                            """);
                    System.out.println("""
                            Вам необходимо будет ввести четыре значения:
                            1. Координата Х первой точки
                            2. Координата Y первой точки
                            3. Координата X второй точки
                            4. Координата Y второй точки
                            """);
                    System.out.print("Введите координату X первой точки: ");
                    xDot1 = errors.checkDouble();
                    System.out.print("Введите координату Y первой точки: ");
                    yDot1 = errors.checkDouble();
                    System.out.print("Введите координату X второй точки: ");
                    xDot2 = errors.checkDouble();
                    System.out.print("Введите координату Y второй точки: ");
                    yDot2 = errors.checkDouble();
                    System.out.println("""
                            Проверяем, одинаковы ли точки...
                            """);
                    Dots dot1 = new Dots(xDot1,yDot1);
                    System.out.println(dot1);
                    Dots dot2 = new Dots(xDot2,yDot2);
                    System.out.println(dot2);
                    System.out.println();
                    System.out.println("Равны ли точки?" + "  "+dot1.equals(dot2));
                    System.out.println();
                    break;
                }
                case 7: {
                    runner = true;
                    while (runner) {
                        System.out.println("Данная задача разделена на три подзадачи: ");
                        System.out.println("""
                                1.  Навести порядок.
                                   Данная задача предполагает реорганизацию ранее написанных классов. Расположите все ранее
                                   написанные классы по пакетам таким образом, чтобы логически близкие классы оказались
                                   сгруппированы друг с другом. Имена пакетов должны иметь как минимум трёхсоставную форму,
                                   вида: ru.surname.type. Вместо surname следует подставить свою фамилию, а вместо type
                                   подставить название логического блока. Например, классы описывающие точку, линию, ломаную
                                   линию, фигуру, квадрат, треугольник, круг и прямоугольник можно расположить в пакете
                                   ru.surname.geometry.
                                2. Главный метод.
                                   Создайте пакет ru.surname.main (вместо surname необходимо подставить собственную
                                   фамилию) в котором расположить класс с точкой входа в исполнение программы (public static void
                                   main). Также следует проверить, что ни в одном другом пакете нет классов имеющих точку входа
                                   в исполнение программы. В этом же пакете необходимо расположить класс (или интерфейс) с
                                   методами из задач блока 2.5 и продемонстрировать их работоспособность.
                                3.  Возведение в степень.
                                   Создайте метод принимающий две строки, в которых будут записаны числа X и Y. Возвращает
                                   метод результат возведения X в степень Y. Для преобразования строки в число следует
                                   использовать метод Integer.parseInt, а для возведения в степень метод Math.pow. Вызовите
                                   разработанный метод передав туда параметры командной строки полученные точкой входа в
                                   программу. Реализуйте метод так, что бы для возведения в степень и преобразования строки
                                   использовались короткие имена статических методов.
                                0. ЗАВЕРШЕНИЕ РАБОТЫ ЗАДАЧИ.
                                """);
                        System.out.print("Выберите число - номер подзадачи: ");
                        additionalChoice = errors.checkInteger();
                        switch (additionalChoice) {
                            case 0: {
                                System.out.println("Завершение работы задачи...");
                                System.out.println();
                                runner = false;
                                break;
                            }
                            case 1: {
                                System.out.println("""
                                        Выполнение этого задания можно посмотреть у меня
                                        слева в проекте, а также на скриншоте в отчёте
                                        (см. раздел тестирование).
                                        """);
                                break;
                            }
                            case 2: {
                                System.out.println("""
                                        Выполнение первой части задачи можно посмотреть также слева
                                        в проекте.
                                        """);
                                Block25 methods = new Block25();
                                Shooter shooter1 = new Shooter("Алексей");
                                Shooter shooter2 = new Shooter("Михаил");
                                Shooter shooter3 = new Shooter("Александр");

                                methods.setGun(shooter2, 3,5);
                                methods.setAutomat(shooter3, 6,7);

                                System.out.println(methods.toString(shooter1));
                                System.out.println(methods.toString(shooter2));
                                System.out.println(methods.toString(shooter3));
                                System.out.println();
                                methods.makeShoot(shooter1);
                                System.out.println();
                                methods.makeShoot(shooter2);
                                System.out.println();
                                methods.makeShoot(shooter2);
                                System.out.println();

                                methods.setName(shooter1, "Николай");
                                methods.setGun(shooter1,5,6);
                                methods.makeShoot(shooter1);
                                System.out.println();
                                methods.makeShoot(shooter2);
                                System.out.println();
                                methods.makeShoot(shooter2);
                                System.out.println();

                                running = true;
                                while (running) {
                                    System.out.println("""
                                Давайте создадим вашего стрелка.
                                Вам нужно будет написать имя.
                                На выбор есть три варианта оружия:
                                1. Без оружия.
                                2. Пистолет.
                                3. Автомат.
                                0. ЗАВЕРШЕНИЕ ЗАДАНИЯ
                                """);
                                    System.out.print("Выберите стрелку оружие: ");
                                    additionalChoice = errors.checkInteger();
                                    switch (additionalChoice) {
                                        case 0: {
                                            System.out.println("Завершение задания...");
                                            running = false;
                                            break;
                                        }
                                        case 1: {
                                            System.out.print("Напишите имя стрелка: ");
                                            userName = errors.checkString();
                                            Shooter userShooter = new Shooter(userName);
                                            methods.makeShoot(userShooter);
                                            System.out.println(methods.toString(userShooter));
                                            System.out.println();
                                            break;
                                        }
                                        case 2: {
                                            System.out.print("Напишите имя стрелка: ");
                                            userName = errors.checkString();
                                            Shooter userShooter = new Shooter(userName);
                                            while (true) {
                                                System.out.print("Введите целое неотрицательное число - количество пуль: ");
                                                cartridge = errors.checkInteger();
                                                if (cartridge < 0) {
                                                    System.out.println("Введено неверное значение.");
                                                } else {
                                                    break;
                                                }
                                            }
                                            while (true) {
                                                System.out.print("Введите целое положительное число - вместимость магазина: ");
                                                storage = errors.checkInteger();
                                                if (storage <= 0) {
                                                    System.out.println("Введено неверное значение.");
                                                } else {
                                                    break;
                                                }
                                            }
                                            methods.setGun(userShooter,cartridge,storage);
                                            methods.makeShoot(userShooter);
                                            System.out.println(methods.toString(userShooter));
                                            System.out.println();
                                            break;
                                        }
                                        case 3: {
                                            System.out.print("Напишите имя стрелка: ");
                                            userName = errors.checkString();
                                            Shooter userShooter = new Shooter(userName);
                                            while (true) {
                                                System.out.print("Введите целое неотрицательное число - количество пуль: ");
                                                cartridge = errors.checkInteger();
                                                if (cartridge < 0) {
                                                    System.out.println("Введено неверное значение.");
                                                } else {
                                                    break;
                                                }
                                            }
                                            while (true) {
                                                System.out.print("Введите целое положительное число - вместимость магазина: ");
                                                storage = errors.checkInteger();
                                                if (storage <= 0) {
                                                    System.out.println("Введено неверное значение.");
                                                } else {
                                                    break;
                                                }
                                            }
                                            methods.setAutomat(userShooter,cartridge,storage);
                                            methods.makeShoot(userShooter);
                                            System.out.println(methods.toString(userShooter));
                                            System.out.println();
                                            break;
                                        }
                                        default: {
                                            System.out.println("Введено неверное значение.");
                                            System.out.println();
                                            break;
                                        }
                                    }
                                }
                                System.out.println();
                                break;
                            }
                            case 3: {
                                System.out.println("""
                                        ПРИМЕР:
                                        Допустим, нам дано целое число х = 17
                                        Возведём его в степень y = 3.
                                        Получим результат:
                                        """);
                                System.out.println("Число 17 в степени 3 равно " + Exponentiation.calculation("17","3"));
                                System.out.println("""
                                        
                                        Вам необходимо будет ввести два целых числа:
                                        1. число x
                                        2. число y (степень, в которую мы будем возводить число x)
                                        """);
                                // FIX_ME: выполнение через командую строку.
//                                System.out.print("Введите число х: ");
//                                userX = errors.checkStringInteger();
//                                System.out.print("Введите число y: ");
//                                userY = errors.checkStringInteger();
//                                System.out.println("Число " + userX + " в степени " + userY + " равно " + Exponentiation.calculation(userX,userY));
//                                System.out.println();
                                if (args.length == 2) {
                                    double result = Exponentiation.calculation(args[0], args[1]);
                                    System.out.println("Результат вычисления: " + result);
                                } else {
                                    System.out.println("Для возведения в степень передайте 2 аргумента командной строки.");
                                }
                                break;
                            }
                            default: {
                                System.out.println("Введено неверное значение.");
                                break;
                            }
                        }
                        System.out.println();
                    }
                    break;
                }
                case 8: {
                    System.out.println("""
                            Патроны наследникам.
                            Измените класс Weapon из задачи 2.4.1 таким образом, что бы любой класс наследник мог
                            непосредственно работать сполем хранящим количество патронов заряженном в оружии.
                            Обратите внимание, что метод разрядки Пистолет, усложнившийся при решении задачи
                            2.4.1 снова можно упростить.
                            """);
                    GunIsARealWeapon gun1 = new GunIsARealWeapon();
                    System.out.println(gun1);
                    System.out.println("Пуст ли первый пистолет? " + gun1.isEmpty());
                    System.out.println("Вместимость магазина: " + gun1.getMagazineCapacity());
                    System.out.println("Заряжен ли магазин? " + gun1.isLoaded());
                    System.out.println("Стрельба началась....");
                    gun1.shoot();
                    System.out.println("Статус: ");
                    gun1.printStatus();
                    System.out.println("Разряжаем магазин...");
                    gun1.unload();
                    gun1.printStatus();
                    System.out.println("Стрельба началась....");
                    gun1.shoot();
                    System.out.println("Заряжаем магазин...");
                    gun1.reload(3);
                    gun1.printStatus();
                    System.out.println("Стрельба началась....");
                    for (int i = 0; i < 4; i++) {
                        gun1.shoot();
                    }
                    System.out.println(gun1);
                    System.out.println();

                    GunIsARealWeapon gun2 = new GunIsARealWeapon(4);
                    System.out.println(gun2);
                    System.out.println("Пуст ли второй пистолет? " + gun2.isEmpty());
                    System.out.println("Вместимость магазина: " + gun2.getMagazineCapacity());
                    System.out.println("Заряжен ли магазин? " + gun2.isLoaded());
                    System.out.println("Стрельба началась....");
                    gun2.shoot();
                    System.out.println("Статус: ");
                    gun2.printStatus();
                    System.out.println("Разряжаем магазин...");
                    gun2.unload();
                    gun2.printStatus();
                    System.out.println("Перезаряжаем магазин...");
                    gun2.reload(2);
                    gun2.printStatus();
                    System.out.println("Стрельба началась....");
                    gun2.shoot();
                    System.out.println(gun2);
                    System.out.println();

                    System.out.println("""
                            Сейчас вам необходимо будет создать пистолет самостоятельно.
                            Для этого нужно указать два целых числа:
                            Количество пуль и вместимость магазина.
                            Вместимость магазина не может быть меньше 1.
                            Количество пуль не может быть меньше 0.
                            """);
                    while (true) {
                        System.out.print("Введите целое неотрицательное число - количество пуль: ");
                        cartridge = errors.checkInteger();
                        if (cartridge < 0) {
                            System.out.println("Введено неверное значение.");
                        } else {
                            break;
                        }
                    }
                    while (true) {
                        System.out.print("Введите целое положительное число - вместимость магазина: ");
                        storage = errors.checkInteger();
                        if (storage <= 0) {
                            System.out.println("Введено неверное значение.");
                        } else {
                            break;
                        }
                    }
                    GunIsARealWeapon userGun = new GunIsARealWeapon(cartridge,storage);
                    System.out.println(userGun);
                    System.out.println("Пуст ли ваш пистолет? " + userGun.isEmpty());
                    System.out.println("Вместимость магазина: " + userGun.getMagazineCapacity());
                    System.out.println("Заряжен ли магазин? " + userGun.isLoaded());
                    System.out.println("Началась стрельба....");
                    userGun.shoot();
                    System.out.println("Статус: ");
                    userGun.printStatus();
                    System.out.println("Разряжаем магазин...");
                    userGun.unload();
                    userGun.printStatus();
                    userGun.shoot();
                    System.out.println("Заряжаем магазин....");
                    userGun.reload(5);
                    userGun.printStatus();
                    System.out.println("Началась стрельба....");
                    for (int i = 0; i < 10; i++) {
                        userGun.shoot();
                    }
                    System.out.println();
                    break;
                }
                default: {
                    System.out.println("Введено неверное значение.");
                    break;
                }

            }
        }
        System.out.println("Программа завершена.");
    }
}