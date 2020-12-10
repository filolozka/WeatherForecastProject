package Services;

import Entities.Forecast;
import Entities.SearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherGateway {
    private final String SEARCH_URL = "https://www.metaweather.com/api/location/search/?query=berlin";
    private final String FORECAST_URL = "https://www.metaweather.com/api/location/638242/";
    private ObjectMapper mapper;

    public WeatherGateway(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public SearchResult[] findCityByName(String cityName) throws Exception {
        URL searsUrl = new URL(SEARCH_URL + cityName);

        SearchResult[] searchResults = mapper.readValue(searsUrl, SearchResult[].class);

        return searchResults;
    };

    public Forecast getWeatherByWoeid(String woeid) throws Exception {
        URL forecastUrl = new URL(FORECAST_URL + woeid);
        Forecast forecast = mapper.readValue(forecastUrl, Forecast.class);
        return forecast;
    };
}
