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
public class Tree extends Objetos{
    private int ancho;
    private int largo;

    public Tree(int x, int y) {
        super(x, y);
        this.ancho = 30;
        this.largo = 50;
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
    
}
