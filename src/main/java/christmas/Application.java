package christmas;

import christmas.controller.MainController;
import christmas.view.input.InputDtoConverter;
import christmas.view.input.InputView;
import christmas.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new InputDtoConverter());
        OutputView outputView = new OutputView();
        MainController mainController = new MainController(inputView, outputView);
        mainController.run();
    }
}