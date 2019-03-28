package com.daka.shangchang;

/**
 * 袁腾飞 2019.3.10
 * 定义GOShooping类，使用WallMarket类和TaobaoMarket类，调用shop()方法
 */
public class Goshopping {
    public static void main(String[] args) {
        Market market = new WallMarket();
        market.name ="沃尔玛";
        market.goods = "七匹狼西服";
        market.shop();
        market = new TaobaoMarket();
        market.name = "淘宝";
        market.goods = "韩都衣舍花裙";
        market.shop();
    }
}
