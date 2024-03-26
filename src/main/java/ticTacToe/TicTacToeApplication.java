package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    @Override
    public void start(Stage window) throws Exception {
        Game game = new Game();

        Label info = new Label("Turn: X");

        StackPane infoLayout = new StackPane();
        infoLayout.setPrefSize(100, 60);
        infoLayout.getChildren().add(info);
        infoLayout.setAlignment(Pos.CENTER);

        BorderPane layout = new BorderPane();
        layout.setTop(infoLayout);

        GridPane field = new GridPane();
        field.setPrefSize(300, 180);
        field.setAlignment(Pos.CENTER);
        field.setVgap(10);
        field.setHgap(10);
        field.setPadding(new Insets(10));

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Button btn = new Button(game.status(x, y));
                btn.setFont(Font.font("Monospaced", 40));

                field.add(btn, x, y);

                int rx = x;
                int ry = y;
                btn.setOnMouseClicked((event) -> {
                    if (game.gameOver()) {
                        return;
                    }

                    game.place(rx, ry);
                    btn.setText(game.status(rx, ry));
                    game.changeTurn();
                    info.setText("Turn: " + game.getTurn());

                    if (game.gameOver()) {
                        info.setText("The end!");
                    }

                });
            }
        }
        layout.setCenter(field);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
