package tbd.pack.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tbd.pack.test.poc.FirstComponent;

@Configuration
@ComponentScan(
        basePackageClasses = {
                FirstComponent.class,
        }
)
public class TestConfiguration {
}
