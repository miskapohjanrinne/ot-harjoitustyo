package jatkanshakki.ui;

import jatkanshakki.domain.Game;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Käyttöliittymä
 *
 */
public class UI extends Application {

    private Game game;
    private Scene gameScene;
    private GridPane gameButtons;
    private BorderPane setting;
    private ArrayList<Button> buttons;
    private Button shutDown;

    @Override
    public void start(Stage startScreen) {
        this.game = new Game();
        this.buttons = new ArrayList<>();
        this.gameButtons = new GridPane();
        this.shutDown = new Button("Sammuta peli");

        shutDown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.exit(0);
            }
        });

        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 15; j++) {
                int x = i;
                int y = j;
                this.buttons.add(new Button("   "));
                int buttonIndex = this.buttons.size() - 1;
                this.buttons.get(buttonIndex).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        String whoseTurnBefore = Character.toString(UI.this.game.getTurn());
                        if (UI.this.game.checkForWin()) {
                            return;
                        }
                        if (UI.this.game.mark(x, y)) {
                            UI.this.buttons.get(buttonIndex).setText(whoseTurnBefore);
                            if (UI.this.game.checkForWin()) {
                                UI.this.setting.setTop(new Label(whoseTurnBefore + " voitti, onneksi olkoon!"));
                                return;
                            }
                            String whoseTurnAfter = Character.toString(UI.this.game.getTurn());
                            UI.this.setting.setTop(new Label(whoseTurnAfter + ":n vuoro seuraavaksi"));
                        }
                    }
                });
                gameButtons.add(this.buttons.get(this.buttons.size() - 1), x, y);
            }
        }

        this.setting = new BorderPane();
        setting.setCenter(gameButtons);
        setting.setRight(shutDown);
        setting.setTop(new Label("Aloita peli painamalla jotakin ruutua, O aloittaa"));

        this.gameScene = new Scene(setting);

        startScreen.setTitle("Jätkänshakki");
        startScreen.setScene(gameScene);
        startScreen.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
