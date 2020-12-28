package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.UKRAINE);
        hen.getCountOfEggsPerMonth();
        Hen hen1 = HenFactory.getHen(Country.BELARUS);
        hen1.getCountOfEggsPerMonth();
        Hen hen2 = HenFactory.getHen(Country.MOLDOVA);
        hen2.getCountOfEggsPerMonth();
        Hen hen3 = HenFactory.getHen(Country.RUSSIA);
        hen3.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            if (country.equals(Country.UKRAINE)) {
                hen = new UkrainianHen();
            }
            if (country.equals(Country.RUSSIA)) {
                hen = new RussianHen();
            }
            if (country.equals(Country.MOLDOVA)) {
                hen = new MoldovanHen();
            }
            if (country.equals(Country.BELARUS)) {
                hen = new BelarusianHen();
            }
            System.out.println(hen.getDescription());
            return hen;
        }
    }
}
