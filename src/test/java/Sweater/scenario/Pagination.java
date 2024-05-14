package Sweater.scenario;

import Sweater.actions.Login;
import Sweater.actions.Logout;
import Sweater.actions.MainPage;
import io.gatling.javaapi.core.ScenarioBuilder;

import java.util.Random;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static ru.tinkoff.gatling.javaapi.Transactions.endTransaction;
import static ru.tinkoff.gatling.javaapi.Transactions.startTransaction;

public class Pagination {

    public static ScenarioBuilder scn = scenario("Pagination")
            .group("Pagination")
            .on(
                    exec(startTransaction("Pagination"))
                            .exec(new Login().login())
                            .exec(new MainPage().open())
                            .exec(new MainPage().openRandomPage())
                            .exec(new Logout().logout())
                            .exec(endTransaction("Pagination"))
            );
}
