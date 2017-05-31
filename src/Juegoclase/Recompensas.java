/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegoclase;

public class Recompensas extends Objetos{


private int ancho;
private int largo;

    public Recompensas(int x, int y) {
        super(x, y);
        this.ancho = 40;
        this.largo = 60;
    }

    
    
    public boolean CogerRecompensas(Tarzan t) {
        if (getX()<=t.getX()+t.getAncho()&&getX()+getAncho()>=t.getX()
                && getY()<=t.getLargo()+t.getY()&&getY()+getLargo()>=t.getY()) {            
            return true;
        }
        return false;
    
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
    