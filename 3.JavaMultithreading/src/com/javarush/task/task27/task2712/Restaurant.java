package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        

        Waiter waiter = new Waiter();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();

        Cook cookYevheniy = new Cook("Yevheniy");
        Cook cookRoman = new Cook("Roman");
        StatisticManager instance = StatisticManager.getInstance();
        instance.register(cookRoman);
        instance.register(cookYevheniy);

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tablets.add(new Tablet(i + 1));
        }


        for (Tablet tablet :
                tablets) {
            tablet.addObserver(cookRoman);
            tablet.addObserver(cookYevheniy);
        }

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();
            thread.join();
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }

    }
}
