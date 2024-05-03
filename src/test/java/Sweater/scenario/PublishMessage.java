package Sweater.scenario;

import Sweater.actions.Login;
import Sweater.actions.MainPage;
import Sweater.actions.SendMessage;
import io.gatling.javaapi.core.ScenarioBuilder;


import static io.gatling.javaapi.core.CoreDsl.scenario;

public class PublishMessage {

    public static ScenarioBuilder scn = scenario("Publish New Message")
            .exec(new Login().login())
            .exec(new MainPage().open())
            .exec(new SendMessage().send());
}
