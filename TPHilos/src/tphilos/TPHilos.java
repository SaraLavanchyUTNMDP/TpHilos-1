/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tphilos;

import classes.BeerConsumer;
import classes.BeerHouse;
import classes.BeerProductor;

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
        BeerProductor productor = new BeerProductor(beerHouse, 1);
        //BeerProductor productor2 = new BeerProductor(beerHouse, 1);
        productor.start();
        //productor2.start();
        //Apertura al publico
        int i = 1;
        while(!beerHouse.isEmpty()){
            BeerConsumer consumer = new BeerConsumer(beerHouse, i);
            consumer.start();
            System.out.println("Consumidor "+i);
            i++;
        }
    }
}
