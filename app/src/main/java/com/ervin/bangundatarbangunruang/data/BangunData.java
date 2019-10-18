package com.ervin.bangundatarbangunruang.data;

import java.util.ArrayList;

public class BangunData {

    public static ArrayList<Bangun> generateBangunDatar() {
        ArrayList<Bangun> bangunDatar = new ArrayList<>();
        bangunDatar.add(new Bangun("Persegi","persegi"));
        bangunDatar.add(new Bangun("Persegi Panjang","persegipanjang"));
        bangunDatar.add(new Bangun("Layang - Layang","layanglayang"));
        bangunDatar.add(new Bangun("Belah Ketupat","belahketupat"));
        bangunDatar.add(new Bangun("Segitiga","segitiga"));
        bangunDatar.add(new Bangun("Lingkaran","lingkaran"));
        bangunDatar.add(new Bangun("Jajar Genjang","jajargenjang"));
        bangunDatar.add(new Bangun("Trapesium","trapesium"));
        return bangunDatar;
    }

    public static ArrayList<Bangun> genereateBangunRuang() {
        ArrayList<Bangun> bangunRuang = new ArrayList<>();
        bangunRuang.add(new Bangun("Kubus","kubus"));
        bangunRuang.add(new Bangun("Balok","balok"));
        bangunRuang.add(new Bangun("Kerucut","kerucut"));
        bangunRuang.add(new Bangun("Bola","bola"));
        bangunRuang.add(new Bangun("Limas","limas"));
        bangunRuang.add(new Bangun("Prisma","prisma"));
        bangunRuang.add(new Bangun("Tabung","tabung"));
        return bangunRuang;
    }
}
