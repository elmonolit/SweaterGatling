import Sweater.scenario.LikeMessage;
import Sweater.scenario.Pagination;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import Sweater.scenario.PublishMessage;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class Sweater extends Simulation {

    Config conf = ConfigFactory.load("simulation.properties");

    @Override
    public void before() {
        System.out.println((double) conf.getInt("PublishMessageIntensivity")/3600);
    }

    private HttpProtocolBuilder httpProtocol = http
//            .proxy(Proxy("localhost", 8888))
    .baseUrl(conf.getString("baseUrl"))
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:125.0) Gecko/20100101 Firefox/125.0");


//  {
//	  setUp(
//              PublishMessage.scn.injectOpen(
//                      atOnceUsers(1)),
//              Pagination.scn.injectOpen(
//                      atOnceUsers(1)
//              ),
//              LikeMessage.scn.injectOpen(
//                      atOnceUsers(1)
//              )
//      ).protocols(httpProtocol);
//  }

  {
	  setUp(
            PublishMessage.scn.injectOpen(
                      rampUsersPerSec(0).to((double) conf.getInt("PublishMessageIntensivity")/3600)
                              .during(30),
                      constantUsersPerSec((double) conf.getInt("PublishMessageIntensivity")/3600).during(300),
                      rampUsersPerSec(0).to((double) conf.getInt("PublishMessageIntensivity")/3600 * 2)
                            .during(30),
                      constantUsersPerSec((double) conf.getInt("PublishMessageIntensivity")/3600 * 2).during(300)
              ),
            Pagination.scn.injectOpen(
                      rampUsersPerSec(0).to((double) conf.getInt("PaginationIntensivity")/3600)
                              .during(30),
                      constantUsersPerSec((double) conf.getInt("PaginationIntensivity")/3600).during(300),
                    rampUsersPerSec(0).to((double) conf.getInt("PaginationIntensivity")/3600 * 2)
                            .during(30),
                    constantUsersPerSec((double) conf.getInt("PaginationIntensivity")/3600 * 2).during(300)
              ),
            LikeMessage.scn.injectOpen(
                      rampUsersPerSec(0).to((double) conf.getInt("LikeIntensivity")/3600)
                              .during(30),
                      constantUsersPerSec((double) conf.getInt("LikeIntensivity")/3600).during(300),
                    rampUsersPerSec(0).to((double) conf.getInt("LikeIntensivity")/3600 * 2)
                            .during(30),
                    constantUsersPerSec((double) conf.getInt("LikeIntensivity")/3600 * 2).during(300)
              )
            ).protocols(httpProtocol).assertions(
                    details("Publish New Message").responseTime().percentile3().lt(2000),
                    details("Like Message", "Pagination").responseTime().max().lt(3000)
      );

  }
}
