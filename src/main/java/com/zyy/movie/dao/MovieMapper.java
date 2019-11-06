package com.zyy.movie.dao;

import java.util.List;

import com.zyy.movie.domain.Movie;
import com.zyy.movie.vo.MovieVo;
/**
 * 
 * @ClassName: MovieMapper 
 * @Description: TODO
 * @author: asus
 * @date: 2019年11月3日 下午6:33:05
 */
public interface MovieMapper {

	/**
	 * 
	 * @Title: selects 
	 * @Description: TODO
	 * @param movieVo
	 * @return
	 * @return: List<Movie>
	 */
	List<Movie> selects(MovieVo movieVo);
  	
}
