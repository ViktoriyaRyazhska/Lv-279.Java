/*
* GeoDemo
*
* Version 1.0-SNAPSHOT
*
* 13.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.util.geo;

import com.google.maps.model.GeocodingResult;

public class GeoDemo {

    public static void main(String[] args) {

        String geo = "";

        PlaceName placeName = GeoDecoding.parseResult(new GeocodingResult());

        System.out.println(placeName.getCity());
        System.out.println(placeName.getCountry());
        System.out.println(placeName.getState());


    }

}
