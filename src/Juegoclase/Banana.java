package Juegoclase;

public class Banana extends Objetos{


private int ancho;
private int largo;

    public Banana(int x, int y) {
        super(x, y);
        this.ancho = 40;
        this.largo = 60;
    }

    
    
    public boolean CogerBananas(Tarzan t) {
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
    