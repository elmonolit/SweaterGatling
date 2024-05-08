import Sweater.actions.Like;
import Sweater.actions.Subscribe;
import Sweater.scenario.LikeMessage;
import Sweater.scenario.Pagination;
import Sweater.scenario.SubscribeScenario;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import Sweater.scenario.PublishMessage;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class Sweater  {
//
//    Config conf = ConfigFactory.load("simulation.properties");
//
//    @Override
//    public void before() {
//
//        System.out.println((double) conf.getInt("PublishMessageIntensivity")/3600);
//        System.out.println(conf.getString("baseUrl"));
//    }
//
//    private HttpProtocolBuilder httpProtocol = http
////            .proxy(Proxy("localhost", 8888))
////    .baseUrl(conf.getString("baseUrl"))
//    .baseUrl("http://192.168.188.245:8089")
//    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
//    .acceptEncodingHeader("gzip, deflate")
//    .acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
//    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:125.0) Gecko/20100101 Firefox/125.0");
//
//

//  {
//	  setUp(
//            PublishMessage.scn.injectOpen(
//                      rampUsersPerSec(0).to((double) conf.getInt("PublishMessageIntensivity")/3600)
//                              .during(30),
//                      constantUsersPerSec((double) conf.getInt("PublishMessageIntensivity")/3600).during(300),
//                      rampUsersPerSec(0).to((double) conf.getInt("PublishMessageIntensivity")/3600 * 2)
//                            .during(30),
//                      constantUsersPerSec((double) conf.getInt("PublishMessageIntensivity")/3600 * 2).during(300)
//              ),
//            Pagination.scn.injectOpen(
//                      rampUsersPerSec(0).to((double) conf.getInt("PaginationIntensivity")/3600)
//                              .during(30),
//                      constantUsersPerSec((double) conf.getInt("PaginationIntensivity")/3600).during(300),
//                    rampUsersPerSec(0).to((double) conf.getInt("PaginationIntensivity")/3600 * 2)
//                            .during(30),
//                    constantUsersPerSec((double) conf.getInt("PaginationIntensivity")/3600 * 2).during(300)
//              ),
//            LikeMessage.scn.injectOpen(
//                      rampUsersPerSec(0).to((double) conf.getInt("LikeIntensivity")/3600)
//                              .during(30),
//                      constantUsersPerSec((double) conf.getInt("LikeIntensivity")/3600).during(300),
//                    rampUsersPerSec(0).to((double) conf.getInt("LikeIntensivity")/3600 * 2)
//                            .during(30),
//                    constantUsersPerSec((double) conf.getInt("LikeIntensivity")/3600 * 2).during(300)
//              )
//            ).protocols(httpProtocol).assertions(
//                    details("Publish New Message").responseTime().percentile3().lt(2000),
//                    details("Like Message", "Pagination").responseTime().max().lt(3000)
//      );
//
//  }
//private PopulationBuilder ladder(ScenarioBuilder scn, double increment, int steps, int levelDuration, int levelRampup){
//    return scn.injectOpen(
//            incrementUsersPerSec(increment)
//                    .times(steps)
//                    .eachLevelLasting(levelDuration)
//                    .separatedByRampsLasting(30)
//                    .startingFrom(0)
//    );
//}
//
//  {
//	  setUp(
//            ladder(Pagination.scn, (double) conf.getInt("PaginationIntensivity")/3600, 1, 300,30),
//              ladder(PublishMessage.scn, (double) conf.getInt("PublishMessageIntensivity")/3600, 1, 300, 30),
//              ladder(LikeMessage.scn, (double) conf.getInt("LikeIntensivity")/3600, 1, 300, 30),
//              ladder(SubscribeScenario.scn, (double) conf.getInt("SubscribeIntensivity")/3600, 1, 300, 30)
//      ).protocols(httpProtocol);
//
//  }


}
