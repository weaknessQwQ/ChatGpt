package com.acautomaton.ChatGpt.Chat.Pages.Token;

import com.acautomaton.ChatGpt.Chat.Home;
import com.acautomaton.ChatGpt.Chat.Utils.Global;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Objects;

public class AddTokenStage
{
    public void run()
    {
        Stage stage = new Stage();
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox);
        stage.setScene(scene);

        stage.setWidth(400);
        stage.setHeight(200);
        stage.setX(Home.getStage().getX() + (Home.getStage().getWidth() - stage.getWidth()) / 2);
        stage.setY(Home.getStage().getY() + (Home.getStage().getHeight() - stage.getHeight()) / 2);
        stage.setTitle("Set Token / 设置Token");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/static/ico/ChatGpt.png"))));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Home.getStage());
        stage.setResizable(false);


        Label labelEn = new Label("Please input API key");
        Label labelCh = new Label("请输入API密匙");
        TextField textField = new TextField();
        Button button = new Button("Confirm / 确认");
        button.setCursor(Cursor.HAND);
        vBox.getChildren().addAll(labelEn, labelCh, textField, button);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-font-size: 14");
        vBox.setPadding(new Insets(0,20,0,20));

        button.setOnAction(event ->
        {
            Global.userData.setApiKey(textField.getText());
            stage.close();
        });

        stage.show();
    }
}
