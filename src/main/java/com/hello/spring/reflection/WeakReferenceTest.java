package com.hello.spring.reflection;

import java.lang.ref.WeakReference;

/**
 * Created by daipengfei
 * on 2017/9/20.
 */
public class WeakReferenceTest {
    private double price;
    private String colour;

    public WeakReferenceTest(double price, String colour){
        this.price = price;
        this.colour = colour;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }

    public String toString(){
        return colour +"car costs $"+price;
    }

    public static void main(String[] args) {
        WeakReferenceTest weakReferenceTest = new WeakReferenceTest(22000,"silver");
        WeakReference<WeakReferenceTest> weakCar = new WeakReference<WeakReferenceTest>(weakReferenceTest);

        int i=0;

        while(true){
            if(weakCar.get()!=null){
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakCar);
            }else{
                System.out.println("Object has been collected.");
                break;
            }
        }
    }
}
