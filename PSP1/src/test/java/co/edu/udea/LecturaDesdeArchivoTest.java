package co.edu.udea;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by camilosampedro on 8/03/17.
 */
public class LecturaDesdeArchivoTest {
    private String nombreDeArchivoInexistente;
    private String nombreDeArchivoVacio;
    private String nombreDeArchivoCorrecto;

    @BeforeMethod
    public void setUp() throws Exception {
        nombreDeArchivoInexistente = "testInexistente.txt";
        nombreDeArchivoVacio = getFileName("testVacio.txt");
        nombreDeArchivoCorrecto = getFileName("testCorrecto.txt");
    }

    private String getFileName(String fileName) {
        return getClass().getClassLoader().getResource(fileName).getFile();
    }

    @Test(expectedExceptions = FileNotFoundException.class)
    public void testLeerDesdeUnArchivoNoExistente() throws Exception {
        LecturaDesdeArchivo.leerDesdeUnArchivo(nombreDeArchivoInexistente);
    }

    @Test
    public void testLeerDesdeUnArchivoVacio() throws Exception {
        List<Double> resultado = LecturaDesdeArchivo.leerDesdeUnArchivo(nombreDeArchivoVacio);
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void testLeerDesdeUnArchivoCorrecto() throws Exception {
        List<Double> resultado = LecturaDesdeArchivo.leerDesdeUnArchivo(nombreDeArchivoCorrecto);
        assertEquals(160.0, resultado.get(0));
        assertEquals(591.0, resultado.get(1));
        assertEquals(114.0, resultado.get(2));
    }

}