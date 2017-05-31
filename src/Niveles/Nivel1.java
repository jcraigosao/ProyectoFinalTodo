/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Niveles;

import Juegoclase.Banana;
import Juegoclase.Enemigos;
import Juegoclase.Tarzan;
import Menu.PasarAlNivel2;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author i7hpinñi
 */
public class Nivel1 extends JPanel implements ActionListener, MouseListener {

    private int x;
    private int y = 400;
    private int fondo;
    private Timer timer;
    private int secuencia;
    private int secuenciaAtras = 6;
    private int coord;
    private int z = 250;
    private int contador;
    private boolean direccion = true;
    private ArrayList<Integer> aleatorio = new ArrayList<>();
    private Tarzan t = new Tarzan(z + 100, y);
    private Enemigos s = new Enemigos(z + 50, y);
    private ArrayList<Enemigos> snakes = new ArrayList<>();
    private ArrayList<Integer> snak = rectangulosBananas();
    private ArrayList<Banana> bananas = new ArrayList<>();
    private ArrayList<Integer> ban = rectangulosBananas();
    private boolean gameIsFinished = false;
    private int toques=0;
    
        Image gameover= loadImage("YouLose_LI.jpg");

    public Nivel1() {
        this.addMouseListener(this);
        addKeyListener(new TAdapter());
        setFocusable(true);
        timer = new Timer(90, this);
        timer.start();
        rectangulosBananas();
        agregar();
        Boton();
    }
//      
//    public void coordenadasBananas(){
//        for (int i=0; i<70; i++) {
//            if(i<40){
//                coord= (int) (Math.random()*15000+200);
//                bananas.add(new Banana(x+coord*2, 400));
//            }else if(i<70){
//                coord= (int) (Math.random()*15000+200);
//                bananas.add(new Banana(x+coord*2, 250));
//            }
//        }
//    }

    public ArrayList rectangulosBananas() {
        for (int i = 0; i < 70; i++) {
            aleatorio.add((int) (Math.random() * 10000 + 200));
        }
        return aleatorio;
    }

    public void agregar() {
        for (int i = 0; i < 70; i++) {
            if (i < 40) {
                bananas.add(new Banana(x + ban.get(i) * 2, 450));
                snakes.add(new Enemigos(x + snak.get(i)*3, 450));

            } else if (i < 70) {
                bananas.add(new Banana(x + ban.get(i) * 2, 300));
                snakes.add(new Enemigos(x + snak.get(i)*10, 450));
            }
        }
    }
    
    JButton NextNivel;
    public void Boton(){
        NextNivel= new JButton("Segundo Nivel");
            
            setBackground(Color.BLUE);
            setLayout(new BoxLayout(this, x));
            NextNivel.setVisible(false);
            NextNivel.setLocation(0, 0);
            NextNivel.addActionListener(new PasarAlNivel2());
            this.add(NextNivel);
            }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Image fondo = loadImage("forest-background.png");
        Image piso = loadImage("lea.png");
        Image banana = loadImage("Bananita.png");
        Image personaje = loadImage("ANA.png");
        Image salto = loadImage("jump.png");
        Image snake = loadImage("king_cobra.png");
//        Image tronco= loadImage()

        for (int i = 0; i < 300; i++) {
            g.drawImage(fondo, this.fondo + (i * 669), 0, 669, 500, null);
            for (int j = 0; j < 100; j++) {
                g.drawImage(piso, this.fondo + (i * 300), 500, 300, 700, this);
            }

        }

        if (this.gameIsFinished) {
            this.endGame(g);
            return;
        }

        for (int i = 0; i < 70; i++) {
            g.drawImage(banana, bananas.get(i).getX(), bananas.get(i).getY(), 40, 60, this);
//            if (i < snakes.size()) {
                g.drawImage(snake, snakes.get(i).getX(), snakes.get(i).getY() + 40, snakes.get(i).getX() + 60, snakes.get(i).getY() + 100, (this.secuenciaAtras * 99), 100, (this.secuenciaAtras * 96) - 100, 195, this);
//          }
        }
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(810, 10, 120, 50);
        g.setColor(Color.BLACK);
        Font MiFuente= new Font("Courrier New", 1, 20);
        g.setFont(MiFuente);
        g.drawString("Puntaje: " + t.getContadorBananas(), 820, 40);
        
        g.setColor(Color.RED);
        g.fillRect(410, 10, 120, 50);
        g.setColor(Color.BLACK);
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

        for (int i = 0; i < bananas.size(); i++) {
            if (bananas.get(i).CogerBananas(t) == true) {
                t.setContadorBananas(t.getContadorBananas() +1);
                if (i < 40) {
                    bananas.remove(i);
                    bananas.add(new Banana(x + ban.get(i) * 2, 300));
                } if (i >= 40) {
                    bananas.remove(i);
                    bananas.add(new Banana(x + ban.get(i) * 2, 450));
                }
            }
        }
        for (int i = 0; i < snakes.size(); i++) {
               
            if (snakes.get(i).tocarEnemigo(t) == true ) {
                t.setVidas(t.getVidas()-1);
             
            }
            if(t.getVidas()==0){
                this.gameIsFinished = true;
                
            }
        }
        if(t.getContadorBananas()>56){
                timer.stop();
                NextNivel.setVisible(true);
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
        if (bananas.get(69).getX() > z) {
            fondo -= 10;
        }
        for (int i = 0; i < 70; i++) {
            bananas.get(i).setX(bananas.get(i).getX() - 10);
            snakes.get(i).setX(snakes.get(i).getX() - 10);
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

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("Usted ha clickeado");
//        Point mp = e.getPoint();
//        if (getBounds().contains(mp)) {
//            this.timer.stop();
//
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
