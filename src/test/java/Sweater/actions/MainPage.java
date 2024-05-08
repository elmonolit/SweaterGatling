package Sweater.actions;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.Session;

import java.util.Random;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.regex;
import static io.gatling.javaapi.http.HttpDsl.http;

public class MainPage {
    public ChainBuilder open() {
        return exec(
                http("[GET]_/main")
                        .get("/main")
                        .check(
                                regex("data-id=\\\"(\\d+)\\\"").findRandom().saveAs("message")
                        )
                        .check(
                                regex("href=\\\"\\/user-messages\\/(\\d+)\\\"").findRandom().saveAs("user")
                        )
        );
    }

    public ChainBuilder openRandomPage() {
        int page = new Random().nextInt(10) + 1;
//        System.out.println(page);
        int size = 5;
        return exec(
                session -> {
                    Session newSession = session
                            .set("page", new Random().nextInt(10) + 1);
                    return newSession;
                }
        ).exec(
                http("[GET]_/main?page=__page__&size=__size__")
                        .get(String.format("/main?page=%s&size=%d", "#{page}", size))
        );
    }
}
