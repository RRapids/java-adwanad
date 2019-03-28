package xunlian2;

/**
 * 袁腾飞 2019.3.10
 * 定义ELF类，完全继承Dosong接口和Domove接口
 */
public class ELF implements Dosong,Domove {
    @Override
    public void move() {
        System.out.println("可移动");
    }

    @Override
    public void song() {
        System.out.println("可唱歌");
    }

    public static void main(String[] args) {
        ELF elf = new ELF();
        System.out.println("精灵");
        elf.move();
        elf.song();
    }
}
