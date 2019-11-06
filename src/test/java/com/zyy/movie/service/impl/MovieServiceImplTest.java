package com.zyy.movie.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.zyy.movie.domain.Movie;
import com.zyy.movie.service.MovieService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class MovieServiceImplTest {

	@Resource
	private MovieService service;
	
	@Test
	public void testSelects() {
		PageInfo<Movie> info = service.selects(null, 1, 10);
	}

}
