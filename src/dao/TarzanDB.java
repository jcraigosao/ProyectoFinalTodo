
package dao;


import java.io.FileNotFoundException;
import java.util.ArrayList;


public interface TarzanDB {
    public void escribir(Estadistica e) 
            throws FileNotFoundException;
    public ArrayList<Estadistica> leer();
}
