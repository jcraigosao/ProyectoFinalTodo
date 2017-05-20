
package juegofinal;

import java.awt.Rectangle;

public class Bananas {

private int x; 
private int y;
private int contadorBananas;

    public Bananas(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean CogerBananas(Tarzan t){
        Rectangle banana= new Rectangle(x, y, 60, 80);
        Rectangle tarzan= new Rectangle(t.getX(),t.getY(),100,150);
        if(banana.intersects(tarzan)){
            contadorBananas+=1;
            return true;
        }else{
        return false;
    }
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

    public int getContadorBananas() {
        return contadorBananas;
    }

    public void setContadorBananas(int contadorBananas) {
        this.contadorBananas = contadorBananas;
    }

    @Override
    public String toString() {
        return "PUNTAJE=" + contadorBananas ;
    }
    
    
    
    

}