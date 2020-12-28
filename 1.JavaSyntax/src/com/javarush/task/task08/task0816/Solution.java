package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Смирнов", dateFormat.parse("MAY 1 2003"));
        map.put("Смирно", dateFormat.parse("JUNE 2 2004"));
        map.put("Смирн", dateFormat.parse("JULY 3 2005"));
        map.put("Смир", dateFormat.parse("AUGUST 4 2006"));
        map.put("Сми", dateFormat.parse("SEPTEMBER 5 2007"));
        map.put("См", dateFormat.parse("OCTOBER 6 2008"));
        map.put("С", dateFormat.parse("NOVEMBER 7 2009"));
        map.put("Смирнова", dateFormat.parse("DECEMBER 8 2010"));
        map.put("Смирновин", dateFormat.parse("JANUARY 9 2011"));
        map.put("Смирновых", dateFormat.parse("FEBRUARY 10 2012"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
       Iterator < Map.Entry < String, Date > > iterator = map.entrySet().iterator();
       while(iterator.hasNext()) {
           Map.Entry<String, Date> pair = iterator.next();
           if (pair.getValue().getMonth() >= 5 && pair.getValue().getMonth() <= 7) {
               iterator.remove();
           }
       }
    }
      //  Iterator<Date> iterator = map.values().iterator();
      //  while (iterator.hasNext()) {
      //      Date date = iterator.next();
      //      System.out.println(date.getMonth());
      //      if (date.getMonth()==5) {
      //          iterator.remove();
      //      } else if (date.getMonth()==6) {
      //          iterator.remove();
      //      } else if (date.getMonth()==7) {
      //          iterator.remove();
      //      } else {
      //          iterator.next();
      //      }
      //  }

    public static void main(String[] args) throws ParseException {
        removeAllSummerPeople(createMap());
    }
}
