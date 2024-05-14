package Sweater.simulation;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import ru.tinkoff.gatling.javaapi.influxdb.SimulationWithAnnotations;
import ru.tinkoff.gatling.transactions.Predef;

import static io.gatling.javaapi.http.HttpDsl.http;

public class SimulationRoot extends Simulation {
    Config conf = ConfigFactory.load("simulation.properties");

//    @Override
//    public void before() {
//
//        System.out.println((double) conf.getInt("PublishMessageIntensivity") / 3600);
//        System.out.println(conf.getString("baseUrl"));
//    }

    protected HttpProtocolBuilder httpProtocol = http
//            .proxy(Proxy("localhost", 8888))
            .baseUrl(conf.getString("baseUrl"))
            .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
            .acceptEncodingHeader("gzip, deflate")
            .acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
            .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:125.0) Gecko/20100101 Firefox/125.0");
}
