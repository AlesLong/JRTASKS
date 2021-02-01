package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello";
        Long id1 = shortener.getId(s1);
        Long id2 = shortener.getId(s2);
        Long id3 = shortener.getId(s3);
        Assert.assertNotEquals(id1, id2);
        Assert.assertNotEquals(id3, id2);
        Assert.assertEquals(id1, id3);
        String string1 = shortener.getString(id1);
        String string2 = shortener.getString(id2);
        String string3 = shortener.getString(id3);
        Assert.assertEquals(s1, string1);
        Assert.assertEquals(s2, string2);
        Assert.assertEquals(s3, string3);
    }

    @Test
    public void testHashMapStorageStrategy() {
        HashMapStorageStrategy hmss = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hmss);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        OurHashMapStorageStrategy ohss = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(ohss);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        FileStorageStrategy fss = new FileStorageStrategy();
        Shortener shortener = new Shortener(fss);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        HashBiMapStorageStrategy hmbss = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hmbss);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        DualHashBidiMapStorageStrategy dhbmss = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dhbmss);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        OurHashBiMapStorageStrategy ohbmss = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ohbmss);
        testStorage(shortener);
    }
}
