package es.pedcod.main.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import lombok.extern.slf4j.Slf4j;

/*
 * This is the main Spring Boot application class. It configures Spring Context to server executions.
 */
@SpringBootApplication
@Slf4j
public class SpringBootRunner {

	/** 
	 * Instances of the class {@code RimareServerApplication} represent runner
	 */
	private static final Class<SpringBootRunner> runnerClass = SpringBootRunner.class;

	/**
	 * Starter spring context
	 * 
	 * @param arguments Attributes array needed to application execution
	 */
	public static void main(final String[] arguments) {
		new SpringApplicationBuilder(runnerClass)
			.build()
			.run(arguments);
		log.info("-=- SERVER STARTED -=-");
	}

}
