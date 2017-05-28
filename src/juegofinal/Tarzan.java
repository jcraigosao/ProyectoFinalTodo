
package juegofinal;

import java.awt.Rectangle;

public class Tarzan {
    private int y;
    private int x;
    private Bananas[] bananos; 
    private int contador;

    public Tarzan(int y, int x, Bananas[] bananos) {
        this.y = y;
        this.x = x;
        this.bananos = bananos;
    }

    
    public boolean Colision(){
        
        Rectangle tarzan= new Rectangle(x, y, 100, 150);
        Rectangle[] r= new Rectangle[70];
        boolean z= true;
        for (int i = 0; i < 70; i++) { 
        r[i]= new Rectangle(bananos[i].getX(), bananos[i].getY(), 60, 80);
        if(tarzan.intersects(r[i])){
        contador+=1;
            z=true;
        }else{
            z=false;
        }
    }
        return z;
    }

    public Bananas[] getBananos() {
        return bananos;
    }

    public void setBananos(Bananas[] bananos) {
        this.bananos = bananos;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
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

    @Override
    public String toString() {
        return "Puntaje: " + contador;
    }
    
    
}
