package Sweater.actions;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.substring;
import static io.gatling.javaapi.http.HttpDsl.http;


public class Like {

    public ChainBuilder like(){
        return exec(
                http("[GET]_/messages/__id__/like")
                        .get("/messages/#{message}/like")
                        .check(substring("You've liked message"))
        );
    }
}
