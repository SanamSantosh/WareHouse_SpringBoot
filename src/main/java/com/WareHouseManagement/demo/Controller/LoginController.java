package com.WareHouseManagement.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.WareHouseManagement.demo.Bean.Login;

@Controller
@RequestMapping("logincontrol")
@SessionAttributes("Login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView logincontroller() {
		ModelAndView mv = new ModelAndView("Login.jsp");
		Login loginObj = new Login();
		mv.addObject(loginObj);
		return mv;
	}

	// this method is used for reading user id and password from the user and
	// forwarding
	// the same to the rest control to validate the credentials
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView logincontrol(Login loginObj) {
		String url = "http://localhost:8080/login/check";
		RestTemplate rt = new RestTemplate();
		ModelAndView mv = new ModelAndView();
		String status = rt.postForObject(url, loginObj, String.class);

		if (status.equals("Yes")) {
			mv.setViewName("Home.jsp");
			;
			return mv;
		} else {
			String reply = "Invalid Credentials";
			mv.setViewName("loginvalidation.jsp");
			mv.addObject("obj", reply);
			return mv;
		}
	}

}
