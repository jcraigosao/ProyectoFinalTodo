
package JuegoPrueba;


import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;
import javax.swing.JPanel;

public class Prueba extends JFrame {

    public Prueba(){
        add(new NewPanel());
    }
    
    public static void main(String[] args) {
        Prueba frame= new Prueba();
        frame.setTitle("La prueba...");
        frame.setSize(1500 , 600);
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    }
    
    

