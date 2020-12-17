package Services;


import Entities.ConsolidatedWeather;
import Entities.Forecast;
import Entities.SearchResult;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherServiceTest {
    private WeatherGateway gateway = mock(WeatherGateway.class);

    @org.junit.jupiter.api.Test
    public void getWeatherByCityName() throws Exception {

        when(gateway.findCityByName(anyString())).thenReturn(createSearchResult());
        when(gateway.getWeatherByWoeid(anyString())).thenReturn(createTestForecast());

        WeatherService service = new WeatherService(gateway);
        String weatherInBerlin = service.getWeatherByCityName("Berlin").get();
        assertEquals("25", weatherInBerlin);
    }
    private SearchResult[] createSearchResult() {
        SearchResult result = new SearchResult("1234");
        SearchResult [] results = {result};
        return results;
    }

    private Forecast createTestForecast() {
        ConsolidatedWeather weather = new ConsolidatedWeather("25");
        ConsolidatedWeather [] results = {weather};
        Forecast forecast = new Forecast(results);
        return forecast;
    }
}