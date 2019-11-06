package com.zyy.movie.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zyy.movie.domain.Movie;
import com.zyy.movie.service.MovieService;
import com.zyy.movie.util.PageUtil;
import com.zyy.movie.vo.MovieVo;

@Controller
public class MovieController {

	@Resource
	private MovieService service;
	
	@RequestMapping("selects")
	public String selects(HttpServletRequest request, MovieVo movieVO,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "3")Integer pageSize) {
		
		 if(null==movieVO.getOrderMethod()) {
			 movieVO.setOrderMethod("asc");//默认是正序排序 
		 }
		  
		
		 PageInfo<Movie> info = service.selects(movieVO, page, pageSize);
		 PageUtil.page(request, "/selects", pageSize, info.getList(), (int)info.getTotal(), page);
		 request.setAttribute("movies", info.getList());
		 request.setAttribute("movieVO", movieVO);
		 return "movies";
	}
}
