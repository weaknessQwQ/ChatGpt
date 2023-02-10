package com.acautomaton.ChatGpt.Chat.Utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import com.acautomaton.ChatGpt.Chat.Pages.Utils.ErrorStage;

import java.util.HashMap;
import java.util.Map;

public class ChatAction
{
    public static String create(String question)
    {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        JSONObject json = new JSONObject();
        json.set("model", "text-davinci-003");
        json.set("prompt", question);
        json.set("temperature", 1);
        json.set("max_tokens", 2048);
        json.set("frequency_penalty", 0.0);
        json.set("presence_penalty", 0.0);

        String repeat = "";

        try (HttpResponse response = HttpRequest.post("https://api.openai.com/v1/completions")
                .headerMap(headers, false)
                .bearerAuth(Global.userData.getApiKey())
                .body(String.valueOf(json))
                .timeout(5 * 60 * 1000)
                .execute())
        {
            JSONObject resultBody = new JSONObject(response.body());
            String resultChoices = resultBody.get("choices").toString();
            resultChoices = resultChoices.substring(1, resultChoices.length() - 1);
            JSONObject resultChat = new JSONObject(resultChoices);
            repeat = resultChat.get("text").toString();
            repeat.trim();
        }
        catch (Exception e)
        {
            ErrorStage errorStage = new ErrorStage();
            errorStage.create();
        }
        return repeat;
    }
}
