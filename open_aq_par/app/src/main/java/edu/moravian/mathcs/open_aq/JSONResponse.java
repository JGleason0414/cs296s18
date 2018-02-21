package edu.moravian.mathcs.open_aq;

import java.util.List;

public class JSONResponse {

    Metadata meta;
    List<Result> results;

    public Metadata getMeta() {
        return meta;
    }

    public List<Result> getResults() {
        return results;
    }
}
