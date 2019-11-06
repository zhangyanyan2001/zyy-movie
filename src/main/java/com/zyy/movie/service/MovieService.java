package com.zyy.movie.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zyy.movie.domain.Movie;
import com.zyy.movie.vo.MovieVo;

public interface MovieService {

	/**
	 * 
	 * @Title: selects 
	 * @Description: TODO
	 * @param movieVo
	 * @return
	 * @return: List<Movie>
	 */
	PageInfo<Movie> selects(MovieVo movieVo,Integer page,Integer pageSize);
	
	
}
