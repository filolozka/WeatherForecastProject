package Application;

import Services.InputOutputService;
import Services.WeatherGateway;
import Services.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
        String result = weatherService.getWeatherByCityName(s);
        inputOutputService.printToConsole(result);
        log.info("Finished");
    }

    public static void main(String[] args) {
        InputOutputService inputOutput = new InputOutputService();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        WeatherGateway weatherGateway = new WeatherGateway(objectMapper);
        WeatherService weatherService = new WeatherService(weatherGateway);
        ForecastApp app = new ForecastApp(inputOutput, weatherService);
        try {
            app.execute();
        }
        catch (Exception ex){
            ex.printStackTrace();
            log.info("Expected exception");
        }
    }
}
