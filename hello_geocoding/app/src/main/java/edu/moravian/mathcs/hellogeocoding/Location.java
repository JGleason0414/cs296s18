package edu.moravian.mathcs.hellogeocoding;

import java.io.Serializable;

/**
 * Created by meotm01 on 4/6/18.
 */

public class Location implements Serializable {

    double lat, lng;

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "Location{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
