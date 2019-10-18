package com.ervin.bangundatarbangunruang.ui.detailbangun;

import androidx.lifecycle.ViewModel;

import com.ervin.bangundatarbangunruang.data.BangunDatar;
import com.ervin.bangundatarbangunruang.data.BangunRuang;
import com.ervin.bangundatarbangunruang.data.FungsiBangunDatar;

public class DetailViewModel extends ViewModel {

    BangunDatar bangunDatar = new BangunDatar();
    BangunRuang bangunRuang = new BangunRuang();

    public BangunDatar persegi(double sisi){
        bangunDatar.persegi(new BangunDatar.BangunDatarOneInputCallback() {
            @Override
            public double keliling(double sisi) {
                return sisi * 4;
            }

            @Override
            public double luas(double sisi) {
                return sisi*sisi;
            }
        }, sisi);
        return bangunDatar;
    }

    public BangunDatar persegiPanjang(double panjang, double lebar) {
        bangunDatar.persegiPanjang(new BangunDatar.BangunDatarTwoInputCallback() {
            @Override
            public double keliling(double a, double b) {
                if(a==0 || b==0){
                    return 0;
                } else{
                    return 2 * (a + b);
                }
            }

            @Override
            public double luas(double a, double b) {
                return a * b;
            }
        },panjang,lebar);
        return bangunDatar;
    }

    public BangunDatar layangLayang(double d1, double d2, double a, double b) {
        bangunDatar.layangLayang(new BangunDatar.BangunDatarTwoInputCallback() {
            @Override
            public double keliling(double a, double b) {
                if (a==0 || b==0){
                    return 0;
                } else{
                    return 2 * (a + b);
                }
            }

            @Override
            public double luas(double a, double b) {
                return (a*b)/2;
            }
        }, d1, d2, a, b);
        return bangunDatar;
    }

    public BangunDatar belahKetupat(double s, double d1, double d2) {
        bangunDatar.belahKetupat(new BangunDatar.BangunDatarTwoInputCallback() {
            @Override
            public double keliling(double a, double b) {
                return 4 * a;
            }

            @Override
            public double luas(double a, double b) {
                return a * b / 2;
            }
        },s,d1,d2);
        return bangunDatar;
    }

    public BangunDatar segitiga(double a, double b, double c, double t) {
        bangunDatar.segitiga(new BangunDatar.BangunDatarThreeInputCallback() {
            @Override
            public double keliling(double a, double b, double c) {
                if (a == 0 || b == 0 || c == 0) {
                    return 0;
                } else {
                    return a + b + c;
                }
            }

            @Override
            public double luas(double a, double b, double c) {
                return a * b / 2;
            }
        },a,b,c,t);
        return bangunDatar;
    }

    public BangunDatar lingkaran(double r) {
        bangunDatar.lingkaran(new BangunDatar.BangunDatarOneInputCallback() {
            @Override
            public double keliling(double a) {
                return 2 * Math.PI * a;
            }

            @Override
            public double luas(double a) {
                return Math.PI* Math.pow(a,2);
            }
        },r);
        return bangunDatar;
    }

    public BangunDatar jajargenjang(double a, double b, double t) {
        bangunDatar.jajargenjang(new BangunDatar.BangunDatarThreeInputCallback() {
            @Override
            public double keliling(double a, double b, double c) {
                if(a==0 || b==0){
                    return 0;
                } else{
                    return 2 * (a + b);
                }
            }

            @Override
            public double luas(double a, double b, double c) {
                return a * c;
            }
        }, a,b,t);
        return bangunDatar;
    }

    public BangunDatar trapesium(double a, double b, double c, double t) {
        bangunDatar.trapesium(new BangunDatar.BangunDatarThreeInputCallback() {
            @Override
            public double keliling(double a, double b, double c) {
                if(a==0 || b==0 || c==0){
                    return 0;
                } else{
                    return 2 * c + a + b;
                }
            }

            @Override
            public double luas(double a, double b, double c) {
                if(a==0 || b==0 || c==0){
                    return 0;
                } else{
                    return ((a+b)/2) * c;
                }
            }
        }, a,b,c,t);
        return bangunDatar;
    }

    public BangunRuang kubus(double s) {
        bangunRuang.kubus(new BangunRuang.BangunRuangOneInputCallback() {
            @Override
            public double volume(double a) {
                return Math.pow(a,3);
            }

            @Override
            public double luas(double a) {
                return 6 * Math.pow(a, 2);
            }
        },s);
        return bangunRuang;
    }

    public BangunRuang balok(double p, double l, double t) {
        bangunRuang.balok(new BangunRuang.BangunRuangThreeInputCallback() {
            @Override
            public double volume(double a, double b, double c) {
                return a * b * c;
            }

            @Override
            public double luas(double a, double b, double c) {
                return 2 * (a * b + a * c + b * c);
            }
        },p,l,t);
        return bangunRuang;
    }

    public BangunRuang kerucut(double s, double r, double t) {
        bangunRuang.kerucut(new BangunRuang.BangunRuangTwoInputCallback() {
            @Override
            public double volume(double a, double b) {
                return Math.PI * Math.pow(a,2) * b / 3 ;
            }

            @Override
            public double luas(double a, double b) {
                return Math.PI * Math.pow(b,2) + Math.PI * b * a;
            }
        },s,r,t);
        return bangunRuang;
    }

    public BangunRuang bola(double r) {
        bangunRuang.bola(new BangunRuang.BangunRuangOneInputCallback() {
            @Override
            public double volume(double a) {
                return 4/3 * Math.PI * Math.pow(a,3);
            }

            @Override
            public double luas(double a) {
                return 4 * Math.PI * Math.pow(a,2);
            }
        },r);
        return bangunRuang;
    }

    public BangunRuang limas(double s, double t) {
        bangunRuang.limas(new BangunRuang.BangunRuangTwoInputCallback() {
            @Override
            public double volume(double a, double b) {
                return Math.pow(a,2) * b / 3;
            }

            @Override
            public double luas(double a, double b) {
                return Math.pow(a,2) + (2 * a * (Math.sqrt(Math.pow((a/2),2) + Math.pow(b,2))));
            }
        },s,t);
        return bangunRuang;
    }

    public BangunRuang prisma(double a, double b, double c, double t) {
        bangunRuang.prisma(new BangunRuang.BangunRuangFourInputCallback() {
            @Override
            public double volume(double a, double b, double c, double d) {
                return a * b * d / 2;
            }

            @Override
            public double luas(double a, double b, double c, double d) {
                return (a * b) + ((a + 2 * c) * d);
            }
        },a,b,c,t);
        return bangunRuang;
    }

    public BangunRuang tabung(double r, double t) {
        bangunRuang.tabung(new BangunRuang.BangunRuangTwoInputCallback() {
            @Override
            public double volume(double a, double b) {
                return Math.PI * Math.pow(a,2) * b;
            }

            @Override
            public double luas(double a, double b) {
                return 2 * Math.PI * a * (a + b);
            }
        },r,t);
        return bangunRuang;
    }
}
