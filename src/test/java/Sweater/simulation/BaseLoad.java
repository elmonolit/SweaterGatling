package Sweater.simulation;

import Sweater.scenario.LikeMessage;
import Sweater.scenario.Pagination;
import Sweater.scenario.PublishMessage;
import Sweater.scenario.SubscribeScenario;

import static io.gatling.javaapi.core.CoreDsl.*;

public class BaseLoad extends SimulationRoot {
    {
        setUp(
                PublishMessage.scn.injectOpen(
                        rampUsersPerSec(0).to((double) conf.getInt("PublishMessageIntensivity") / 3600)
                                .during(30),
                        constantUsersPerSec((double) conf.getInt("PublishMessageIntensivity") / 3600).during(300)
                ),
                Pagination.scn.injectOpen(
                        rampUsersPerSec(0).to((double) conf.getInt("PaginationIntensivity") / 3600)
                                .during(30),
                        constantUsersPerSec((double) conf.getInt("PaginationIntensivity") / 3600).during(300)
                ),
                LikeMessage.scn.injectOpen(
                        rampUsersPerSec(0).to((double) conf.getInt("LikeIntensivity") / 3600)
                                .during(30),
                        constantUsersPerSec((double) conf.getInt("LikeIntensivity") / 3600).during(300)
                ),
                SubscribeScenario.scn.injectOpen(
                        rampUsersPerSec(0).to((double) conf.getInt("SubscribeIntensivity") / 3600)
                                .during(30),
                        constantUsersPerSec((double) conf.getInt("SubscribeIntensivity") / 3600).during(300)
                )
        ).protocols(httpProtocol);
//                .assertions(
//                details("Publish New Message").responseTime().percentile3().lt(2000),
//                details("Like Message", "Pagination").responseTime().max().lt(3000)
//        );

    }
}
