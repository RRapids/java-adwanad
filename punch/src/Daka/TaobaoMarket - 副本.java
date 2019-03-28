package com.daka.shangchang;

import com.daka.shangchang.Market;

public class TaobaoMarket extends Market {
    @Override
    public void shop() {
        System.out.println(name + "网购" + goods);
    }
}
