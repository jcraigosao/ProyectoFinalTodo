package Juegoclase;

public class Tarzan {
    private int y;
    private int x;
    private int ancho;
    private int largo;
    private int contadorRecompensas;
    private int vidas;

    public Tarzan(int x, int y) {
        this.y = y;
        this.x = x;
        this.ancho=100;
        this.largo=150;
        this.vidas=3;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getContadorRecompensas() {
        return contadorRecompensas;
    }

    public void setContadorRecompensas(int contadorBananas) {
        this.contadorRecompensas = contadorBananas;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    
    
    
}
