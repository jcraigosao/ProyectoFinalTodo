package Menu;

import Niveles.TestPaintComponent2;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class PasarAlNivel2 implements ActionListener, MouseListener{

    private int puntaje;
    private static boolean open=false;
    private static TestPaintComponent2 frame;

    public PasarAlNivel2(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(open==false){
        System.out.println("Segundo Nivel");
         frame = new TestPaintComponent2(this.puntaje);
        frame.setTitle("Tarzan Adventure: Nivel 2");
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null); //Center the frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        open=true;
        }
        
    }
    
    public static void hideFrame( ) {
        frame.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        }

    @Override
    public void mouseReleased(MouseEvent me) {
        }

    @Override
    public void mouseEntered(MouseEvent me) {
        }

    @Override
    public void mouseExited(MouseEvent me) {
        }
    
}
