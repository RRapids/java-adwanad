package xunlian1;

/**
 * 袁腾飞 2019.3.10
 * 定义Shape抽象方法
 */
public abstract class Shape {
    //半径
    public double radius;
    //矩形高宽
    public double high;
    public double width;

    //抽象方法，输出信息
    public abstract void area();
}
