
package puentethreadsafe;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona implements Runnable{
    //Atributos.
    private final String idPersona;
    private final int tiempoPaso;
    private final int pesoPersona;
    private final Puente puente;
    // COnstructor

    public Persona(String idPersona, int tiempoPaso, int pesoPersona, Puente puente) {
        this.idPersona = idPersona;
        this.tiempoPaso = tiempoPaso;
        this.pesoPersona = pesoPersona;
        this.puente = puente;
    }
    
    //Getter y setters

    public String getIdPersona() {
        return idPersona;
    }

    public int getTiempoPaso() {
        return tiempoPaso;
    }

    public int getPesoPersona() {
        return pesoPersona;
    }
    // Método run
    @Override
    public void run(){
        System.out.printf(">>> La %s con %d kilos quiere cruzar en %d segundo.\n" + " Estado del puente: %d personas, %d kilos.",
                idPersona,pesoPersona,tiempoPaso,puente.getNumeroPersonas(), puente.getPesoPersonas());
        try {
            //Entrar
            puente.entrar(this);
        } catch (InterruptedException ex) {
            }
        try {
            Thread.sleep(tiempoPaso * 100);
        } catch (InterruptedException ex) {
            }
        //Salir
       puente.salir(this);
    }
    
}
