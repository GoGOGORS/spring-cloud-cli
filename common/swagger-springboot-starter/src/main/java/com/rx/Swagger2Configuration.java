package com.rx;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-07-28 11:31}
 * {{@code @Description} @Description: }
 */



@Configuration
@ConditionalOnProperty(name = "rx.swagger.enabled", matchIfMissing = true)
@Import({
        Swagger2DocumentationConfiguration.class
})
public class Swagger2Configuration {


}
