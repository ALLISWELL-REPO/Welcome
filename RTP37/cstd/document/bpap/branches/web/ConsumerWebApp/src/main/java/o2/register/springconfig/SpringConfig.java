package o2.register.springconfig;

import org.o2.register.svc.client.springclientconfig.SpringClientConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value="org.register.beans")
@Import(value={SpringClientConfig.class})
public class SpringConfig {

}
