package com.java.util;

public class Mulu {
    public String name;
    public String chuohao;
    public String defen;
    public String lanban;
    public String zhugong;

    public Mulu(String name, String chuohao, String defen, String lanban, String zhugong) {
        this.name = name;
        this.chuohao = chuohao;
        this.defen = defen;
        this.lanban = lanban;
        this.zhugong = zhugong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChuohao() {
        return chuohao;
    }

    public void setChuohao(String chuohao) {
        this.chuohao = chuohao;
    }

    public String getDefen() {
        return defen;
    }

    public void setDefen(String defen) {
        this.defen = defen;
    }

    public String getLanban() {
        return lanban;
    }

    public void setLanban(String lanban) {
        this.lanban = lanban;
    }

    public String getZhugong() {
        return zhugong;
    }

    public void setZhugong(String zhugong) {
        this.zhugong = zhugong;
    }

}
