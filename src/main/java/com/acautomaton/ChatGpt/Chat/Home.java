package com.acautomaton.ChatGpt.Chat;

import com.acautomaton.ChatGpt.Chat.Menus.TokenMenu;
import com.acautomaton.ChatGpt.Chat.Pages.Chat.ChatPane;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.Objects;

public class Home extends Application
{
    private static final Stage stage = new Stage();
    private static final MenuBar menuBar = new MenuBar();
    private static final VBox vBoxHome = new VBox();

    @Override
    public void start(Stage primarystage)
    {
        stage.setWidth(700);
        stage.setHeight(700);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);
        stage.setResizable(false);
        stage.setTitle("ChatGpt by ac-automaton");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/static/ico/ChatGpt.png"))));

        Scene scene = new Scene(vBoxHome);
        stage.setScene(scene);
        vBoxHome.getChildren().add(menuBar);

        TokenMenu.create();
        ChatPane chatPane = new ChatPane();
        chatPane.createChat();

        stage.show();
    }

    public static Stage getStage()
    {
        return stage;
    }

    public static MenuBar getMenuBar()
    {
        return menuBar;
    }

    public static VBox getVBoxHome()
    {
        return vBoxHome;
    }
}
