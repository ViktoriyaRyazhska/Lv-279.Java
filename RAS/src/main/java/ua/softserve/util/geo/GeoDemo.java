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

import com.google.maps.GaeRequestHandler;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import java.io.IOException;

public class GeoDemo {

    public static void main(String[] args) throws IOException, InterruptedException, ApiException {

//        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng=" +
//                "49.833125,23.997769&sensor=false");
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
//        char ch[] = new char[1000];
//        StringBuilder sb = new StringBuilder();
//        while ((in.read(ch)) != -1) {
//            sb.append(ch);
//            System.out.println(new String(ch));
//        }
//        System.out.println(ch);

        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyDcNsOWDcFMAFp6HvDK9Wi55H4kCBrjfQQ");
        GeocodingResult[] ens = GeocodingApi.newRequest(context)
                .latlng(new LatLng(49.8326449,23.999098))
                .language("en").await();

        for (GeocodingResult gr : ens) {
            PlaceName placeName = GeoDecoding.parseResult(gr);
            System.out.println(placeName.getCity());
            System.out.println(placeName.getCountry());
            System.out.println(placeName.getState());
        }

    }

}
