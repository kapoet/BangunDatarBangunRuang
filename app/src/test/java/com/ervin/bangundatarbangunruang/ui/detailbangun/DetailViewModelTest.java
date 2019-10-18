package com.ervin.bangundatarbangunruang.ui.detailbangun;

import com.ervin.bangundatarbangunruang.data.BangunDatar;
import com.ervin.bangundatarbangunruang.data.BangunRuang;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailViewModelTest {

    public DetailViewModel detailViewModel = new DetailViewModel();

    @Test
    public void persegi() {
        BangunDatar bangunDatar = detailViewModel.persegi(5);
        assertEquals(25,bangunDatar.luas,0.0);
        assertEquals(20,bangunDatar.keliling,0.0);
    }

    @Test
    public void persegiPanjang() {
        BangunDatar bangunDatar = detailViewModel.persegiPanjang(5,6);
        assertEquals(30,bangunDatar.luas,0.0);
        assertEquals(22,bangunDatar.keliling,0.0);
    }

    @Test
    public void layangLayang() {
        BangunDatar bangunDatar = detailViewModel.layangLayang(5,6,2,3);
        assertEquals(15,bangunDatar.luas,0.0);
        assertEquals(10,bangunDatar.keliling,0.0);
    }

    @Test
    public void belahKetupat() {
        BangunDatar bangunDatar = detailViewModel.belahKetupat(5,6,7);
        assertEquals(21,bangunDatar.luas,0.0);
        assertEquals(20,bangunDatar.keliling,0.0);
    }

    @Test
    public void segitiga() {
        BangunDatar bangunDatar = detailViewModel.segitiga(10,12,12,11);
        assertEquals(55,bangunDatar.luas,0.0);
        assertEquals(34,bangunDatar.keliling,0.0);
    }

    @Test
    public void lingkaran() {
        BangunDatar bangunDatar = detailViewModel.lingkaran(4);
        assertEquals(50.26,bangunDatar.luas,0.01);
        assertEquals(25.13,bangunDatar.keliling,0.01);
    }

    @Test
    public void jajargenjang() {
        BangunDatar bangunDatar = detailViewModel.jajargenjang(6,10,5);
        assertEquals(30,bangunDatar.luas,0.01);
        assertEquals(32,bangunDatar.keliling,0.01);
    }

    @Test
    public void trapesium() {
        BangunDatar bangunDatar = detailViewModel.trapesium(10,5,8,9);
        assertEquals(67.5,bangunDatar.luas,0.01);
        assertEquals(31,bangunDatar.keliling,0.01);
    }

    @Test
    public void kubus() {
        BangunRuang bangunRuang = detailViewModel.kubus(4);
        assertEquals(96,bangunRuang.luas,0.01);
        assertEquals(64,bangunRuang.volume,0.01);
    }

    @Test
    public void balok() {
        BangunRuang bangunRuang = detailViewModel.balok(10,5,4);
        assertEquals(220,bangunRuang.luas,0.01);
        assertEquals(200,bangunRuang.volume,0.01);
    }

    @Test
    public void kerucut() {
        BangunRuang bangunRuang = detailViewModel.kerucut(10,5,8);
        assertEquals(235.61,bangunRuang.luas,0.01);
        assertEquals(209.44,bangunRuang.volume,0.01);
    }

    @Test
    public void bola() {
        BangunRuang bangunRuang = detailViewModel.bola(4);
        assertEquals(201.06,bangunRuang.luas,0.01);
        assertEquals(268.08,bangunRuang.volume,0.01);
    }

    @Test
    public void limas() {
        BangunRuang bangunRuang = detailViewModel.limas(4,6);
        assertEquals(66.59,bangunRuang.luas,0.01);
        assertEquals(32,bangunRuang.volume,0.01);
    }

    @Test
    public void prisma() {
        BangunRuang bangunRuang = detailViewModel.prisma(10,6,12,20);
        assertEquals(740,bangunRuang.luas,0.01);
        assertEquals(600,bangunRuang.volume,0.01);
    }

    @Test
    public void tabung() {
        BangunRuang bangunRuang = detailViewModel.tabung(5,10);
        assertEquals(471.24,bangunRuang.luas,0.01);
        assertEquals(785.40,bangunRuang.volume,0.01);
    }
}