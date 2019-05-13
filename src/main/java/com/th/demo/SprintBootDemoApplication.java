package com.th.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.th.demo"})
@EnableSwagger2
public class SprintBootDemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(SprintBootDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SprintBootDemoApplication.class);
		Environment env = app.run(args).getEnvironment();
		logger.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application is running! Access URLs:\n\t" + "Local: \t\thttp://127.0.0.1:{}/{}\n\t"
						+ "\n----------------------------------------------------------",
				env.getProperty("server.port"),"swagger-ui.html");
	}
}
