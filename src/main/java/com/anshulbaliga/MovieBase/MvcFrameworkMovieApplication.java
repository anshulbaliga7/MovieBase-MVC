package com.anshulbaliga.MovieBase;

import com.anshulbaliga.MovieBase.model.entities.MovieEntity;
import com.anshulbaliga.MovieBase.model.entities.UserEntity;
import com.anshulbaliga.MovieBase.repository.MovieRepository;
import com.anshulbaliga.MovieBase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class MvcFrameworkMovieApplication {
	private final UserRepository userRepository;
	private final MovieRepository movieRepository;
//	private final ReviewRepository reviewRepository;

	@Autowired
	MvcFrameworkMovieApplication(UserRepository userRepository, MovieRepository movieRepository) {
		this.userRepository = userRepository;
		this.movieRepository = movieRepository;
//		this.reviewRepository = reviewRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(MvcFrameworkMovieApplication.class, args);
	}

	// using command line runner to run the code
	@Bean
	public CommandLineRunner run() {
		return args -> {
			System.out.println("Hello from MvcFrameworkMovieApplication built by Anshul Baliga PES1UG21CS095");

			UserEntity newUser = UserEntity.builder()
					.name("Anshul Baliga")
					.email("baligaanshul@gmail.com")
					.password("password")
					.build();

			UserEntity newUser2 = UserEntity.builder()
                .name("Anders Hejlsberg")
                .email("andershejl@gmail.com")
                .password("1234")
                .build();

			userRepository.save(newUser);
			userRepository.save(newUser2);

			movieRepository.saveAll(movies);
		
	
		};
	}

	private List<MovieEntity> movies = List.of(
			MovieEntity.builder()
					.title("Manchester by the Sea")
					.releaseDate(LocalDate.of(2016, 7, 18))
					.genre("Action, Horror, Romance, Drama")
					.director("Kenneth Lonergan")
					.averageRating(8.9)
					.build(),
			MovieEntity.builder()
					.title("Inglourious Basterds")
					.releaseDate(LocalDate.of(2009, 7, 16))
					.genre("Action, War, Horror")
					.director("Quentin Tarantino")
					.averageRating(8.6)
					.build(),
			MovieEntity.builder()
					.title("Interstellar")
					.releaseDate(LocalDate.of(2014, 11, 7))
					.genre("Adventure, Drama, Sci-Fi")
					.director("Christopher Nolan")
					.averageRating(8.5)
					.build()
	);
}
