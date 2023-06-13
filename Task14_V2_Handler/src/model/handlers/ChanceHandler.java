package model.handlers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import model.ActionChain;
import model.Machine;
import model.Player;

import java.util.Optional;

public class ChanceHandler extends Handler {
    public ChanceHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean handle(int type, Player player, Machine machine) {
        if (type != ActionChain.StateEnum.CHANCE.ordinal()) {
            return getNextHandler().handle(type, player, machine);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Вы проиграли!");
            alert.setHeaderText("Но судьба дает Вам шанс сыграть еще раз бесплатно!");

            ButtonType replay = new ButtonType("Сыграть еще раз", ButtonBar.ButtonData.YES);
            ButtonType quit = new ButtonType("Закончить игру", ButtonBar.ButtonData.NO);

            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(replay, quit);

            Optional<ButtonType> option = alert.showAndWait();

            return option.get().getButtonData() == ButtonBar.ButtonData.YES;
        }
    }
}