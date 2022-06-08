package com.example.filmliste;

public class Film {
    private int id;
    private String filmAdi;
    private String yonetmen;
    private String tur;
    private int yil;
    private int uzunluk;
    private double puan;

    public Film() {
    }

    public Film(String filmAdi, String yonetmen, String tur, int yil, int uzunluk, double puan) {
        this.filmAdi = filmAdi;
        this.yonetmen = yonetmen;
        this.tur = tur;
        this.yil = yil;
        this.uzunluk = uzunluk;
        this.puan = puan;
    }

    public Film(int id, String filmAdi, String yonetmen, String tur, int yil, int uzunluk, double puan) {
        this.id = id;
        this.filmAdi = filmAdi;
        this.yonetmen = yonetmen;
        this.tur = tur;
        this.yil = yil;
        this.uzunluk = uzunluk;
        this.puan = puan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmAdi() {
        return filmAdi;
    }

    public void setFilmAdi(String filmAdi) {
        this.filmAdi = filmAdi;
    }

    public String getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(String yonetmen) {
        this.yonetmen = yonetmen;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public int getUzunluk() {
        return uzunluk;
    }

    public void setUzunluk(int uzunluk) {
        this.uzunluk = uzunluk;
    }

    public double getPuan() {
        return puan;
    }

    public void setPuan(double puan) {
        this.puan = puan;
    }
}
