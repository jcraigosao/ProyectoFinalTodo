/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegofinal;

import java.awt.Color;
import javax.swing.*;
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
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import javax.swing.JPanel;

public class BaseNivel extends JFrame{

    public BaseNivel() {
        add(new NewPanel());
    }
    public static void main(String[] args) {
        BaseNivel frame= new BaseNivel();
        frame.setTitle("Nivel 1");
        frame.setSize(20000 , 10000);
        frame.setLocationRelativeTo(null); //Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    }
class NewPanel extends JPanel implements ActionListener, MouseListener{
    private int x;
    private int y=400;
    private Timer timer;
    private int secuencia;
    private int secuencia2;
    private int z;
    private int k;
    private int p;
    private int q;
    

    public NewPanel() {
        this.addMouseListener(this);
        addKeyListener(new TAdapter());
        setFocusable(true);
        timer= new Timer(100, this);
        timer.start();
        this.z=400;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(p, q, 32, 32);
    }
    
    public void checkCollision(){
    Rectangle tanque= getBounds();
    Rectangle objeto= new Rectangle(400, 398, 20, 20);
    Rectangle objeto2= new Rectangle(20, z+0, 20, 50); 
    if(tanque.intersects(objeto)||tanque.intersects(objeto2)){
        System.out.print("Colision");
        timer.stop();
    }
    
}
    @Override
    protected void paintComponent(Graphics g){
        
       super.paintComponent(g);
//        int k=0;
//        for (int i = 0; i < 1000; i++) {  
//        Image fondo= loadImage("blue_background.png");
//        g.drawImage(fondo, k, 0, null);
//        k+=22;
//        }
    Image fondo=loadImage("forest-background.png");
    
    for(int i=0; i<20; i++){   
        g.drawImage(fondo,k+(i*699),0,699,500,this);
        
    }
    p=0;
    q=470;
    for(int i=0;i<5;i++){
    Image tronco = loadImage("short.png");
    g.drawImage(tronco, p+(40), q, 40, 60, this);
    p+=300;
    }
    
    int s=50;
    int r=450;
        for (int i = 0; i < 5; i++) {
            
            Image bananas = loadImage("Bananas.png");
            g.drawImage(bananas, s, r, s+60, r+80, (this.secuencia2*388), 0,(this.secuencia2*388)+388, 422, this);

            s+=300;
        }
     if(y==z){   
     Image personaje= loadImage("ANA.png");
     g.drawImage(personaje, x+250, y, x+350, y+150, (this.secuencia*295), 0,(this.secuencia*295)+260, 529, this);
     }
     if(y<z){
     Image salto= loadImage("jump.png");
     g.drawImage(salto, x+250, y-50, x+350, y+150, (this.secuencia*1340), 0,(this.secuencia*1340)+1340, 3629, this);
     }
        Image moneda= loadImage("FullCoins.png");
        //g.drawImage(moneda, );
//        Image gato= loadImage("cats.gif");
//        g.drawImage(gato, x, 360, x+132, 440, (this.secuencia*132), 0, (this.secuencia*132)+132, 80, this);
        

    }
    public Image loadImage (String imageName){
        ImageIcon ii= new ImageIcon(imageName);
        Image image= ii.getImage();
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x<900){
        //x+=5;
        k-=1;
        p-=1;
        }
        if (y<z){
        y+=10;
        }
        
        if(this.secuencia ==+5){
            this.secuencia=0;
        }else{
            this.secuencia++;
        }
        
        if(this.secuencia2 ==1){
            this.secuencia2=0;
        }else{
            this.secuencia2++;
        }
//        if(z<500){
//            z+=5;
//        
//   }
        checkCollision();
        repaint();
    }
    
    private class TAdapter extends KeyAdapter{
        public void keyReleased(KeyEvent e){
            System.out.println("Soltó el botón");
        }
        public void keyPressed(KeyEvent e){
            System.out.println("Presionó el botón");
            int key= e.getKeyCode();
            if(key==KeyEvent.VK_SPACE){
                System.out.println("Presiono el espacio");
            }
            if(key==KeyEvent.VK_LEFT){
                x=x-5;
            }
            if(key==KeyEvent.VK_RIGHT){
                x=x+5;
            }
            if(key==KeyEvent.VK_UP){
                 if(y>399){                   
                 for (int i = 0; i < 10; i++) {
                y=y-15;
                x=x+10;  
//                   try{
//                     Thread.sleep(100);
//                 }catch(Exception er){
//                     
//                     er.printStackTrace();
//                 }
                
                }
                 }
           
                /*for (int i = 0; i < 5; i++) {
                y=y+5;
                repaint();
                }*/
                
            }
//            if(key==KeyEvent.VK_DOWN){
//                y=y+10;
//            }
//            
        }
         public void KeyReleased(KeyEvent e){
               int key= e.getKeyCode();
               if(key==KeyEvent.VK_DOWN){
               y=y+10;
               }
                   
                 
                 
                 
                 }
      
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       System.out.println("Usted ha clickeado");
       Point mp=e.getPoint();
       if(getBounds().contains(mp)){
           this.timer.stop();
           
       }
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
