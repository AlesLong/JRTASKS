package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.ad.AdvertisementStorage;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {
    private StatisticStorage statisticStorage = new StatisticStorage();

    private static final StatisticManager statisticManager = new StatisticManager();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return statisticManager;
    }

    public void register(EventDataRow data) {
        this.statisticStorage.put(data);
    }

    private class StatisticStorage {

        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        private StatisticStorage() {
            for (EventType type : EventType.values()) {
                this.storage.put(type, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            EventType type = data.getType();
            if (!this.storage.containsKey(type))
                throw new UnsupportedOperationException();

            this.storage.get(type).add(data);
        }
    }
}
