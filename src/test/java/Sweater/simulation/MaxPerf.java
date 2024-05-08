package Sweater.simulation;

import Sweater.scenario.LikeMessage;
import Sweater.scenario.Pagination;
import Sweater.scenario.PublishMessage;
import Sweater.scenario.SubscribeScenario;
import io.gatling.javaapi.core.PopulationBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.incrementUsersPerSec;

public class MaxPerf extends SimulationRoot{

    int steps = conf.getInt("mpSteps");
    int levelCuration = conf.getInt("levelDuration");
    int levelRampup = conf.getInt("levelRampup");

    private PopulationBuilder ladder(ScenarioBuilder scn, double increment, int steps, int levelDuration, int levelRampup){
        return scn.injectOpen(
                incrementUsersPerSec(increment)
                        .times(steps)
                        .eachLevelLasting(levelDuration)
                        .separatedByRampsLasting(30)
                        .startingFrom(0)
        );
    }

    {
        setUp(
                ladder(Pagination.scn, (double) conf.getInt("PaginationIntensivity")/3600, steps, levelCuration,levelRampup),
                ladder(PublishMessage.scn, (double) conf.getInt("PublishMessageIntensivity")/3600, steps, levelCuration, levelRampup),
                ladder(LikeMessage.scn, (double) conf.getInt("LikeIntensivity")/3600, steps, levelCuration, levelRampup),
                ladder(SubscribeScenario.scn, (double) conf.getInt("SubscribeIntensivity")/3600, steps, levelCuration, levelRampup)
        ).protocols(httpProtocol);

    }
}
