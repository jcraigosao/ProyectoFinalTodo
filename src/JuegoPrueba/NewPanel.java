/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoPrueba;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
/**
 *
 * @author TOSHIBA
 */
public class NewPanel extends JPanel implements ActionListener, MouseListener{
    private Timer timer;
    private int x;

    public NewPanel() {
        this.timer = new Timer(100, this);
        this.addMouseListener(this);
        addKeyListener(new TAdapter());
        setFocusable(true);
    }
    
    protected void paintComponent(Graphics g){
        
       super.paintComponent(g);
       g.drawRect(x+40, 450, 100, 150);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(x<300){
            x+=30;
        }
        checkCollision();
        repaint();
    }
    
    public Rectangle getBounds(){
        return new Rectangle(250,0, 100, 150);
    }
    
    public void checkCollision(){
    Rectangle tarzan= getBounds();
    Rectangle[] rah= new Rectangle[70];
        for (int i = 0; i < 10; i++) {
    //rah[i]= new Rectangle(bananos[i].getX(), bananos[i].getY(), 60, 80);        
        }
   
    
    Rectangle objeto2= new Rectangle(20, 0, 20, 50); 
    //if(tanque.intersects(objeto)||tanque.intersects(objeto2)){
     //   System.out.println("Colision");
        //timer.stop();
        //}
    }
    private class TAdapter extends KeyAdapter{
    
        public void keyReleased(KeyEvent e){
            System.out.println("Soltó el botón");
        }
        public void keyPressed(KeyEvent e){
            System.out.println("Presionó el botón");
            
            int key= e.getKeyCode();
            if(key==KeyEvent.VK_SPACE){

            }
            if(key==KeyEvent.VK_LEFT){
             
            }
            if(key==KeyEvent.VK_RIGHT){
             
            }
            if(key==KeyEvent.VK_UP){
            }
//            
        }
         public void KeyReleased(KeyEvent e){
               int key= e.getKeyCode();
               if(key==KeyEvent.VK_DOWN){
               }
                   
                 
                 
                 
                 }
      
    }



    

    @Override
    public void mouseClicked(MouseEvent e) {
    
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
