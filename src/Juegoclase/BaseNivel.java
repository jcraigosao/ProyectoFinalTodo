/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegoclase;

import juegofinal.*;
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
import java.util.Random;
import javax.swing.JPanel;

public class BaseNivel extends JFrame{

    public BaseNivel() {
        add(new NewPanel());
    }
  
    }
class NewPanel extends JPanel implements ActionListener, MouseListener{
    private int x;
    private int y=400;
    private Timer timer;
    private int secuencia;
    private int secuencia2;
    private int secuencia3;
    private int z;
    private int k;
    private int pbananas;
    private int qbananas;
    

    public NewPanel() {
        this.addMouseListener(this);
        addKeyListener(new TAdapter());
        setFocusable(true);
        timer= new Timer(100, this);
        timer.start();
        this.z=400;
    }
    
//    public Rectangle getBounds(){
//        return new Rectangle(p, q, 32, 32);
//    }
    
    public void checkCollision(){
    Rectangle tanque= getBounds();
    Rectangle objeto= new Rectangle(400, 398, 20, 20);
    Rectangle objeto2= new Rectangle(20, z+0, 20, 50); 
    if(tanque.intersects(objeto)||tanque.intersects(objeto2)){
     //   System.out.println("Colision");
        //timer.stop();
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        
       super.paintComponent(g);
    
    Image fondo=loadImage("forest-background.png");
    Image piso=loadImage("lea.png");
    for(int i=0; i<300; i++){   
        g.drawImage(fondo,k+(i*699),0,699,500,this);
        g.drawImage(piso, k+(i*300), 500, 300, 700,this);
    }
    
    g.setColor(Color.WHITE);
    g.fillRect(1250, 30, 100, 70);
    g.setColor(Color.BLACK);

    
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
        k-=10;
        x-=5;
        //p-=10;
        }
        if (y<z){
        y+=10;
        }
        
        if(this.secuencia ==5){
            this.secuencia=0;
        }else{
            this.secuencia++;
        }
        if(this.secuencia3==3.5){
            this.secuencia3=0;
        }else{
            this.secuencia+=0.7;
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

                    y-=100;
            }
            if(key==KeyEvent.VK_LEFT){
                x=x-5;
            }
            if(key==KeyEvent.VK_RIGHT){
                x=x+15;
            }
            if(key==KeyEvent.VK_UP){
                 if(y>399){                   
                 for (int i = 0; i < 10; i++) {
                y=y-8;
                x=x+5;  
//                   try{
//                     Thread.sleep(100);
//                 }catch(Exception er){
//                     
//                     er.printStackTrace();
//                 }
//                
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
