package com.mashensoft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mashensoft.service.IUserService;
@RequestMapping("/user")
@Controller
public class UserControler {
	@Qualifier("userServiceImpl")
	IUserService userServiceImpl;
	
	
	
	
	@RequestMapping(value="/listUser",method=RequestMethod.GET)
	public String listUser(){
		//System.out.println(username);
		return "success";
	}
	@RequestMapping("/getSomething1")
	public String getSomething1(HttpServletRequest request){
//		request.getParameter("username");
//		request.getHeader("");
//		request.getSession();
//		request.getCookies()
		//System.out.println(username);
		return "success";
	}
	@RequestMapping("/getSomething2")
	public String getSomething2(HttpServletRequest request,@RequestParam(required=false) String username,@RequestParam(required=false) String age){
		System.out.println(username);
		System.out.println(age);
		request.setAttribute("username", username);
		return "success";
	}
	@RequestMapping("/getSomething3")
	public String getSomething3(User user){
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return "success";
	}
	@RequestMapping("/getSomething4")
	public String getSomething4(@RequestHeader("User-Agent") String ua,@RequestHeader("Accept") String ac){
		System.out.println(ua);
		System.out.println(ac);
		return "success";
	}
	@RequestMapping("/getSomething5")
	public String getSomething5(@CookieValue("JSESSIONID") String jid,@CookieValue("bdshare_firstime") String bf){
		System.out.println(jid);
		System.out.println(bf);
		return "success";
	}
	@RequestMapping(value="/listUser2",method=RequestMethod.GET)
	public String listUser(User user,@CookieValue("JSESSIONID") String cookieid){
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(cookieid);
		return "success";
	}

	@ResponseBody
	@RequestMapping(value="/listUser3")
	public User listUser3(){
		User user = new User();
		user.setUsername("aaaa");
		user.setPassword("bbbb");
		return user;
	}
	@ResponseBody
	@RequestMapping(value="/listUser31")
	public List<User> listUser31(){
		
		User user = new User();
		user.setUsername("aaaa");
		user.setPassword("bbbb");
		User user2 = new User();
		user2.setUsername("aaaa1111");
		user2.setPassword("bbbb2222");
		List<User> list = new ArrayList<>();
		list.add(user);
		list.add(user2);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="/listUser4",method=RequestMethod.POST)
	public User listUser3(@RequestBody User userreq){
		System.out.println(userreq.getUsername());
		System.out.println(userreq.getPassword());
		User user = new User();
		user.setUsername("aaaa");
		user.setPassword("bbbb");
		return user;
	}
	@RequestMapping(value="/listUser6",method=RequestMethod.GET)
	public ModelAndView listUser6(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		mv.addObject("myname", "wangzongxing");
		return mv;
	}
	@RequestMapping(value="/listUser7")
	public String listUser7(@ModelAttribute User user){
		user.setUsername("xingge");
		return "success";
	}
	@RequestMapping(value="/listUser8")
	public String listUser8(Map<String,Object> map){
		map.put("myage",20);
		return "success";
	}
	@RequestMapping(value="/listUser9")
	public String listUser9(){
		System.out.println(userServiceImpl.getName());
		return "success";
	}
}
