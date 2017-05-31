/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Niveles.TestPaintComponent1;
import Niveles.TestPaintComponent2;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author TOSHIBA
 */
public class VolverAlComienzo implements ActionListener{

    public VolverAlComienzo() {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Primer Nivel");
        TestPaintComponent1 frame= new TestPaintComponent1();
        frame.setTitle("Tarzan Adventure: Nivel 1");
        frame.setSize(1000 , 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
