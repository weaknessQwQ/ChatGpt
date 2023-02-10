package com.acautomaton.ChatGpt.Chat.Pages.Chat;

import com.acautomaton.ChatGpt.Chat.Home;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatDot
{
    public static VBox create(String message, int model)
    {
        VBox vBox = new VBox();
        Label label = new Label();
        Text text = new Text();
        text.setWrappingWidth((Home.getStage().getWidth() - 60) / 2);
        text.setStyle("-fx-font-size: 14");
        vBox.getChildren().addAll(label, text);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (model == 1)
        {
            label.setText("ChatGpt " + simpleDateFormat.format(new Date()));
            text.setText(message);
            vBox.setAlignment(Pos.CENTER_LEFT);
        }
        else if (model == 2)
        {
            label.setText("Me " + simpleDateFormat.format(new Date()));
            text.setText(message);
            vBox.setAlignment(Pos.CENTER_RIGHT);
            text.setTextAlignment(TextAlignment.RIGHT);
        }

        return vBox;
    }
}
