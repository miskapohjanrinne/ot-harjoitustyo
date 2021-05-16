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
    private Scene game_scene;
    private GridPane game_buttons;
    private BorderPane setting;
    private ArrayList<Button> buttons;
    private Button shut_down;

    @Override
    public void start(Stage main_screen) {
        this.game = new Game();
        this.buttons = new ArrayList<>();
        this.game_buttons = new GridPane();
        this.shut_down = new Button("Sammuta peli");

        shut_down.setOnAction(new EventHandler<ActionEvent>() {
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
                game_buttons.add(this.buttons.get(this.buttons.size() - 1), x, y);
            }
        }

        this.setting = new BorderPane();
        setting.setCenter(game_buttons);
        setting.setRight(shut_down);
        setting.setTop(new Label("Aloita peli painamalla jotakin ruutua, O aloittaa"));

        this.game_scene = new Scene(setting);

        main_screen.setTitle("Jätkänshakki");
        main_screen.setScene(game_scene);
        main_screen.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
