package tbd.pack;

import tbd.pack.test.TestConfiguration;

@GenerateSpringBeanConfiguration(
        configurations = {
                Muh.class,
                TestConfiguration.class,
        }
)
public class HelloWorld {
}
