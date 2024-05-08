package Sweater.actions;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.substring;
import static io.gatling.javaapi.http.HttpDsl.http;

public class Subscribe {

    public ChainBuilder subscribe() {
        return exec(
                http("[GET]_user/subscribe")
                        .get("/user/subscribe/#{user}")
                        .check(substring("Unsubscribe"))
        );
    }

    public ChainBuilder unsubscribe() {
        return exec(
                http("[GET]_user/unsubscribe")
                        .get("/user/unsubscribe/#{user}")
                        .check(substring("Subscribe"))
        );
    }
}
