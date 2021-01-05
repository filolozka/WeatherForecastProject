package Application;

import Services.InputOutputService;
import Services.WeatherGateway;
import Services.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

    @Bean
    public WeatherGateway weatherGateway(ObjectMapper mapper){
        return new WeatherGateway(mapper);
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }


    @Bean
    public InputOutputService inputOutputService() {
        return new InputOutputService();
    }

    @Bean
    public WeatherService weatherService(WeatherGateway gateway){
        return new WeatherService(gateway);
    }

    @Bean
    public ForecastApp forecastapp(InputOutputService inputOutputService, WeatherService weatherService){
        return new ForecastApp(inputOutputService, weatherService);
    }
}
