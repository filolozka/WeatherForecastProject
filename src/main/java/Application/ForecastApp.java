package Application;

import Services.InputOutputService;
import Services.WeatherGateway;
import Services.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ForecastApp {
    private InputOutputService inputOutputService;
    private WeatherService weatherService;

    public ForecastApp(InputOutputService inputOutputService, WeatherService weatherService) {
        this.inputOutputService = inputOutputService;
        this.weatherService = weatherService;
    }

    public void execute() throws Exception {
        String s = inputOutputService.keyboardInput();
        String result = weatherService.getWeatherByCityName(s);
        inputOutputService.printToConsole(result);
    }

    public static void main(String[] args) {
        InputOutputService inputOutput = new InputOutputService();
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherGateway weatherGateway = new WeatherGateway(objectMapper);
        WeatherService weatherService = new WeatherService(weatherGateway);

        ForecastApp app = new ForecastApp(inputOutput, weatherService);
        try {
            app.execute();
        }
        catch (Exception ex){
            System.out.println("Error: " + ex);
        }
    }
}
