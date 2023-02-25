package com.multiplex.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dto.MovieDTO;
import com.multiplex.dto.UserDTO;
import com.multiplex.entities.Movie;
import com.multiplex.entities.User;
import com.multiplex.exception.MovieNotFoundException;
import com.multiplex.repository.MovieRepository;
@Service(value="movieservice")
public class MovieServicesImpl implements MovieServices{

	@Autowired
	private MovieRepository movieRepository;
	@Override
	public List<MovieDTO> getAllMovies() throws MovieNotFoundException{
		Iterable<Movie> movies= movieRepository.findAll();
		List<MovieDTO> movies2=new ArrayList<>();
		movies.forEach(movie -> {
			MovieDTO movie1=new MovieDTO();
			movie1.setMovieId(movie.getMovieId());
			movie1.setMovieName(movie.getMovieName());
			movie1.setDate(movie.getDate());
			movie1.setTime(movie.getTime());
			movies2.add(movie1);
		});
		if(movies2.isEmpty()) {
			throw new MovieNotFoundException();
		}
		return movies2;
	}
	@Override
	public Integer addMovie(MovieDTO movie) {
		// TODO Auto-generated method stub
		Movie movieEntity=new Movie();
		movieEntity.setMovieId(movie.getMovieId());
		movieEntity.setMovieName(movie.getMovieName());
		movieEntity.setDate(movie.getDate());
		movieEntity.setTime(movie.getTime());
		Movie movieEntity2=movieRepository.save(movieEntity);
        return movieEntity2.getMovieId();
		
	}
	@Override
	public MovieDTO getMovieById(Integer movieId) throws MovieNotFoundException{
		// TODO Auto-generated method stub
		Optional<Movie> optional=movieRepository.findById(movieId);
		Movie movie=optional.orElseThrow(() ->  new MovieNotFoundException());
		MovieDTO movie2=new MovieDTO();
		movie2.setMovieId(movie.getMovieId());
		movie2.setMovieName(movie.getMovieName());
		movie2.setDate(movie.getDate());
		movie2.setTime(movie.getTime());
		return movie2;

	}
	@Override
	public void deleteMovie(Integer movieId) throws MovieNotFoundException{
		// TODO Auto-generated method stub
		Optional<Movie> optional=movieRepository.findById(movieId);
		Movie movie=optional.orElseThrow(()-> new MovieNotFoundException());
		MovieDTO movie2=new MovieDTO();
		movie2.setMovieId(movie.getMovieId());
		movie2.setMovieName(movie.getMovieName());
		movie2.setDate(movie.getDate());
		movie2.setTime(movie.getTime());
		movieRepository.deleteById(movieId);
		
	}
	@Override
	public List<MovieDTO> getMovieByName(String movieName) throws MovieNotFoundException{
		// TODO Auto-generated method stub		
		Iterable<Movie> movies= movieRepository.getMovieByName(movieName);
		List<MovieDTO> movies2=new ArrayList<>();
		movies.forEach(movie -> {
			MovieDTO movie1=new MovieDTO();
			movie1.setMovieId(movie.getMovieId());
			movie1.setMovieName(movie.getMovieName());
			movie1.setDate(movie.getDate());
			movie1.setTime(movie.getTime());
			movies2.add(movie1);
		});
		if(movies2.isEmpty()) {
			throw new MovieNotFoundException();
		}
		return movies2;
	}
	
	@Override
	public void updateMovieByName(Integer movieId, String movieName) throws MovieNotFoundException{
		// TODO Auto-generated method stub
		if(movieRepository.existsById(movieId)) {
		Movie movie=movieRepository.findById(movieId).get();
		movie.setMovieName(movieName);
		movieRepository.save(movie);
	}
		else {
	throw new MovieNotFoundException();
		}
	}
}
