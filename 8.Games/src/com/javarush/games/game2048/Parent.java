package com.javarush.games.game2048;


public class Parent {
    public void whoAreYou() {
        System.out.println("I'm parent");
    }


}

class Child extends Parent {
    public static void main(String[] args) {
        Parent p = new Child();
        p.whoAreYou();
    }
    public void whoAreYou() {
        System.out.println("I'm child");
    }
}

