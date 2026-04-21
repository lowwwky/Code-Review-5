package ru.kuzhleva.dots;

/**
 * Класс, представляющий точку на плоскости с координатами x и y.
 * Объект данного класса хранит две координаты типа {@code double}
 * и предоставляет методы для их получения.
 * Также переопределены методы {@link #equals(Object)},
 * {@link #hashCode()} и {@link #toString()}.
 *
 * @see Double
 */
public class Dots {
    private double x;
    private double y;

    /**
     * Создает точку с заданными координатами.
     *
     * @param x координата точки по оси X
     * @param y координата точки по оси Y
     */
    public Dots(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату точки по оси X.
     *
     * @return координата x
     */
    public double getX() {
        return x;
    }

    /**
     * Возвращает координату точки по оси Y.
     *
     * @return координата y
     */
    public double getY() {
        return y;
    }

    /**
     * Сравнивает текущий объект с другим объектом на равенство.
     * Две точки считаются равными, если их координаты {@code x} и {@code y}
     * совпадают.
     *
     * @param obj объект, с которым сравнивается текущий объект
     * @return {@code true}, если объекты равны, иначе {@code false}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Dots other = (Dots) obj;
        return Double.compare(x, other.x) == 0 && Double.compare(y, other.y) == 0;

    }

    /**
     * Возвращает хэш-код объекта на основе координат точки.
     *
     * @return хэш-код объекта
     */
    @Override
    public int hashCode() {
        int result = 31;
        long tempX = Double.doubleToLongBits(x);
        result = 31*result + (int)(tempX ^ (tempX >>> 32));

        long tempY = Double.doubleToLongBits(y);
        result = 31*result + (int)(tempY ^ (tempY >>> 32));

        return result;
    }

    /**
     * Возвращает строковое представление точки.
     * Формат строки:
     * {@code Точка: {x;y}}
     *
     * @return строковое представление точки
     */
    @Override
    public String toString() {
        return "Точка: " + "{" + x + ";" + y + "}";
    }
}
