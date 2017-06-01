package Menu;

import Niveles.TestPaintComponent2;
import Niveles.TestPaintComponent3;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class PasarAlNivel3 implements ActionListener {

    private int puntaje;
    private static boolean open;
    private static TestPaintComponent3 frame;

    public PasarAlNivel3(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!open){
        System.out.println("Tercer Nivel");
        frame = new TestPaintComponent3(this.puntaje);
        frame.setTitle("Tarzan Adventure: Nivel 3");
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null); //Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        PasarAlNivel2.hideFrame();
        open=true;
    }
    }
    

}
