package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable {
    private final String name;

    public boolean isBusy() {
        return busy;
    }

    private boolean busy;

    public Cook(String name) {
        this.name = name;
    }


    public void startCookingOrder(Order order) throws InterruptedException {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        setChanged();
        notifyObservers(order);
        CookedOrderEventDataRow row = new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes());
        StatisticManager.getInstance().register(row);
        Thread.sleep(order.getTotalCookingTime()* 10L);
        busy = false;
    }

    @Override
    public String toString() {
        return name;
    }
}
