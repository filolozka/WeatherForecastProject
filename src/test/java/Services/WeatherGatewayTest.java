package Services;

import Entities.Forecast;
import Entities.SearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import junit.framework.TestCase;

public class WeatherGatewayTest extends TestCase {

    public void testFindCityByName() throws Exception {
        WeatherGateway gateway = new WeatherGateway(new ObjectMapper());
        SearchResult[] berlins = gateway.findCityByName("Berlin");

        assertTrue(berlins.length == 1);
    }

    public void testGetWeatherByWoeid() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        WeatherGateway gateway = new WeatherGateway(mapper);
        Forecast weatherByWoeid = gateway.getWeatherByWoeid("638242");
        System.out.println(weatherByWoeid);
    }
}