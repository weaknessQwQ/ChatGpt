module ChatGpt {
    requires javafx.graphics;
    requires javafx.controls;
    requires lombok;
    requires hutool.all;
    requires java.sql;

    exports com.acautomaton.ChatGpt.Chat;
    exports com.acautomaton.ChatGpt.Chat.Pages.Chat;
}