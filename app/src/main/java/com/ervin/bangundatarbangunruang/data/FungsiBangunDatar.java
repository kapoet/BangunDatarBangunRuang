package com.ervin.bangundatarbangunruang.data;

public interface FungsiBangunDatar {

    double luasDatar(String bangun, double a);

    double luasDatar(String bangun, double a, double b);

    double luasDatar(double a, double b, double c);


    double kelilingDatar(String bangun, double a);

    double kelilingDatar(double a, double b);

    double kelilingDatar(String bangun, double a, double b, double c);
}
