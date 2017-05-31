package Niveles;

import Juegoclase.Recompensas;
import Juegoclase.Enemigos;
import Juegoclase.Tarzan;
import Menu.VolverAlComienzo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author i7hpinñi
 */
public class Nivel3 extends JPanel implements ActionListener{

    private int x;
    private int y = 400;
    private int fondo;
    private Timer timer;
    private int secuencia;
    private int secuenciaAtras = 6;
    private int secuencia2;
    private int secuencia3;
    private int z = 250;
    private boolean direccion = true;
    private ArrayList<Integer> aleatorio = new ArrayList<>();
    private Tarzan t = new Tarzan(z + 100, y);
    private ArrayList<Enemigos> arañas = new ArrayList<>();
    private ArrayList<Integer> ara = rectangulosBananas();
    private ArrayList<Recompensas> Monedas = new ArrayList<>();
    private ArrayList<Integer> coin = rectangulosBananas();
    private boolean gameIsFinished = false;
    Image gameover= loadImage("YouLose_LI.jpg");
    Image winner= loadImage("Ganador.jpg");
    JButton Reiniciar;
    
    
    public Nivel3() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        timer = new Timer(90, this);
        timer.start();
        rectangulosBananas();
        agregar();
    }

    public ArrayList rectangulosBananas() {
        for (int i = 0; i < 70; i++) {
            aleatorio.add((int) (Math.random() * 8000 + 200));
        }
        return aleatorio;
    }

    public void agregar() {
        for (int i = 0; i < 70; i++) {
            if (i < 40) {
                Monedas.add(new Recompensas(x + coin.get(i) * 2, 450));
                arañas.add(new Enemigos(x + ara.get(i)*3, 450));

            } else if (i < 70) {
                Monedas.add(new Recompensas(x + coin.get(i) * 2, 300));
                arañas.add(new Enemigos(x + ara.get(i)*5, 450));
            }
        }
    }
    
     public void Boton(){
        Reiniciar= new JButton("Volver a jugar");
            
            setBackground(Color.BLUE);
            setLayout(new BoxLayout(this, x));
            Reiniciar.setVisible(false);
            Reiniciar.setLocation(0, 0);
            Reiniciar.addActionListener(new VolverAlComienzo());
            this.add(Reiniciar);
            }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Image fondo = loadImage("amanecer.png");
        Image piso = loadImage("pisocafe.png");
        Image moneda = loadImage("Full Coins.png");
        Image personaje = loadImage("ANA.png");
        Image salto = loadImage("jump.png");
        Image araña = loadImage("spider.png");
        Image winner= loadImage("Ganador.jpg");

        for (int i = 0; i < 300; i++) {
            g.drawImage(fondo, this.fondo + (i * 4096), 0, 4096, 512, null);
            for (int j = 0; j < 100; j++) {
                g.drawImage(piso, this.fondo + (i * 300), 500, 300, 700, this);
            }

        }

        if (this.gameIsFinished) {
            this.endGame(g);
            return;
        }

        for (int i = 0; i < 70; i++) {
            g.drawImage(moneda, Monedas.get(i).getX(), Monedas.get(i).getY(),Monedas.get(i).getX()+40,
                        Monedas.get(i).getY()+60,(this.secuencia3 * 16), 0, (this.secuencia3 * 16) + 16, 
                        16, this);
            g.drawImage(araña, arañas.get(i).getX(), arañas.get(i).getY(), arañas.get(i).getX() 
                        + 40, arañas.get(i).getY() + 60, (this.secuencia2 * 32), 0, (this.secuencia2 * 32) + 32, 
                        32,this);
            
//            g.drawImage(helicoptero, helicopteros.get(i).getX(), helicopteros.get(i).getY(), helicopteros.get(i).getX() 
//                        + 50, helicopteros.get(i).getY() + 80, (this.secuencia2 * 125), 0, (this.secuencia2 * 125) + 125, 
//                        128, this);
        }
        g.setColor(Color.BLACK);
        g.fillRect(810, 10, 120, 50);
        g.setColor(Color.ORANGE);
        Font MiFuente= new Font("Courrier New", 1, 20);
        g.setFont(MiFuente);
        g.drawString("Puntaje: " + t.getContadorRecompensas(), 820, 40);
        
        g.setColor(Color.BLACK);
        g.fillRect(410, 10, 120, 50);
        g.setColor(Color.ORANGE);
        g.drawString("Vidas: " + t.getVidas(), 420, 40);

        if (t.getY() == 400 && direccion == true) {
            g.drawImage(personaje, t.getX(), t.getY(), t.getX() + 120, t.getY() + 170, (this.secuencia * 270), 0, (this.secuencia * 270) + 270, 520, this);
        }  
        if (t.getY() < 400 && direccion==true) {
            g.drawImage(salto, t.getX(), t.getY(), t.getX() + 140, t.getY() + 190, (this.secuencia * 360), 0, (this.secuencia * 360) + 360, 860, this);
        }
        if (t.getY()==400 && direccion == false) {
            g.drawImage(personaje, t.getX(), t.getY(), t.getX() + 120, t.getY() + 170, (this.secuenciaAtras * 270), 0, (this.secuenciaAtras * 270) - 270, 520, this);
        }
        if (t.getY() < 400 && direccion==false) {
            g.drawImage(salto, t.getX(), t.getY(), t.getX() + 140, t.getY() + 190, (this.secuenciaAtras * 360), 0, (this.secuenciaAtras * 360) - 360, 860, this);
        }

        for (int i = 0; i < Monedas.size(); i++) {
            if (Monedas.get(i).CogerRecompensas(t) == true) {
                t.setContadorRecompensas(t.getContadorRecompensas() +1);
                if (i < 40) {
                    Monedas.remove(i);
                    Monedas.add(new Recompensas(x + coin.get(i) * 2, 300));
                } if (i >= 40) {
                    Monedas.remove(i);
                    Monedas.add(new Recompensas(x + coin.get(i) * 2, 450));
                }
            }
        }
        for (int i = 0; i < arañas.size(); i++) {
               
            if (arañas.get(i).tocarEnemigo(t) == true ) {
                t.setVidas(t.getVidas()-1);
             
            }
            if(t.getVidas()==0){
                this.gameIsFinished = true;
                
            }
        }
        if(t.getContadorRecompensas()==63){
                timer.stop();
                g.drawImage(winner, 0, 0,1000,600, this);
                Font Otro= new Font("Courrier New", 1, 50);
                g.setFont(Otro);
                g.setColor(Color.BLACK);
                g.drawString("Haz Ganado!!", 100, 100);
                g.drawString("Puntaje total: "+ 168, 400, 500);
                //Reiniciar.setVisible(true);
                System.out.println("Usted ha ganado!!");
               
            }

            
    }
    
    

    public void endGame(Graphics g) {
        Image personajeCaido = loadImage("TarzanPoisoned.png");
        Image personajeDormido = loadImage("fallenTarzan.png");
        if (this.secuencia < 5) {
            g.drawImage(personajeCaido, t.getX(), t.getY(), t.getX() + 50, t.getY() + 170, (this.secuencia * 270), 0, (this.secuencia * 270) + 100, 520, this);
        } else {
            g.drawImage(personajeDormido, t.getX(), t.getY(), 170, 160, this);
            
            this.timer.stop();
            g.drawImage(gameover, 200, 0, this);
        }

    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Monedas.get(69).getX() > z) {
            fondo -= 10;
        }
        for (int i = 0; i < 70; i++) {
            Monedas.get(i).setX(Monedas.get(i).getX() - 10);
            arañas.get(i).setX(arañas.get(i).getX() - 10);
        }
        t.setX(t.getX() - 5);

        if (this.secuenciaAtras == 1) {
            this.secuenciaAtras = 6;
        } else {
            this.secuenciaAtras--;
        }

        if (this.secuencia == 5) {
            this.secuencia = 0;
        } else {
            this.secuencia++;
        }
        
        if(this.secuencia2==5){
            this.secuencia2=0;
        }else{
            this.secuencia2++;
        }
        
        
        if(this.secuencia3==7){
            this.secuencia3=0;
        }else{
            this.secuencia3++;
        }
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_UP) {
                if(direccion ==true){
                for (int i = 0; t.getY() < 280; i++) {
                    t.setY(t.getY() + 1);
                    t.setX(t.getX() + 2);
                }
                for (int i = 0; t.getY() < 320; i++) {
                    t.setY(t.getY() + 1);
                    t.setX(t.getX() + 1);
                }
                for (int i = 0; t.getY() < 400; i++) {
                    t.setY(t.getY() + 2);
                    t.setX(t.getX() + 1);
                }}
                if(direccion ==false){
                for (int i = 0; t.getY() < 280; i++) {
                    t.setY(t.getY() + 1);
                    t.setX(t.getX() - 2);
                }
                for (int i = 0; t.getY() < 320; i++) {
                    t.setY(t.getY() + 1);
                    t.setX(t.getX() - 1);
                }
                for (int i = 0; t.getY() < 400; i++) {
                    t.setY(t.getY() + 2);
                    t.setX(t.getX() - 1);
                }}
            }
        }

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            
            if (key == KeyEvent.VK_LEFT) {
                direccion = false;
                t.setX(t.getX() - 5);
            }
            if (key == KeyEvent.VK_RIGHT) {
                direccion = true;
                t.setX(t.getX() + 5);
            }
            if (key == KeyEvent.VK_UP) {
                if(direccion==true){
                for (int i = 0; t.getY() > 320; i++) {
                    t.setY(t.getY() - 2);
                    t.setX(t.getX() + 1);
                }
                for (int i = 0; t.getY() > 280; i++) {
                    t.setY(t.getY() - 1);
                    t.setX(t.getX() + 1);
                }
                for (int i = 0; t.getY() > 250; i++) {
                    t.setY(t.getY() - 1);
                    t.setX(t.getX() + 2);
                }}
                if(direccion==false){
                for (int i = 0; t.getY() > 320; i++) {
                    t.setY(t.getY() - 2);
                    t.setX(t.getX() - 1);
                }
                for (int i = 0; t.getY() > 280; i++) {
                    t.setY(t.getY() - 1);
                    t.setX(t.getX() - 1);
                }
                for (int i = 0; t.getY() > 250; i++) {
                    t.setY(t.getY() - 1);
                    t.setX(t.getX() - 2);
                }}

            }

        }
    }
}
