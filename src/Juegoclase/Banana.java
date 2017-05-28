/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegoclase;

public class Banana {

private int x; 
private int y;
private int ancho;
private int largo;

    public Banana(int x, int y) {
        this.x = x;
        this.y = y;
        this.ancho= 40;
        this.largo=60;
    }
    
    public boolean CogerBananas(Tarzan t) {
        if (getX()<=t.getX()+t.getAncho()&&getX()+getAncho()>=t.getX()
                && getY()<=t.getLargo()+t.getY()&&getY()+getLargo()>=t.getY()) {            
            return true;
        }
        return false;
    
    }

    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
    