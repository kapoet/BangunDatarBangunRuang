package com.ervin.bangundatarbangunruang.data;

public class BangunDatar {

    public double keliling = 0;
    public double luas = 0;

    public BangunDatar() {
    }

    public double getKeliling() {
        return keliling;
    }

    public double getLuas() {
        return luas;
    }

    public void setKeliling(double keliling) {
        this.keliling = keliling;
    }

    public void setLuas(double luas) {
        this.luas = luas;
    }

    public void persegi(BangunDatarOneInputCallback bangunDatarCallback, double sisi){
        keliling = bangunDatarCallback.keliling(sisi);
        luas = bangunDatarCallback.luas(sisi);
    }

    public void persegiPanjang(BangunDatarTwoInputCallback bangunDatarCallback, double panjang, double lebar){
        keliling = bangunDatarCallback.keliling(panjang, lebar);
        luas = bangunDatarCallback.luas(panjang, lebar);
    }

    public void layangLayang(BangunDatarTwoInputCallback bangunDatarTwoInputCallback, double d1, double d2, double a, double b) {
        keliling = bangunDatarTwoInputCallback.keliling(a, b);
        luas = bangunDatarTwoInputCallback.luas(d1, d2);
    }

    public void belahKetupat(BangunDatarTwoInputCallback bangunDatarTwoInputCallback, double sisi, double d1, double d2) {
        keliling = bangunDatarTwoInputCallback.keliling(sisi, 0);
        luas = bangunDatarTwoInputCallback.luas(d1, d2);
    }

    public void segitiga(BangunDatarThreeInputCallback bangunDatarThreeInputCallback, double a, double b, double c, double t) {
        keliling = bangunDatarThreeInputCallback.keliling(a, b, c);
        luas = bangunDatarThreeInputCallback.luas(a, t, 0);
    }

    public void lingkaran(BangunDatarOneInputCallback bangunDatarOneInputCallback, double r) {
        keliling = bangunDatarOneInputCallback.keliling(r);
        luas = bangunDatarOneInputCallback.luas(r);
    }

    public void jajargenjang(BangunDatarThreeInputCallback bangunDatarThreeInputCallback, double a, double b, double t) {
        keliling = bangunDatarThreeInputCallback.keliling(a, b, 0);
        luas = bangunDatarThreeInputCallback.luas(a, 0, t);
    }

    public void trapesium(BangunDatarThreeInputCallback bangunDatarThreeInputCallback, double a, double b, double c, double t) {
        keliling = bangunDatarThreeInputCallback.keliling(a, b, c);
        luas = bangunDatarThreeInputCallback.luas(a, b, t);
    }

    public interface BangunDatarThreeInputCallback {
        double keliling(double a, double b, double c);
        double luas(double a, double b, double c);
    }

    public interface BangunDatarOneInputCallback{
        double keliling(double a);
        double luas(double a);
    }

    public interface BangunDatarTwoInputCallback{
        double keliling(double a, double b);
        double luas(double a, double b);
    }

}
