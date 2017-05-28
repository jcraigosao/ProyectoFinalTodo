/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegoclase;

/**
 *
 * @author TOSHIBA
 */
public class Tarzan {
    private int y;
    private int x;
    private int ancho;
    private int largo;
    private int contadorBananas;

    public Tarzan(int x, int y) {
        this.y = y;
        this.x = x;
        this.ancho=100;
        this.largo=150;
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

    public int getContadorBananas() {
        return contadorBananas;
    }

    public void setContadorBananas(int contadorBananas) {
        this.contadorBananas = contadorBananas;
    }
    
    
    
}
