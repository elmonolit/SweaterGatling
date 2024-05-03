package Sweater.actions;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.Session;

import java.util.Map;
import java.util.function.Function;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

import Sweater.Utils;




public class SendMessage {


    public Function<Session, Session> pp(){
        System.out.println("asssssss");
        return null;
    }

    public ChainBuilder send(){
        return
            exec(
      http("[POST]_/main")
        .post("/main")
        .headers(Map.ofEntries(
                Map.entry("Content-Type", "multipart/form-data; boundary=---------------------------427800691813707132044007791432")
        ))
        .body(ElFileBody("send_message.html"))
              .check(substring("You've created a message with id:"))
    );
    }

}
