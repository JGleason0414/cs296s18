package edu.moravian.mathcs.hellogeocoding;

/**
 * Created by meotm01 on 4/6/18.
 */

public class Result {

    AddressComponent address_components[];
    String formatted_address;
    Geometry geometry;
    String place_id;
    String types[];

    public AddressComponent[] getAddress_components() {
        return address_components;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public String getPlace_id() {
        return place_id;
    }

    public String[] getTypes() {
        return types;
    }
}
