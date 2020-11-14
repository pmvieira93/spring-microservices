package pt.sample.ms.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringMsDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsDiscoveryServerApplication.class, args);
	}

}
