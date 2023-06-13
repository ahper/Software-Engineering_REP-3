package model.handlers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import model.ActionChain;
import model.Machine;
import model.Player;

import java.util.Optional;

public class NegativeHandler extends Handler {
    public NegativeHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean handle(int type, Player player, Machine machine) {
        if (type != ActionChain.StateEnum.LOSS.ordinal()) {
            return getNextHandler().handle(type, player, machine);
        } else {
            player.removeNumber(1);
            machine.addNumber(1);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Вы проиграли!");
            alert.setHeaderText("Монетка потеряна, но всегда можно отыграться!");

            ButtonType replay = new ButtonType("Продолжить играть", ButtonBar.ButtonData.YES);
            ButtonType vacation = new ButtonType("Отдохнуть", ButtonBar.ButtonData.NO);

            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(replay, vacation);

            Optional<ButtonType> option = alert.showAndWait();

            return option.get().getButtonData() == ButtonBar.ButtonData.YES;
        }
    }
}