package com.geekcircle.ImportantProblems;

import java.lang.reflect.Field;
import java.util.*;

class Node<T> {

    T item;
    Node next;

    public Node(T item, Node next) {
        this.item = item;
        this.next = next;
    }
}

public class Demo123 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < 30; i++){
            al.add(i);
            System.out.println(i+" Internal Size: "+findCapacity(al)+" External Size: "+al.size());
        }
    }

    static int findCapacity(ArrayList<Integer> al) throws Exception {
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        return ((Object[]) field.get(al)).length;
    }
}



