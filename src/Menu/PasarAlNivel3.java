/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Niveles.TestPaintComponent2;
import Niveles.TestPaintComponent3;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author TOSHIBA
 */
public class PasarAlNivel3 implements ActionListener{

    public PasarAlNivel3() {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Tercer Nivel");
        TestPaintComponent3 frame= new TestPaintComponent3();
        frame.setTitle("Tarzan Adventure: Nivel 3");
        frame.setSize(1000 , 600);
        frame.setLocationRelativeTo(null); //Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}