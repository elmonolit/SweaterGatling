package Sweater.scenario;

import Sweater.actions.Like;
import Sweater.actions.Login;
import Sweater.actions.Logout;
import Sweater.actions.MainPage;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class LikeMessage {

    public static ScenarioBuilder scn = scenario("Like Message").group("Like Message")
            .on(
                    exec(new Login().login())
                            .exec(new MainPage().open())
                            .exec(new Like().like())
                            .exec(new Logout().logout())
            );
}
