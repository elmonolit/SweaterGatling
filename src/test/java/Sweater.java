import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import Sweater.scenario.PublishMessage;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class Sweater extends Simulation {

  private HttpProtocolBuilder httpProtocol = http.proxy(Proxy("localhost", 8888))
    .baseUrl("http://192.168.188.245:8089")
//    .inferHtmlResources(AllowList(".*192.168.188.245.*"), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:125.0) Gecko/20100101 Firefox/125.0");
//
//  private Map<CharSequence, String> headers_0 = Map.of("Upgrade-Insecure-Requests", "1");
//
//  private Map<CharSequence, String> headers_1 = Map.ofEntries(
//    Map.entry("Origin", "http://192.168.188.245:8089"),
//    Map.entry("Upgrade-Insecure-Requests", "1")
//  );
//
//  private Map<CharSequence, String> headers_3 = Map.of("Accept", "image/avif,image/webp,*/*");
//
//  private Map<CharSequence, String> headers_5 = Map.ofEntries(
//    Map.entry("Content-Type", "multipart/form-data; boundary=---------------------------427800691813707132044007791432"),
//    Map.entry("Origin", "http://192.168.188.245:8089"),
//    Map.entry("Upgrade-Insecure-Requests", "1")
//  );
//
//
//  private ScenarioBuilder scn = scenario("Sweater")
//    .exec(
//      http("request_0")
//        .get("/")
//        .headers(headers_0).check(regex("_csrf\\\" value=\\\"(.*?)\\\"").find(0).saveAs("csrf"))
//    )
//    .exec(
//      http("request_1")
//        .post("/logout")
//        .headers(headers_1)
//        .formParam("_csrf", "#{csrf}")
//    )
//    .exec(
//      http("request_2")
//        .post("/login")
//        .headers(headers_1)
//        .formParam("username", "lanitUser1")
//        .formParam("password", "123")
//        .formParam("_csrf", "#{csrf}")
//        .resources(
//          http("request_3")
//            .get("/login")
//            .headers(headers_3)
//        )
//    )
//    .exec(
//      http("request_4")
//        .get("/main").check(regex("_csrf\\\" value=\\\"(.*?)\\\"").find(0).saveAs("csrf"))
//        .headers(headers_0)
//    )
//    .exec(
//      http("request_5")
//        .post("/main")
//        .headers(headers_5)
//        .body(RawFileBody("sweater/send_message.html"))
//    )
//    .exec(
//      http("request_6")
//        .post("/logout")
//        .headers(headers_1)
//        .formParam("_csrf", "b4491ce3-6aee-4bd4-893a-19b3cb62f449")
//    );

  {
	  setUp(
              PublishMessage.scn.injectOpen(
                      atOnceUsers(1)
              )
      ).protocols(httpProtocol);
  }
}
