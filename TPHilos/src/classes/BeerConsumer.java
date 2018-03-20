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
public class BeerConsumer extends Thread{
    
    private BeerHouse beerHouse;
    private int idConsumer;

    public BeerConsumer(BeerHouse beerHouse, int idConsumer) {
        this.beerHouse = beerHouse;
        this.idConsumer = idConsumer;
    }
    
    @Override
    public void run(){
        while(!beerHouse.isEmpty()){
            consume();
            System.out.println("Consume");
        }
        System.out.println("consumidor " + idConsumer + " finalizo.");
    }
    
    public void consume(){
        beerHouse.sell();
    }
    
    public int getIdConsumer(){
        return idConsumer;
    }
    
}
