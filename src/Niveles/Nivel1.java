package Niveles;


import Juegoclase.Recompensas;
import Juegoclase.Enemigos;
import Juegoclase.Tarzan;
import Menu.Inicio;
import Menu.PasarAlNivel2;
import dao.Archivo;
import dao.Estadistica;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import Niveles.TestPaintComponent1;
import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author i7hpinñi
 */
public class Nivel1 extends JPanel implements ActionListener, NivelBase{

    private int x;
    private int y = 400;
    private int fondo;
    private Timer timer;
    private int secuencia;
    private int secuenciaAtras = 6;
    private int z = 250;
    private boolean direccion = true;
    private ArrayList<Integer> aleatorio = new ArrayList<>();
    public Tarzan t = new Tarzan(z + 100, y);
    private ArrayList<Enemigos> snakes = new ArrayList<>();
    private ArrayList<Integer> snak = rectangulosRecompensas();
    private ArrayList<Recompensas> bananas = new ArrayList<>();
    private ArrayList<Integer> ban = rectangulosRecompensas();
    private boolean gameIsFinished = false;
    private boolean puntajeSalvado=false;
    protected URL sonido = null;
    protected AudioClip son;
    protected URL golpe=null;
    protected AudioClip oh;
    Image gameover= loadImage("YouLose_LI.jpg");
    JButton NextNivel;
    private Image fondoo ;
    private Image piso ;
    private Image banana;
    private Image personaje;
    private Image salto;
    private Image snake;

    public Nivel1() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        timer = new Timer(90, this);
        timer.start();
        rectangulosRecompensas();
        agregar();
        Boton();
        try {
            sonido = new URL("file:tarzan1.wav");
            son = Applet.newAudioClip(sonido);

        } catch (MalformedURLException ex) {
            Logger.getLogger(Nivel1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            golpe = new URL("file:ohTarzan.wav");
            oh = Applet.newAudioClip(golpe);

        } catch (MalformedURLException ex) {
            Logger.getLogger(Nivel1.class.getName()).log(Level.SEVERE, null, ex);
        }
        son.loop();
        fondoo = loadImage("forest-background.png");
        piso = loadImage("lea.png");
        banana = loadImage("Bananita.png");
        personaje = loadImage("ANA.png");
        salto = loadImage("jump.png");
        snake = loadImage("king_cobra.png");
    }
    
    public ArrayList rectangulosRecompensas() {
        for (int i = 0; i < 70; i++) {
            aleatorio.add((int) (Math.random() * 8000 + 200));
        }
        return aleatorio;
    }
    

    public void agregar() {
        for (int i = 0; i < 70; i++) {
            if (i < 40) {
                bananas.add(new Recompensas(x + ban.get(i) * 2, 450));
                snakes.add(new Enemigos(x + snak.get(i)*3, 450));

            } else if (i < 70) {
                bananas.add(new Recompensas(x + ban.get(i) * 2, 300));
                snakes.add(new Enemigos(x + snak.get(i)*10, 450));
            }
        }
    }
    
    public void Boton(){
        NextNivel= new JButton("Segundo Nivel");
            
            setBackground(Color.BLUE);
            setLayout(new BoxLayout(this, x));
            NextNivel.setVisible(false);
            NextNivel.setLocation(0, 0);
            this.add(NextNivel);
            
            }
    
    

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (int i = 0; i < 300; i++) {
            g.drawImage(fondoo, this.fondo + (i * 669), 0, 669, 500, null);
            for (int j = 0; j < 100; j++) {
                g.drawImage(piso, this.fondo + (i * 300), 500, 300, 700, this);
            }

        }

        if (this.gameIsFinished) {
            this.endGame(g);
            son.stop();
            return;
        }

        for (int i = 0; i < 70; i++) {
            g.drawImage(banana, bananas.get(i).getX(), bananas.get(i).getY(), 40, 60, this);
            g.drawImage(snake, snakes.get(i).getX(), snakes.get(i).getY() + 40, snakes.get(i).getX() + 60, snakes.get(i).getY() + 100, (this.secuenciaAtras * 99), 100, (this.secuenciaAtras * 96) - 100, 195, this);
        }
        g.setColor(Color.BLACK);
        g.fillRect(810, 10, 120, 50);
        g.setColor(Color.green);
        Font MiFuente= new Font("Courrier New", 1, 20);
        g.setFont(MiFuente);
        g.drawString("Puntaje: " + t.getContadorRecompensas(), 820, 40);
        
        g.setColor(Color.BLACK);
        g.fillRect(410, 10, 120, 50);
        g.setColor(Color.green);
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
            if (bananas.get(i).CogerRecompensas(t) == true) {
                t.setContadorRecompensas(t.getContadorRecompensas() +1);
                if (i < 40) {
                    bananas.remove(i);
                    bananas.add(new Recompensas(x + ban.get(i) * 2, 300));
                } if (i >= 40) {
                    bananas.remove(i);
                    bananas.add(new Recompensas(x + ban.get(i) * 2, 450));
                }
            }
        }
        for (int i = 0; i < snakes.size(); i++) {
               
            if (snakes.get(i).tocarEnemigo(t) == true ) {
                t.setVidas(t.getVidas()-1);
                oh.play();
            }
            if(t.getVidas()==0){
                this.gameIsFinished = true;
                if (this.puntajeSalvado != true) {
                    Archivo archivo = new Archivo();
                    String nombreJugador = JOptionPane.showInputDialog("Ingrese nombre del jugador");
                    Estadistica estadistica = new Estadistica();
                    estadistica.setJugador(nombreJugador);
                    estadistica.setPuntje(t.getContadorRecompensas());
                    try {
                        archivo.escribir(estadistica);
                        this.puntajeSalvado = true;
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Nivel1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        if(t.getContadorRecompensas()>=49){
                timer.stop();
                son.stop();
                NextNivel.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    pasarNivel(evt);
                    Inicio.hideFrame();
                }
            });
            NextNivel.setVisible(true);
        }
    }

       public void pasarNivel(ActionEvent me) {
        new PasarAlNivel2(t.getContadorRecompensas()).actionPerformed(me);
        this.setVisible(false);
        
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
        son.stop();
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


}
