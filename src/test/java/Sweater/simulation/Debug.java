package Sweater.simulation;

import Sweater.scenario.Pagination;
import Sweater.scenario.SubscribeScenario;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.http.HttpDsl.Proxy;
import static io.gatling.javaapi.http.HttpDsl.http;

public class Debug extends Simulation {
        protected HttpProtocolBuilder httpProtocol = http
//            .proxy(Proxy("localhost", 8888))
            .baseUrl("http://192.168.188.231:8089")
            .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
            .acceptEncodingHeader("gzip, deflate")
            .acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
            .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:125.0) Gecko/20100101 Firefox/125.0");

        {
        setUp(
//                PublishMessage.scn.injectOpen(
//                        atOnceUsers(1)),
//                Pagination.scn.injectOpen(
////                        atOnceUsers(1)
//                        constantUsersPerSec(2).during(60)
//                )//,
//                LikeMessage.scn.injectOpen(
//                        atOnceUsers(1)
//                ),
                SubscribeScenario.scn.injectOpen(
                        atOnceUsers(1)
                )
        ).protocols(httpProtocol);
    }
//{
//    setUp(Pagination.scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
//}
//    {
//        setUp(
//                Pagination.scn.injectOpen(
//                        atOnceUsers(1)
//                        , constantUsersPerSec(2).during(60)
//                )
//        ).protocols(httpProtocol);
//    }
}
