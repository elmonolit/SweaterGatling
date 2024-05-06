package Sweater.actions;

import io.gatling.javaapi.core.ChainBuilder;

import java.util.Map;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

public class Login {
    public ChainBuilder login() {
        ChainBuilder chain = feed(csv("SweaterDebugUsers.csv").circular())
                .exec(
                    http("[GET]_/>")
                            .get("/")
                            .headers(Map.of("Upgrade-Insecure-Requests", "1"))
                            .check(
                                    regex("_csrf\" value=\"(.*?)\"")
                                            .find(0)
                                            .saveAs("csrf")
                            )
            )
                .exec(
                    http("[POST]_/login")
                            .post("/login")
                            .headers(Map.ofEntries(
                                    Map.entry("Origin", "http://192.168.188.245:8089"),
                                    Map.entry("Upgrade-Insecure-Requests", "1")
                            ))
                            .formParam("username", "#{login}")
                            .formParam("password", "#{pass}")
                            .formParam("_csrf", "#{csrf}")
                            .check(
                                    regex("_csrf\" value=\"(.*?)\"")
                                            .find(0)
                                            .saveAs("csrf")
                            )
            );
        return chain;
    };
}
