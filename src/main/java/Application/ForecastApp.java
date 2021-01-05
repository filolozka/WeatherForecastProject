package Application;

import Services.InputOutputService;
import Services.WeatherGateway;
import Services.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Optional;

public class ForecastApp {
    private InputOutputService inputOutputService;
    private WeatherService weatherService;
    protected static final Logger log = LogManager.getLogger(ForecastApp.class);


    public ForecastApp(InputOutputService inputOutputService, WeatherService weatherService) {
        this.inputOutputService = inputOutputService;
        this.weatherService = weatherService;
    }

    public void execute() throws Exception {
        log.info("Started");
        String s = inputOutputService.keyboardInput();
        Optional<String> weatherByCityName = weatherService.getWeatherByCityName(s);
        if (weatherByCityName.isPresent()) {
            inputOutputService.printToConsole(weatherByCityName.get());
        } else {
            inputOutputService.printToConsole("No result for city " + s);
            log.info("City not found");
        }
        log.info("Finished");
}


    public static void main(String[] args) throws Exception {
        /*InputOutputService inputOutput = new InputOutputService();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        WeatherGateway weatherGateway = new WeatherGateway(objectMapper);
        WeatherService weatherService = new WeatherService(weatherGateway);
        ForecastApp app = new ForecastApp(inputOutput, weatherService);
        */

        ApplicationContext context = new AnnotationConfigApplicationContext("Config.class");
        ForecastApp app = (ForecastApp) context.getBean("forecastapp");
        app.execute();
    }
}
