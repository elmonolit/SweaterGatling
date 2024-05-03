package Sweater.actions;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.regex;
import static io.gatling.javaapi.http.HttpDsl.http;

public class MainPage {

    public ChainBuilder open(){
        return exec(http("[GET]_/login").get("/login").check(
                regex("_csrf\" value=\"(.*?)\"")
                        .find(0)
                        .saveAs("csrf")
        ));
    }
}
