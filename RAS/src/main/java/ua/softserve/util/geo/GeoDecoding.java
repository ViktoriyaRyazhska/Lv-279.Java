/*
* Geodeconig
*
* Version 1.0-SNAPSHOT
*
* 13.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.util.geo;

import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;

public class GeoDecoding {
    public static PlaceName parseResult(GeocodingResult r) {

        PlaceName placeName = new PlaceName(); // simple POJO

        for (AddressComponent ac : r.addressComponents) {
            for (AddressComponentType acType : ac.types) {

                if (acType == AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1) {

                    placeName.setState(ac.longName);

                } else if (acType == AddressComponentType.LOCALITY) {

                    placeName.setCity(ac.longName);

                } else if (acType == AddressComponentType.COUNTRY) {

                    placeName.setCountry(ac.longName);
                }
            }

//            if(/* your condition */){ // got required data
//                break;
//            }
        }

        return placeName;
    }
}
