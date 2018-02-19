package edu.moravian.mathcs.open_aq;

public class Result {

    String city;
    String country;
    int locations;
    int count;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getLocations() {
        return locations;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Result{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", locations=" + locations +
                ", count=" + count +
                '}';
    }
}
