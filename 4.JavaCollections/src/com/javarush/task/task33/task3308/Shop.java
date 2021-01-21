package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    @XmlElement
    public Goods goods;
    @XmlElement
    public int count;
    @XmlElement
    public double profit;
    @XmlElement
    public String[] secretData = new String[5];

    public static class Goods {
        @XmlElement
        List<String> names = new ArrayList<>();

    }
}
