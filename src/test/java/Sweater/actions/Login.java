package Sweater.actions;

import io.gatling.javaapi.core.ChainBuilder;

import java.util.Map;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.regex;
import static io.gatling.javaapi.http.HttpDsl.http;

public class Login {
    public ChainBuilder login() {
        ChainBuilder chain = exec(
                http("[GET]_/>")
                        .get("/")
                        .headers(Map.of("Upgrade-Insecure-Requests", "1"))
                        .check(
                                regex("_csrf\" value=\"(.*?)\"")
                                        .find(0)
                                        .saveAs("csrf")
                        )
        )
//            .exec(
//                    http("[POST]_/logout")
//                            .post("/logout")
//                            .headers(headers_1)
//                            .formParam("_csrf", "#{csrf}")
//            )
                .exec(
                        http("[POST]_/login")
                                .post("/login")
                                .headers(Map.ofEntries(
                                        Map.entry("Origin", "http://192.168.188.245:8089"),
                                        Map.entry("Upgrade-Insecure-Requests", "1")
                                ))
                                .formParam("username", "lanitUser1")
                                .formParam("password", "123")
                                .formParam("_csrf", "#{csrf}")
//                                .resources(
//                                        http("[GET]_/login")
//                                                .get("/login")
//                                )
                );
        return chain;
    };
}
