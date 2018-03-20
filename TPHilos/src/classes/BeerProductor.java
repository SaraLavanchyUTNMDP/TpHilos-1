/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigo
 */
public class BeerProductor extends Thread{
    
    
    private BeerHouse beerHouse;
    private int beersPerProductionTime;

    public BeerProductor(BeerHouse beerHouse, int beersPerProductionTime) {
        this.beerHouse = beerHouse;
        this.beersPerProductionTime = beersPerProductionTime;
    }
    
    @Override
    public void run(){
        while(!beerHouse.isEmpty()){ // Corta cuando ya hay stock.
            produce();
            System.out.println("Produce");
            //try {
            //    sleep(200);
            //} catch (InterruptedException ex) { }
        }
        System.out.println("productor finalizo.");
    }
    
    public void produce(){
        beerHouse.charge(beersPerProductionTime);
    }
    
}
