package jatkanshakki.ui;

import jatkanshakki.domain.Game;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

/**
 * Käyttöliittymä
 *
 */
public class UI extends Application {

    private Game game;
    private Scene gameScene;
    private GridPane gameButtons;
    private BorderPane setting;

    @Override
    public void start(Stage startScreen) {
        this.game = new Game();

        this.gameButtons = new GridPane();
        for (int x = 1; x <= 15; x++) {
            for (int y = 1; y <= 15; y++) {
                gameButtons.add(new Button("   "), x, y);
            }
        }

        this.setting = new BorderPane();
        setting.setCenter(gameButtons);

        this.gameScene = new Scene(setting);

        startScreen.setTitle("Jatkanshakki");
        startScreen.setScene(gameScene);
        startScreen.show();
    }

    public static void main(String[] args) {
        launch(UI.class);
    }

}
