package co.edu.udea;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by camilosampedro on 8/03/17.
 */
public class LecturaDesdeArchivo {
    static List<Double> leerDesdeUnArchivo(String filename) throws FileNotFoundException, IOException {
        List<Double> lista = new ArrayList<Double>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lista.add(Double.parseDouble(line));
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return lista;
    }
}
