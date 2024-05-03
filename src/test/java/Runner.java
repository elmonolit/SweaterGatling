import io.gatling.app.Gatling;
import io.gatling.core.config.GatlingPropertiesBuilder;

public class Runner {
    public static void main(String[] args) {
        String simClass = Sweater.class.getName();

// get the properties for the class

        GatlingPropertiesBuilder props = new GatlingPropertiesBuilder();

        props.simulationClass(simClass);

        Gatling.fromMap(props.build());

    }
}
