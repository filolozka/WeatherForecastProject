package Services;

import java.util.Scanner;

public class InputOutputService {
    private Scanner scanner;

    public InputOutputService() {
        this.scanner = new Scanner(System.in);
    }

    public String keyboardInput(){
        System.out.println("Please write the name of the city");
        String input = scanner.nextLine();
        return input;
    }

    public void printToConsole(String output){
            System.out.println(output);
    }
}
