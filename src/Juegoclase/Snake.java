package Juegoclase;

public class Snake {

    private int x;
    private int y;
    private int ancho;
    private int largo;
    
    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        this.ancho= 40;
        this.largo=60;
    }
    
    public boolean tocarEnemigo(Tarzan t) {
        if (getX()<=t.getX()+t.getAncho()&&getX()+getAncho()>=t.getX()
                && getY()<=t.getLargo()+t.getY()&&getY()+getLargo()>=t.getY()) {            
            return true;
        }
        return false;
    
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }
    
    
}
