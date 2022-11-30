package location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackageClasses = AppConfig.class)
@EnableAspectJAutoProxy
public class AppConfig {

    @Autowired
    private Environment environment;


}
