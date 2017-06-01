/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Niveles.TestPaintComponent1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Cristian Sarmiento
 */
public class Escuchador implements ActionListener{

    public Escuchador() {
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Inicio frame;
        System.out.println("Volvio a comenzar");
        frame= new Inicio();    
    }
    
}
