package Sweater.scenario;

import Sweater.actions.Login;
import Sweater.actions.MainPage;
import Sweater.actions.Subscribe;
import Sweater.actions.UserPage;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.scenario;
import static ru.tinkoff.gatling.javaapi.Transactions.endTransaction;
import static ru.tinkoff.gatling.javaapi.Transactions.startTransaction;

public class SubscribeScenario {

    public static ScenarioBuilder scn = scenario("Subscribe")
//            .group("Subscribe")
//            .on(
            .exec(startTransaction("Subscribe_TC"))
            .exec(new Login().login())
            .exec(new MainPage().open())
            .exec(new UserPage().open())
            .doIfEqualsOrElse("#{subscription}", "Subscribe")
            .then(new Subscribe().subscribe())
            .orElse(new Subscribe().unsubscribe())
            .exec(endTransaction("Subscribe_TC"));
//            );

}
