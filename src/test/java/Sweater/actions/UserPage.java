package Sweater.actions;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.regex;
import static io.gatling.javaapi.http.HttpDsl.http;

public class UserPage {

    public ChainBuilder open() {
        return exec(
                http("[GET]_/user-messages/__user__")
                        .get("/user-messages/#{user}")
                        .check(
                                regex("a class=\\\"btn btn-info\\\" href=\\\"\\/user.*?>(.*?)<").find(0).saveAs("subscription")
                        )
        );
    }
}
