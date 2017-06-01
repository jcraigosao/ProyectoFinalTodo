/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Niveles;

import javax.swing.JFrame;
import Niveles.Nivel1;

/**
 *
 * @author TOSHIBA
 */
public class TestPaintComponent2 extends JFrame{
    
    private static boolean open = false;

    public TestPaintComponent2(int puntaje) {
        if ( !open ) {
            add(Nivel2.getInstance(puntaje));
            open = true;
        }
    }

    }
