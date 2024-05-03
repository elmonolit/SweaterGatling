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

    private HttpProtocolBuilder httpProtocol = http.proxy(Proxy("localhost", 8888))
    .baseUrl("http://192.168.188.245:8089")
//    .inferHtmlResources(AllowList(".*192.168.188.245.*"), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:125.0) Gecko/20100101 Firefox/125.0");


//  {
//	  setUp(
//              PublishMessage.scn.injectOpen(
//                      atOnceUsers(1)
//              )
//      ).protocols(httpProtocol);
//  }

  {
	  setUp(
              PublishMessage.scn.injectOpen(
                      rampUsersPerSec(0).to((double) conf.getInt("PublishMessageIntensivity")/3600).during(60),
                      constantUsersPerSec((double) conf.getInt("PublishMessageIntensivity")/3600).during(300)
              )
      ).protocols(httpProtocol);
  }
}
