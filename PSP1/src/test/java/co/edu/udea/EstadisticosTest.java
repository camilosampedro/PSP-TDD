package co.edu.udea;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by camilo on 7/03/17.
 */
public class EstadisticosTest {
    private List<Double> listaColumna1 = new ArrayList<Double>();
    private List<Double> listaColumna2 = new ArrayList<Double>();

    @BeforeTest
    public void inicializarListas() {
        this.inicializarListaColumna1();
        this.inicializarListaColumna2();
    }

    private void inicializarListaColumna1() {
        listaColumna1.add(160.0);
        listaColumna1.add(591.0);
        listaColumna1.add(114.0);
        listaColumna1.add(229.0);
        listaColumna1.add(230.0);
        listaColumna1.add(270.0);
        listaColumna1.add(128.0);
        listaColumna1.add(1657.0);
        listaColumna1.add(624.0);
        listaColumna1.add(1503.0);
    }

    private void inicializarListaColumna2() {
        listaColumna2.add(15.0);
        listaColumna2.add(69.9);
        listaColumna2.add(6.5);
        listaColumna2.add(22.4);
        listaColumna2.add(28.4);
        listaColumna2.add(65.9);
        listaColumna2.add(19.4);
        listaColumna2.add(198.7);
        listaColumna2.add(38.8);
        listaColumna2.add(138.2);
    }

    @Test
    public void testCalcularMediaConDatosDelProfesorColumna1() {
        double resultado = Estadisticos.calcularMedia(listaColumna1);
        double esperado = 550.6;
        assertEquals(esperado, resultado,0.01);
    }

    @Test
    public void testCalcularMediaConDatosDelProfesorColumna2() {
        double resultado = Estadisticos.calcularMedia(listaColumna2);
        double esperado = 60.32;
        assertEquals(esperado, resultado,0.01);
    }

    @Test
    public void testCalcularDesviacionEstandarConDatosDelProfesorColumna1() {
        double resultado = Estadisticos.calcularDesviacionEstandar(listaColumna1);
        double esperado = 572.03;
        assertEquals(esperado, resultado,0.01);
    }

    @Test
    public void testCalcularDesviacionEstandarConDatosDelProfesorColumna2() {
        double resultado = Estadisticos.calcularDesviacionEstandar(listaColumna2);
        double esperado = 62.26;
        assertEquals(esperado, resultado,0.01);
    }
}

