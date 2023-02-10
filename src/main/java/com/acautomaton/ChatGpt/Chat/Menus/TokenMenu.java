package com.acautomaton.ChatGpt.Chat.Menus;

import com.acautomaton.ChatGpt.Chat.Home;
import com.acautomaton.ChatGpt.Chat.Pages.Token.AddTokenStage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class TokenMenu
{
    public static void create()
    {
        Menu menuToken = new Menu("token setting / token设置");
        Home.getMenuBar().getMenus().add(menuToken);

        MenuItem menuItemAdd = new Menu("Add token / 添加token");
        menuToken.getItems().add(menuItemAdd);

        menuItemAdd.setOnAction(event ->
        {
            AddTokenStage addTokenStage = new AddTokenStage();
            addTokenStage.run();
        });
    }
}
