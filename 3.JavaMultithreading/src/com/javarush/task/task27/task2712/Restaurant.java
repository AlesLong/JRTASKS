package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);

        Waiter waiter = new Waiter();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();

        Cook cook = new Cook("Yevheniy");
        tablet.addObserver(cook);
        cook.addObserver(waiter);


        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();

    }
}
