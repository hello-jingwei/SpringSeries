package com.example.token.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {

    @Test
    public void arr2List() {
        String[] str = {"a", "b", "c", "d"};
        List<String> list = Arrays.asList(str);
        list = new ArrayList<>(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
