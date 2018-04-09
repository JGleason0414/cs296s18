package edu.moravian.mathcs.hellogeocoding;

/**
 * Created by meotm01 on 4/6/18.
 */

public class GeocodingResponse {

    Result results[];
    String status;

    public Result[] getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }
}
