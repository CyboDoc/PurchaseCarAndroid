package cybodoc.garage.ModelClass;

import java.util.List;

/**
 * Created by pratheesh on 13-09-2016.
 */
public class SpecsResponse {

    public List<Engine> engines;

    public List<Engine> getEngines() {
        return engines;
    }

    public int getEnginesCount() {
        return enginesCount;
    }

    public int enginesCount;
}
