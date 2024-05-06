package Sweater.actions;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.Session;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

import Sweater.Utils;
import org.apache.commons.lang3.RandomStringUtils;


public class SendMessage {

    public Function<Session, Session> pp(){
        System.out.println("asssssss");
        return null;
    }

    public ChainBuilder send(){
        return
            exec(session -> {
                Session session1 = session
                        .set("tag", RandomStringUtils.randomAlphabetic(new Random().nextInt(20) + 3))
                        .set("text", RandomStringUtils.randomAlphabetic(new Random().nextInt(50) + 3));
                return session1;
            })
            .exec(
                    http("[POST]_/main")
                    .post("/main")
                    .headers(Map.ofEntries(
                                Map.entry(
                                        "Content-Type",
                                        "multipart/form-data; boundary=---------------------------427800691813707132044007791432"
                                )
                            ))
                    .body(ElFileBody("send_message.html"))
                    .check(substring("You've created a message with id:"))
    );
    }

}
