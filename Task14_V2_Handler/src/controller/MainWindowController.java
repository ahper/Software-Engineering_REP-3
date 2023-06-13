package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ActionChain;
import model.Machine;
import model.Player;
import model.handlers.ChanceHandler;
import model.handlers.Handler;
import model.handlers.NegativeHandler;
import model.handlers.PositiveHandler;

public class MainWindowController {
    @FXML Pane paneGame;
    @FXML private ImageView view1, view2, view3;
    @FXML private Label lblPlayerNickname, lblPlayerBalance, lblMachineBalance;
    @FXML private Button btnStart, btnEnd;
    private Handler handler;
    private Player player;
    private Machine machine;

    public void initialize() {
        paneGameTransparent(false);
        player = new Player("ahper", 10);
        machine = new Machine(10);
        handler = new PositiveHandler(new NegativeHandler(new ChanceHandler(null)));
        paneUpdatingInfo();
    }

    @FXML
    public void onBtnStartClicked() {
        if (!init()) return;
        paneGameTransparent(true);
    }

    @FXML
    public void onBtnEndClicked() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Конец игры");
        alert.setHeaderText("Кто не рискует, тот не пьет шампанского. Возвращайся!");
        alert.showAndWait();

        Stage stage = (Stage) btnEnd.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onViewClicked() {
        if (!init()) return;
        boolean continueGame = handler.handle(ActionChain.getRandomEnumValue(), player, machine);
        if (!continueGame) {
            paneGameTransparent(false);
        }
        paneUpdatingInfo();
    }

    private boolean init() {
        if (!player.isCorrectPay(1)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Средств на счете недостаточно, еще монетку плисс!");
            alert.show();
            player.addNumber(1);
            return false;
        }
        else if (!machine.isCorrectPay(1)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Вы обанкротили автомат!");
            alert.show();
            machine.addNumber(1);
            return false;
        }
        else return true;
    }

    private void paneGameTransparent(boolean isGame){
        if (isGame){
            paneGame.setDisable(false);
            view1.setVisible(true);
            view2.setVisible(true);
            view3.setVisible(true);
            btnStart.setDisable(true);
        } else {
            paneGame.setDisable(true);
            view1.setVisible(false);
            view2.setVisible(false);
            view3.setVisible(false);
            btnStart.setDisable(false);
        }
    }

    private void paneUpdatingInfo(){
        lblPlayerNickname.setText("Nickname: " + player.getName());
        lblPlayerBalance.setText("Balance: " + player.getBalance());
        lblMachineBalance.setText("Balance: " + machine.getBalance());
    }
}
