package Sweater.simulation;

import Sweater.scenario.LikeMessage;
import Sweater.scenario.Pagination;
import Sweater.scenario.PublishMessage;
import Sweater.scenario.SubscribeScenario;
import io.gatling.javaapi.core.OpenInjectionStep;
import io.gatling.javaapi.core.PopulationBuilder;

import javax.annotation.Nonnull;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;

public class Debug extends SimulationRoot{
      {
	  setUp(
              PublishMessage.scn.injectOpen(
                      atOnceUsers(1)),
              Pagination.scn.injectOpen(
                      atOnceUsers(1)
              ),
              LikeMessage.scn.injectOpen(
                      atOnceUsers(1)
              ),
              SubscribeScenario.scn.injectOpen(
                      atOnceUsers(1)
              )
      ).protocols(httpProtocol);
  }

}
