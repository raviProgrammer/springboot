package com.ravi.Runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.Entity.Movie;
import com.ravi.service.IMovieService;

@Component("crudRepoRunner")
public class CrudRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieService service;
	@Override
	public void run(String... args) throws Exception {
		  Movie movie=new Movie(); 
		  movie.setMname("Pupsha");
		  movie.setYear(2021);
		  movie.setRating(8.0f);
		  try {
			  System.out.println(service.registorMovie(movie));
			  } 
		 catch(Exception e) {
			  e.printStackTrace();
		}
		try {
			System.out.println("How many number of Row Table Data: "+service.fetchMovieCount());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("Check Id for Exiting or Not: "+service.checkMovieByID(1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("Show All data Table: "+service.fetchAllDataShow());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("Check Id for Exiting or Not: "+service.fetchMovieOption(5));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("Find Exit Data with used else concept: "+service.fetchMovieOptionBYId(9));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			String result=service.GroupMovieRegistor(List.of(new Movie("venom2",2021,9.0f),
					new Movie("RRR",2022,8.0f),
					new Movie("venom",2018,8.0f),
					new Movie("venom2",2021,9.0f)
					));
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
