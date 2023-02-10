package com.acautomaton.ChatGpt.Chat.Pages.Utils;

import com.acautomaton.ChatGpt.Chat.Home;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Objects;

public class ErrorStage
{
    public void create()
    {
        Stage stage = new Stage();
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox);
        stage.setScene(scene);

        stage.setWidth(400);
        stage.setHeight(175);
        stage.setX(Home.getStage().getX() + (Home.getStage().getWidth() - stage.getWidth()) / 2);
        stage.setY(Home.getStage().getY() + (Home.getStage().getHeight() - stage.getHeight()) / 2);
        stage.setTitle("Error / 错误");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/static/ico/ChatGpt.png"))));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Home.getStage());
        stage.setResizable(false);


        Label labelEn = new Label("Wrong API key or Account is in arrears!");
        Label labelCh = new Label("API密匙错误或账户已欠费!");
        Button button = new Button("Confirm / 确认");
        button.setCursor(Cursor.HAND);
        vBox.getChildren().addAll(labelEn, labelCh, button);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-font-size: 14");
        vBox.setPadding(new Insets(0,20,0,20));

        button.setOnAction(event -> stage.close());

        stage.show();
    }
}
