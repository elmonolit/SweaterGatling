package Sweater;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.doIf;
import static io.gatling.javaapi.core.CoreDsl.exec;

public class Utils {
    public static ChainBuilder customMessage(String message){
        return doIf(session -> session.isFailed()).then(exec(session -> {
            System.out.println(message);
            return session;
        }));
    }
}
