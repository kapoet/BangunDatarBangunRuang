package com.ervin.bangundatarbangunruang.data;

public class BangunRuang {

    public double luas = 0;
    public double volume = 0;

    public BangunRuang() {
    }

    public double getLuas() {
        return luas;
    }

    public void setLuas(double luas) {
        this.luas = luas;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void kubus(BangunRuangOneInputCallback bangunRuangCallback, double sisi){
        volume = bangunRuangCallback.volume(sisi);
        luas = bangunRuangCallback.luas(sisi);
    }

    public void kerucut(BangunRuangTwoInputCallback bangunRuangCallback, double s, double r, double t){
        volume = bangunRuangCallback.volume(r, t);
        luas = bangunRuangCallback.luas(s, r);
    }

    public void limas(BangunRuangTwoInputCallback bangunRuangTwoInputCallback, double s, double t) {
        volume = bangunRuangTwoInputCallback.volume(s, t);
        luas = bangunRuangTwoInputCallback.luas(s, t);
    }

    public void balok(BangunRuangThreeInputCallback bangunRuangThreeInputCallback, double p, double l, double t) {
        volume = bangunRuangThreeInputCallback.volume(p, l, t);
        luas = bangunRuangThreeInputCallback.luas(p, l, t);
    }

    public void bola(BangunRuangOneInputCallback bangunRuangOneInputCallback, double r) {
        volume = bangunRuangOneInputCallback.volume(r);
        luas = bangunRuangOneInputCallback.luas(r);
    }

    public void prisma(BangunRuangFourInputCallback bangunRuangFourInputCallback, double a, double b, double c, double t) {
        volume = bangunRuangFourInputCallback.volume(a, b, 0, t);
        luas = bangunRuangFourInputCallback.luas(a, b, c, t);
    }

    public void tabung(BangunRuangTwoInputCallback bangunRuangTwoInputCallback, double r, double t) {
        volume = bangunRuangTwoInputCallback.volume(r,t);
        luas = bangunRuangTwoInputCallback.luas(r, t);
    }

    public interface BangunRuangThreeInputCallback {
        double volume(double a, double b, double c);
        double luas(double a, double b, double c);
    }

    public interface BangunRuangFourInputCallback {
        double volume(double a, double b, double c, double d);
        double luas(double a, double b, double c, double d);
    }

    public interface BangunRuangOneInputCallback{
        double volume(double a);
        double luas(double a);
    }

    public interface BangunRuangTwoInputCallback{
        double volume(double a, double b);
        double luas(double a, double b);
    }

}
