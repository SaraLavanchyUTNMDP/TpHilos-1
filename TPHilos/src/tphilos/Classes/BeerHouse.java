/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tphilos.Classes;

/**
 *
 * @author rodrigo
 */
public class BeerHouse {
    private String name;
    private int cantCervezas;
    private int soldUnits;
    private int rechargedUnits;
    private final int limiteCervezas = 100;
    private boolean isNotFull;
    private boolean isNotEmpty;
    private int activeProducers; // Lleva la cuenta de los productores activos.
    
    public BeerHouse(String name){
        this.name = name;
        activeProducers = 0;
        cantCervezas = limiteCervezas;
        soldUnits = 0;
        rechargedUnits = 0;
        isNotFull = false;
        isNotEmpty = true;
    }
    
    public synchronized void charge(){
        while(!isNotFull()){
            try {
                System.out.println("BeerHouse llena."+cantCervezas);
                wait();
            } catch (InterruptedException ex) 
            {
                System.out.println("Se interrumpió la espera a la hora de recargar. " + ex.getMessage());
            }
        }
        System.out.println(cantCervezas);
        cantCervezas++;
        rechargedUnits++;
        notifyAll();
    }
    
    public synchronized void sell(){
        while(!isNotEmpty()){
            try {
                System.out.println("BeerHouse Vacia."+cantCervezas);
                wait();
            } catch (InterruptedException ex) 
            {
                System.out.println("Se interrumpió la espera a la hora de vender. " + ex.getMessage());
            }
        }
        cantCervezas--;
        soldUnits++;
        notifyAll();
    }

    public boolean isNotEmpty() {
       isNotEmpty = cantCervezas > 0;
       
       return isNotEmpty;
    }
    
    public boolean isNotFull(){
        isNotFull = cantCervezas < limiteCervezas; //si es igual al limite es por que está llena.
        
        return isNotFull;
    }
    
    synchronized void incrementActiveProducers(){
        activeProducers++;
    }
    
    synchronized void decrementActiveProducers(){
        activeProducers--;
    }
    
    public synchronized boolean isOpen(){
        // Si ya no hay cervezas y no hay productores la tienda cierra.
        boolean isOpen;
        if (activeProducers > 0 || cantCervezas > 0){
            isOpen = true;
        }else{
            isOpen = false;
            System.out.println("Cierra " + toString());
        }
        
        return isOpen;
    }
    
    @Override
    public String toString(){
        return "Beerhouse: " + name +
               "| Beers sold: "+ soldUnits + 
               "| Beers recharged: " + rechargedUnits + 
               "| Actual stock: " + cantCervezas + "|";
    }
    
}
