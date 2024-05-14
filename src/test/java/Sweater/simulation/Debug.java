package Sweater.simulation;

import Sweater.scenario.LikeMessage;
import Sweater.scenario.Pagination;
import Sweater.scenario.PublishMessage;
import Sweater.scenario.SubscribeScenario;
import io.gatling.core.structure.PopulationBuilder;
import io.gatling.javaapi.core.OpenInjectionStep;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import javax.annotation.Nonnull;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static ru.tinkoff.gatling.javaapi.Transactions.*;
import ru.tinkoff.gatling.transactions.Predef.*;
import scala.collection.immutable.Seq;

//import static io.gatling.javaapi.core.CoreDsl.*;

public class Debug extends SimulationWithTransactions {

//    {
//        setUp(
////                PublishMessage.scn.injectOpen(
////                        atOnceUsers(1)),
//                Pagination.scn.injectOpen(
////                        atOnceUsers(1)
//                        constantUsersPerSec(2).during(60)
//                )//,
////                LikeMessage.scn.injectOpen(
////                        atOnceUsers(1)
////                ),
////                SubscribeScenario.scn.injectOpen(
////                        atOnceUsers(1)
////                )
//        ).protocols(httpProtocol);
//    }
//{
//    setUp(Pagination.scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
//}
protected HttpProtocolBuilder httpProtocol = http
//            .proxy(Proxy("localhost", 8888))
        .baseUrl("http://192.168.188.231:8089")
        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
        .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:125.0) Gecko/20100101 Firefox/125.0");

    setUp(
            DebugScenario.scn.inject(atOnceUsers(1))
            ).protocols(dataBase)
}
