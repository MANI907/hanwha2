package com.hanwha.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("/redirecttest")
	public String redirecttest() {
		System.out.println("redirect test임");
		//return "redirect:han";  ------ redirect: 들어가면 주소창이 바뀜
		return "redirect:test";
		
	}
	
	@RequestMapping("/paramtest2")
	public ModelAndView paramtest2(UserDTO user) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userid", user.getUserid()+100);
		mv.addObject("username", user.getUsername() +"님");

		mv.setViewName("paramtestResult");
		return mv;
		
	}
	
	@RequestMapping("/paramtest")
	public ModelAndView paramtest(Integer userid, String username) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userid", userid+100);
		mv.addObject("username", username +"님");

		mv.setViewName("paramtestResult");
		return mv;
		
	}
	
	@RequestMapping("/han")
	public ModelAndView han() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("company", "한화ICT");
		mv.addObject("dept", "개발부서123");
		mv.addObject("myname", "선민");
		//mv.addObject("condition", "졸리다ㅠㅠ");
		
		mv.setViewName("test3");
		return mv;		
	}
	
	@RequestMapping("/test")
	public String test(Model model) {

		model.addAttribute("company", "한화ICT");
		model.addAttribute("dept", "개발부서123");
		model.addAttribute("myname", "선민");
	
		//mv.addObject("condition", "졸리다ㅠㅠ");
		
		return "test3";		
		
	}

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("myname", "나는유노선민이다");
		
		return "home";
	}
	
}
