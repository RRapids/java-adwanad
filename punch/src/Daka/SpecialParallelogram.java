package shili2;

/**
 * 袁腾飞 2019.3.10
 * 定义特殊平行四边形类，调用draw()方法
 */
public class SpecialParallelogram {
    public static void main(String[] args) {
        DrawImage[] images = {new Rectangle(), new Square(), new Diamond()};
        for (int i = 0; i < images.length; i++) {
            images[i].draw();
        }
    }
}
