package xunlian1;

/**
 * 袁腾飞 2019.3.10
 */
public class Calculation {
    public static void main(String[] args) {
        Shape shape = new Round();
        shape.radius = 4;
        shape.area();
        shape = new rectangle();
        shape.high = 5;
        shape.width = 6;
        shape.area();
    }
}
