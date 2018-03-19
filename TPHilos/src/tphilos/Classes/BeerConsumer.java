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
public class BeerConsumer extends Thread{
    private BeerHouse beerHouse;
    private final String name;
    private int beersBought;
    
    public BeerConsumer(String name, BeerHouse beerHouse){
        this.name = name;
        this.beerHouse = beerHouse;
    }
    
    @Override
    public void run(){
        while(beerHouse.isOpen()){
            if(beerHouse.isNotEmpty()){
                BuyOnBeerHouse();
           }else{
               System.out.println("Consumidor: " + name + " en espera.");   
            }
        }
    }
    
    public void BuyOnBeerHouse(){
        beerHouse.sell();
        beersBought++;
        System.out.println("Consumidor: " + name + " consumió una unidad. Cantidad consumida: " + beersBought);
    }
}
