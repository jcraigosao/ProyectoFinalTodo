/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Niveles.TestPaintComponent2;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author TOSHIBA
 */
public class PasarAlNivel2 implements ActionListener{

    public PasarAlNivel2() {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Segundo Nivel");
        TestPaintComponent2 frame= new TestPaintComponent2();
        frame.setTitle("Tarzan Adventure: Nivel 2");
        frame.setSize(1000 , 600);
        frame.setLocationRelativeTo(null); //Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
