package Entities;

import java.util.Arrays;

public class Forecast {
    private ConsolidatedWeather[] consolidatedWeathers;

    public Forecast() {
    }

    public Forecast(ConsolidatedWeather[] weather) {
        this.consolidatedWeathers = weather;
    }

    public ConsolidatedWeather[] getConsolidatedWeathers() {
        return consolidatedWeathers;
    }

    public void setConsolidatedWeathers(ConsolidatedWeather[] consolidatedWeathers) {
        this.consolidatedWeathers = consolidatedWeathers;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "weatherList=" + Arrays.toString(consolidatedWeathers) +
                '}';
    }
}
