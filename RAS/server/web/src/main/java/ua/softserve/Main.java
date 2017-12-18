/*
 * Main
 *
 * Version 1.0-SNAPSHOT
 *
 * 18.12.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */

package ua.softserve;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("asd");
        stringList.add(null);
        stringList.add("123");
        stringList.add(null);
        stringList.add("1421");

        boolean testResult = stringList
                .stream()
                .filter(Objects::nonNull)
                .anyMatch(s -> s.contains("1"));
        System.out.println(testResult);

    }

}
