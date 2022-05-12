package machine;

import java.util.Scanner;

import static java.lang.System.*;
import static machine.CoffeeMachine.Drinks.*;

public class CoffeeMachine {
    static CoffeeMachine water = new CoffeeMachine(400," ml of water");
    static CoffeeMachine milk = new CoffeeMachine(540," ml of milk");
    static CoffeeMachine beans = new CoffeeMachine(120," g of coffe beans");
    static  CoffeeMachine cups = new CoffeeMachine(9," disposable cups");
    static CoffeeMachine money = new CoffeeMachine(550, "$ of money");

    public static void main(String[] args) {
        siema();
    }
    public static void siema(){
        for(;;){
            out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = getString();
            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    out.println("The coffee machine has:");
                    print();
                    break;
                case "exit":
                    System.exit(0);
            }
        }
    }
    public static void take(){
        out.printf("I gave you $ %d \n",money.quantity);
        money.setQuantity(0);
    }
    public static void fill(){
        out.println("Write how many ml of water you want to add:");
        int a = getInt();
        int x = water.quantity + a;
        water.setQuantity(x);
        out.println("Write how many ml of milk you want to add: ");
        a = getInt();
        x = milk.quantity + a;
        milk.setQuantity(x);
        out.println("Write how many grams of coffee beans you want to add: ");
        a = getInt();
        x = beans.quantity + a;
        beans.setQuantity(x);
        out.println("Write how many disposable cups of coffee you want to add:");
        a = getInt();
        x = cups.quantity + a;
        cups.setQuantity(x);
    }
    public static void print(){
        water.printQuantity();
        milk.printQuantity();
        beans.printQuantity();
        cups.printQuantity();
        money.printQuantity();
    }
    public static void buy(){
        out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String chose = getString();
        switch (chose){
            case "1":
                int x = water.quantity - espresso.water;
                if(x>0)water.setQuantity(x);
                else {out.println("Sorry, not enough water!"); break;}
                x = beans.quantity - espresso.beans;
                if(x>0)beans.setQuantity(x);
                else {out.println("Sorry, not enough beans!"); break;}
                x = cups.quantity - espresso.cups;
                if(x>0)cups.setQuantity(x);
                else {out.println("Sorry, not enough cups!"); break;}
                x = espresso.price + money.quantity;
                money.setQuantity(x);
                break;
            case "2":
                x = water.quantity - latte.water;
                if(x>0)water.setQuantity(x);
                else  {out.println("Sorry, not enough water!"); break;}
                x = milk.quantity - latte.milk;
                if(x>0)milk.setQuantity(x);
                else {out.println("Sorry, not enough milk!"); break;}
                x = beans.quantity - latte.beans;
                if(x>0)beans.setQuantity(x);
                else {out.println("Sorry, not enough beans!"); break;}
                x = cups.quantity - latte.cups;
                if(x>0)cups.setQuantity(x);
                else {out.println("Sorry, not enough cups!"); break;}
                x = latte.price + money.quantity;
                money.setQuantity(x);

                break;
            case "3":
                x = water.quantity - cappucino.water;
                if(x>0)water.setQuantity(x);
                else {out.println("Sorry, not enough water!"); break;}
                x = milk.quantity - cappucino.milk;
                if(x>0)milk.setQuantity(x);
                else {out.println("Sorry, not enough milk!"); break;}
                x = beans.quantity - cappucino.beans;
                if(x>0)beans.setQuantity(x);
                else {out.println("Sorry, not enough beans!"); break;}
                x = cups.quantity - cappucino.cups;
                if(x>0)cups.setQuantity(x);
                else {out.println("Sorry, not enough cups!"); break;}
                x = cappucino.price + money.quantity;
                money.setQuantity(x);

                break;
            case "back":
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + chose);
        }
    }

    public static class Drinks{
            private final int water;
            private final int milk;
            private final  int beans;
            private final  int cups;
            private final  int price;
            static Drinks espresso = new Drinks(250,0,16, 1,4);
            static Drinks latte = new Drinks(350,75,20,1,7);
            static Drinks cappucino = new Drinks(200,100,12,1,6);

            public Drinks(int water,int milk,int beans,int cups,int price){
              this.beans = beans;
              this.water = water;
              this.milk = milk;
              this.cups = cups;
              this.price = price;
            }
        }
    private int quantity = 0;
    public String name;
    public CoffeeMachine(int quantity,String name){
        this.setQuantity(quantity);
        this.name = name;
    }
    public void setQuantity(int newquantity){
        quantity = newquantity;
    }
    public int getQuantity(){
        return quantity;
    }
    public String toString(){
        return getQuantity() +name;
    }
    public void printQuantity(){
        out.println(this);
    }
    public static String getString(){
        return new Scanner(System.in).nextLine();
    }
    public static int getInt(){
        return new Scanner(System.in).nextInt();
    }
}
