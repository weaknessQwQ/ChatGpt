package com.acautomaton.ChatGpt.Chat.Pages.Chat;

import com.acautomaton.ChatGpt.Chat.Home;
import com.acautomaton.ChatGpt.Chat.Utils.ChatAction;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;

public class ChatPane
{
    public void createChat()
    {
        VBox vBox = new VBox();
        Home.getVBoxHome().getChildren().add(vBox);

        ScrollPane scrollPane = new ScrollPane();
        HBox hBoxMid = new HBox();
        Label labelTips = new Label("在此输入你想问的问题: / Input question here:");
        RadioButton radioButton = new RadioButton("保持聊天框滚动到最底部 / Always Bottom");
        hBoxMid.setSpacing(40);
        hBoxMid.getChildren().addAll(labelTips, radioButton);
        labelTips.setStyle("-fx-font-size: 15");
        TextArea textArea = new TextArea();
        textArea.setFocusTraversable(true);
        HBox hBoxBottom = new HBox();
        vBox.getChildren().addAll(scrollPane, hBoxMid, textArea, hBoxBottom);
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(20);

        Button buttonSend = new Button("发送");
        buttonSend.setCursor(Cursor.HAND);
        buttonSend.setStyle("-fx-font-size: 15");
        buttonSend.setDefaultButton(false);
        hBoxBottom.getChildren().addAll(buttonSend);
        hBoxBottom.setAlignment(Pos.CENTER);

        scrollPane.setPrefHeight(Home.getStage().getHeight() * 0.5);
        textArea.setPrefHeight(Home.getStage().getHeight() * 0.3);
        hBoxBottom.setPrefHeight(Home.getStage().getHeight() * 0.1);

        VBox vBoxChat = new VBox();
        vBoxChat.setPrefWidth(Home.getStage().getWidth() - 60);
        scrollPane.setContent(vBoxChat);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setBorder(Border.EMPTY);

        vBoxChat.getChildren().add(ChatDot.create("你好,我是ChatGpt!", 1));

        buttonSend.setOnAction(event ->
        {
            buttonSend.setDisable(true);
            vBoxChat.getChildren().add(ChatDot.create(textArea.getText(), 2));
            vBoxChat.getChildren().add(ChatDot.create(ChatAction.create(textArea.getText()), 1));
            buttonSend.setDisable(false);
            textArea.setText("");
        });

        AtomicReference<Timer> timer = new AtomicReference<>(new Timer());
        radioButton.selectedProperty().addListener((observableValue, aBoolean, t1) ->
        {
            if (t1)
            {
                timer.set(new Timer());
                timer.get().schedule(new TimerTask()
                {
                    @Override
                    public void run()
                    {
                        scrollPane.setVvalue(1.0);
                    }
                }, new Date(), 100);
            }
            else
            {
                timer.get().cancel();
            }
        });
        radioButton.setSelected(true);
    }
}