package co.usa.ciclo3.ciclo3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@EnableConfigurationProperties
//@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)

@SpringBootTest
class Ciclo3ApplicationTests {

    @Test
	void contextLoads() {
	}

}
