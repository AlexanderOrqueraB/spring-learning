package aorquerab;

import aorquerab.model.Exercise;
import aorquerab.model.enums.TypeCardio;
import aorquerab.model.restClientExample.User;
import aorquerab.model.restClientExample.UserRestClient;
import aorquerab.repository.ExerciseRepositoryOld;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//Here is where the commandLineRunner is executed
		log.info("Something has change during execution");
	}

	//This bean runs after the application started && after the application context has been created
//	@Bean
//	CommandLineRunner runner () {
//		return args -> {
//			log.info("Executing commandLineRunner");
//			Exercise ex1 = new Exercise(1,"Bench press",5,5, LocalDateTime.now(), TypeCardio.STEP);
//			log.info("Exercise: " + ex1);
//		};
//	}

	//To insert data using CommandLineRunner and the RepositoryOld
//	@Bean
//	CommandLineRunner runner (ExerciseRepositoryOld exerciseRepositoryOld) {
//		return args -> {
//			log.info("Executing commandLineRunner");
//			Exercise ex1 = new Exercise(1,"Bench press",5,5, LocalDateTime.now(), TypeCardio.STEP);
//			log.info("Exercise: " + ex1);
//			exerciseRepositoryOld.addExercise(ex1);
//		};
//	}

	//Using UserRestClient
	@Bean
	CommandLineRunner runner (UserRestClient userRestClient) {
		return args -> {
			log.info("Executing commandLineRunner");
			List<User> users= userRestClient.findAll();
			User us1 = userRestClient.findUserById(1);

			log.info("User: " + us1);
		};
	}

}
