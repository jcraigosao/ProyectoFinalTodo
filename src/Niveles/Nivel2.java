package Niveles;

import Juegoclase.Recompensas;
import Juegoclase.Enemigos;
import Juegoclase.Tarzan;
import Menu.PasarAlNivel3;
import dao.Archivo;
import dao.Estadistica;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author i7hpinñi
 */
public class Nivel2 extends JPanel implements ActionListener, NivelBase {

    private int x;
    private int y = 400;
    private int fondo;
    private Timer timer;
    private int secuencia;
    private int secuenciaAtras = 6;
    private int secuencia2;
    private int z = 250;
    private boolean direccion = true;
    private ArrayList<Integer> aleatorio = new ArrayList<>();
    public Tarzan t = new Tarzan(z + 100, y);
    private Enemigos s = new Enemigos(z + 50, y);
    private ArrayList<Enemigos> insectos = new ArrayList<>();
    private ArrayList<Integer> insect = rectangulosRecompensas();
    private ArrayList<Recompensas> Cerezas = new ArrayList<>();
    private ArrayList<Integer> cer = rectangulosRecompensas();
    private int contador;
    private boolean gameIsFinished = false;
    protected URL sonido = null;
    protected AudioClip son;
    protected URL golpe = null;
    protected AudioClip oh;
    private Image fondoo;
    private Image piso;
    private Image banana;
    private Image personaje;
    private Image salto;
    private Image insecto;
    private Image gameover;
    JButton NextNivel;
    private boolean puntajeSalvado;
    
    private static Nivel2 theOnlyInstance = null;
    
//    public static Nivel2 getInstance( int puntaje ) {
//        if ( theOnlyInstance == null )
//            theOnlyInstance = new Nivel2( puntaje );
//        return theOnlyInstance;
//    }

    public Nivel2(int puntaje) {
        addKeyListener(new TAdapter());
        setFocusable(true);
        timer = new Timer(90, this);
        timer.start();
        rectangulosRecompensas();
        agregar();
        Boton();

        this.contador = puntaje;
        t.setContadorRecompensas(this.contador);
        
        try {
            sonido = new URL("file:tarzan2.wav");
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
        fondoo = loadImage("fondo2.jpeg");
        piso = loadImage("pisocafe.png");
        banana = loadImage("cherry.png");
        personaje = loadImage("ANA.png");
        salto = loadImage("jump.png");
        insecto = loadImage("insecto.png");
        gameover = loadImage("YouLose_LI.jpg");
        son.loop();
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
                Cerezas.add(new Recompensas(x + cer.get(i) * 2, 450));
                insectos.add(new Enemigos(x + insect.get(i) * 3, 450));

            } else if (i < 70) {
                Cerezas.add(new Recompensas(x + cer.get(i) * 2, 300));
                insectos.add(new Enemigos(x + insect.get(i) * 3, 280));
            }
        }
    }

    public void Boton() {

        NextNivel = new JButton("Tercer Nivel");

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
            g.drawImage(fondoo, this.fondo + (i * 669), 0, 669, 600, null);
            for (int j = 0; j < 100; j++) {
                g.drawImage(piso, this.fondo + (i * 300), 500, 300, 700, this);
            }

        }

        if (this.gameIsFinished) {
            this.endGame(g);
            return;
        }

        for (int i = 0; i < 70; i++) {
            g.drawImage(banana, Cerezas.get(i).getX(), Cerezas.get(i).getY(), 40, 60, this);
            g.drawImage(insecto, insectos.get(i).getX(), insectos.get(i).getY(), insectos.get(i).getX()
                    + 50, insectos.get(i).getY() + 80, (this.secuencia2 * 125), 0, (this.secuencia2 * 125) + 125,
                    128, this);
        }
        g.setColor(Color.BLACK);
        g.fillRect(810, 10, 140, 50);
        g.setColor(Color.WHITE);
        Font MiFuente = new Font("Courrier New", 1, 20);
        g.setFont(MiFuente);
        g.drawString("Puntaje: " + t.getContadorRecompensas(), 820, 40);

        g.setColor(Color.BLACK);
        g.fillRect(410, 10, 110, 50);
        g.setColor(Color.WHITE);
        g.drawString("Vidas: " + t.getVidas(), 420, 40);

        if (t.getY() == 400 && direccion == true) {
            g.drawImage(personaje, t.getX(), t.getY(), t.getX() + 120, t.getY() + 170, (this.secuencia * 270), 0, (this.secuencia * 270) + 270, 520, this);
        }
        if (t.getY() < 400 && direccion == true) {
            g.drawImage(salto, t.getX(), t.getY(), t.getX() + 140, t.getY() + 190, (this.secuencia * 360), 0, (this.secuencia * 360) + 360, 860, this);
        }
        if (t.getY() == 400 && direccion == false) {
            g.drawImage(personaje, t.getX(), t.getY(), t.getX() + 120, t.getY() + 170, (this.secuenciaAtras * 270), 0, (this.secuenciaAtras * 270) - 270, 520, this);
        }
        if (t.getY() < 400 && direccion == false) {
            g.drawImage(salto, t.getX(), t.getY(), t.getX() + 140, t.getY() + 190, (this.secuenciaAtras * 360), 0, (this.secuenciaAtras * 360) - 360, 860, this);
        }

        for (int i = 0; i < Cerezas.size(); i++) {
            if (Cerezas.get(i).CogerRecompensas(t) == true) {
                t.setContadorRecompensas(t.getContadorRecompensas() + 1);
                if (i < 40) {
                    Cerezas.remove(i);
                    Cerezas.add(new Recompensas(x + cer.get(i) * 2, 300));
                }
                if (i >= 40) {
                    Cerezas.remove(i);
                    Cerezas.add(new Recompensas(x + cer.get(i) * 2, 450));
                }
            }
        }
        for (int i = 0; i < insectos.size(); i++) {

            if (insectos.get(i).tocarEnemigo(t) == true) {
                t.setVidas(t.getVidas() - 1);
                oh.play();
            }
            if (t.getVidas() == 0) {
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
                son.stop();
            }
        }
        if (t.getContadorRecompensas() >= 105) {
            timer.stop();
            NextNivel.addActionListener(new PasarAlNivel3(t.getContadorRecompensas()));
            NextNivel.setVisible(true);
            son.stop();
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
        son.stop();
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Cerezas.get(69).getX() > z) {
            fondo -= 10;
        }
        for (int i = 0; i < 70; i++) {
            Cerezas.get(i).setX(Cerezas.get(i).getX() - 10);
            insectos.get(i).setX(insectos.get(i).getX() - 10);
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

        if (this.secuencia2 == 2) {
            this.secuencia2 = 0;
        } else {
            this.secuencia2++;
        }
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_UP) {
                if (direccion == true) {
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
                    }
                }
                if (direccion == false) {
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
                    }
                }
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
                if (direccion == true) {
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
                    }
                }
                if (direccion == false) {
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
                    }
                }

            }

        }
    }
}
