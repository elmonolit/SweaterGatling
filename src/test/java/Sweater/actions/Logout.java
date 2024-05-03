package Sweater.actions;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.http.HttpDsl.http;

public class Logout {
    public ChainBuilder logout(){
        return exec(
          http("[POST]_/logout")
            .post("/logout")
            .formParam("_csrf", "#{csrf}")
        );
    }
}
