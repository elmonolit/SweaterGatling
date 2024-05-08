package Sweater.scenario;

import Sweater.actions.Login;
import Sweater.actions.Logout;
import Sweater.actions.MainPage;
import Sweater.actions.SendMessage;
import io.gatling.javaapi.core.ScenarioBuilder;


import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class PublishMessage {

    //    public static ScenarioBuilder scn = scenario("Publish New Message").repeat(10).on(
//            exec(new Login().login(),
//                    new MainPage().open(),
//                    new SendMessage().send(),
//                    new Logout().logout())
//            );
    public static ScenarioBuilder scn = scenario("Publish New Message").group("Publish New Message").on(
            exec(new Login().login())
                    .exec(new SendMessage().send())
                    .exec(new Logout().logout()));

}
