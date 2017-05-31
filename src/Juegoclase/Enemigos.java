package Juegoclase;

public class Enemigos extends Objetos{


    private int ancho;
    private int largo;
    private boolean colision=false;

    public Enemigos(int x, int y) {
        super(x, y);
        this.ancho = 40;
        this.largo = 60;
        colision=false;
    }
   
    public boolean tocarEnemigo(Tarzan t) {
        if (getX()<=t.getX()+t.getAncho()&&getX()+getAncho()>=t.getX()
                && getY()<=t.getLargo()+t.getY()&&getY()+getLargo()>=t.getY() 
                && colision==false) {
            
            colision=true;   
            return true;
        }
        return false;
    
    }
    
    


    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
    }
    
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public boolean isColision() {
        return colision;
    }

    public void setColision(boolean colision) {
        this.colision = colision;
    }
    
    
}
