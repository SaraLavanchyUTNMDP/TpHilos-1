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
public class BeerProducer extends Thread{
    private int stock;
    private boolean outOfStock;
    private BeerHouse beerHouse;
    private final String name;
    
    public BeerProducer(int stock, BeerHouse beerHouse, String name){
        this.name = name;
        this.stock = stock;
        this.outOfStock = stock <= 0 ;
        this.beerHouse = beerHouse;
    }
    
    @Override
    public void run(){
        while(!outOfStock){
            charge();
            System.out.println("Productor: " + name + ", Stock actual : " + stock);
        }
    }
    
    public void charge(){
            beerHouse.charge();
            reduceStock();
    }
    
    public boolean isOutOfStock(){
        return outOfStock;
    }
    
    private void reduceStock(){
        if(stock > 0){
            stock--;
        }
        if(stock <= 0){
            outOfStock = true;
        }
    }
    
}
