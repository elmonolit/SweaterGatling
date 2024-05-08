package Sweater.scenario;

import Sweater.actions.Login;
import Sweater.actions.MainPage;
import Sweater.actions.Subscribe;
import Sweater.actions.UserPage;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class SubscribeScenario {

    public static ScenarioBuilder scn = scenario("Subscribe")
            .group("Subscribe")
            .on(
                    exec(new Login().login())
                            .exec(new MainPage().open())
                            .exec(new UserPage().open())
                            .doIfEqualsOrElse("#{subscription}", "Subscribe")
                            .then(new Subscribe().subscribe())
                            .orElse(new Subscribe().unsubscribe())
            );
}
