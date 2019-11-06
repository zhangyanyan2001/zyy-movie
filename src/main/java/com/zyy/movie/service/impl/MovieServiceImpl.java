package com.zyy.movie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyy.movie.dao.MovieMapper;
import com.zyy.movie.domain.Movie;
import com.zyy.movie.service.MovieService;
import com.zyy.movie.vo.MovieVo;
@Service
public class MovieServiceImpl implements MovieService {

	@Resource
	private MovieMapper mapper;
	
	@Override
	public PageInfo<Movie> selects(MovieVo movieVo, Integer page, Integer pageSize) {
		
		PageHelper.startPage(page, pageSize);
		
		List<Movie> list = mapper.selects(movieVo);
		
		return new PageInfo<Movie>(list);
	}

}
