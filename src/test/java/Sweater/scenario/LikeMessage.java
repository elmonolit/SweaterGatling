package Sweater.scenario;

import Sweater.actions.Like;
import Sweater.actions.Login;
import Sweater.actions.Logout;
import Sweater.actions.MainPage;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.scenario;
import static ru.tinkoff.gatling.javaapi.Transactions.endTransaction;
import static ru.tinkoff.gatling.javaapi.Transactions.startTransaction;

public class LikeMessage {

    public static ScenarioBuilder scn = scenario("Like Message")
//            .group("Like Message")
//            .on(
            .exec(startTransaction("Like_TC"))
            .exec(new Login().login())
            .exec(new MainPage().open())
            .exec(new Like().like())
            .exec(new Logout().logout())
            .exec(endTransaction("Like_TC"));
//            );
}
