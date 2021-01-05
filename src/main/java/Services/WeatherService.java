package Services;

import Entities.Forecast;
import Entities.SearchResult;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;

import static java.util.Optional.*;

public class WeatherService {
    private WeatherGateway gateway;
    protected static final Logger log = LogManager.getLogger(WeatherService.class);

    public WeatherService(WeatherGateway gateway){
        this.gateway = gateway;
    }

    public Optional<String> getWeatherByCityName(String cityName) throws Exception {
        SearchResult[] cityByName = gateway.findCityByName(cityName);
        if (cityByName.length == 0) {
            log.info("No results for " + cityName);
            return Optional.empty();
        }
        Forecast forecast = gateway.getWeatherByWoeid(cityByName[0].getWoeid());
        return Optional.of(forecast.getConsolidatedWeather()[0].getTheTemp());
    }
}
