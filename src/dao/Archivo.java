package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivo implements TarzanDB {

    private File archivo;
    Scanner sn = new Scanner(System.in);

    public Archivo() {
        this.archivo = new File("tarzan.txt");
    }

    @Override
    public void escribir(Estadistica estadistica)
            throws FileNotFoundException {
        ArrayList<Estadistica> estadisticas = new ArrayList<>();
        estadisticas = this.leer();
        estadisticas.add(estadistica);
        PrintStream salida = new PrintStream(archivo);
        for (Estadistica e : estadisticas) {
            salida.println(e.getJugador() + ";" + e.getPuntje());
        }
        salida.close();
    }

    @Override
    public ArrayList<Estadistica> leer() {
        ArrayList<Estadistica> datosTexto = new ArrayList<>();
        try {
            sn = new Scanner(this.archivo);

            while (sn.hasNextLine()) {
                String line = sn.nextLine();
                String[] dato = line.split(";");
                Estadistica estadistica = new Estadistica();
                estadistica.setJugador(dato[0]);
                estadistica.setPuntje(Integer.parseInt(dato[1]));
                datosTexto.add(estadistica);
            }
            sn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return datosTexto;
    }

}
