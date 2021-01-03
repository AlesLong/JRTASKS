package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
@SuppressWarnings("unchecked")
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public Solution(int node) {
        this.node = node;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(edges);
        objectOutputStream.writeInt(node);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.edges = (LinkedList<Solution>) objectInputStream.readObject();
        this.node = objectInputStream.readInt();
    }
}

class Verificator {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution node6 = new Solution(6);
        Solution node3 = new Solution(3);
        node6.edges.add(node3);
        //node3.connections.add(null);
        printGraph(node6);
        FileOutputStream fos = new FileOutputStream("graph.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        objectOutputStream.writeObject(node6);
        objectOutputStream.close();
        fos.close();

        FileInputStream fis = new FileInputStream("graph.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);
        Object node = (Solution) objectInputStream.readObject();
        printGraph((Solution) node);
    }

    private static void printGraph(Solution root) {
        if (root == null) {
            return;
        }
        System.out.println(root.node + " ");

        for (Solution node : root.edges) {
            printGraph(node);
        }
    }
}