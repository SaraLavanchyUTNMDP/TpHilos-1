/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


/**
 *
 * @author rodrigo
 */
public class BeerHouse {
    
    private int beersCuantity;
    private final int beerLimit = 100;
    
    public BeerHouse(){
        beersCuantity = beerLimit; //inicializa llena.
    }
    
    public synchronized void charge(int beersToCharge){
        
        while(isFull(beersToCharge)){
            try {
                System.out.println("BeerHouse llena.");
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error en la espera cuando la casa esta llena.");
            }
        }
        System.out.println("Cerveza cargada. Stock: " + beersCuantity);
        beersCuantity+= beersToCharge;
        notifyAll();
    }
    
    public synchronized void sell(){
        if(!isEmpty()){
            System.out.println("Cerveza vendida. Stock: "+ beersCuantity);
            beersCuantity--;
            notifyAll();
        }else{
            System.out.println("Consumidor Quiso comprar y no había más :(");
        }
    }
    
    public synchronized boolean isFull(){
        return beersCuantity >= beerLimit;
    }
    
    public synchronized boolean isFull(int additionalBeers){
        return beersCuantity+additionalBeers >= beerLimit;
    }
    
    public synchronized boolean isEmpty(){
        return beersCuantity <= 0;
    }
    
}
