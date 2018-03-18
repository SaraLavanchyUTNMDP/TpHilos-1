/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tphilos;

import tphilos.Classes.BeerConsumer;
import tphilos.Classes.BeerHouse;
import tphilos.Classes.BeerProducer;

/**
 *
 * @author rodrigo
 */
public class TPHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BeerHouse beerHouse = new BeerHouse();
        // productores
        BeerProducer producerOne = new BeerProducer(5, beerHouse, "Voldemort");
        BeerProducer producerTwo = new BeerProducer(5, beerHouse, "Draco");
        BeerProducer producerThree = new BeerProducer(5, beerHouse, "Lucius");
        // Consumidores
        BeerConsumer consumerOne = new BeerConsumer("Harry", beerHouse);
        BeerConsumer consumerTwo = new BeerConsumer("Ronn", beerHouse);
        BeerConsumer consumerThree = new BeerConsumer("Hermione", beerHouse);
        
        producerOne.start();
        consumerOne.start();
        consumerTwo.start();
    }
    
}