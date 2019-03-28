package com.daka.shangchang;

import com.daka.shangchang.Market;

public class WallMarket extends Market {
    @Override
    public void shop() {
        System.out.println(name + "实体店购买" + goods);
    }
}
