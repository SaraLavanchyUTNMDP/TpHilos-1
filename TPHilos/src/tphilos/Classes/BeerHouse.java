/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tphilos.Classes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigo
 */
public class BeerHouse {
    private int cantCervezas;
    private final int limiteCervezas = 100;
    private boolean isNotFull;
    private boolean isNotEmpty;
    
    public BeerHouse(){
        cantCervezas = 0;
        isNotFull = false;
        isNotEmpty = true;
    }
    
    public synchronized void charge(){
        while(!isNotFull()){
            try {
                System.out.println("BeerHouse llena. En espera para recargar.");
                wait();
            } catch (InterruptedException ex) 
            {
                System.out.println("Se interrumpió la espera a la hora de recargar. " + ex.getMessage());
            }
        }
        cantCervezas++;
        notifyAll();
    }
    
    public synchronized void sell(){
        while(!isNotEmpty()){
            try {
                System.out.println("BeerHouse Vacia. En espera para comprar.");
                wait();
            } catch (InterruptedException ex) 
            {
                System.out.println("Se interrumpió la espera a la hora de vender. " + ex.getMessage());
            }
        }
        cantCervezas--;
        notifyAll();
    }

    public boolean isNotEmpty() {
       isNotEmpty = cantCervezas > 0;
       
       return isNotEmpty;
    }
    
    public boolean isNotFull(){
        isNotFull = cantCervezas <= limiteCervezas;
        
        return isNotFull;
    }
    
}
