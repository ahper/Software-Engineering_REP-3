package model.handlers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import model.ActionChain;
import model.Machine;
import model.Player;

import java.util.Optional;

public class PositiveHandler extends Handler {
    public PositiveHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean handle(int type, Player player, Machine machine) {
        if (type != ActionChain.StateEnum.SUCCESS.ordinal()) {
            return getNextHandler().handle(type, player, machine);
        } else {
            player.addNumber(1);
            machine.removeNumber(1);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Вы выиграли!");
            alert.setHeaderText("Поздравляем!");

            ButtonType continueGame = new ButtonType("Продолжить игру", ButtonBar.ButtonData.YES);
            ButtonType claim = new ButtonType("Забрать выигрыш", ButtonBar.ButtonData.NO);

            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(continueGame, claim);

            Optional<ButtonType> option = alert.showAndWait();

            return option.get().getButtonData() == ButtonBar.ButtonData.YES;
        }
    }
}
