package spring.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.test.LoginService;
import spring.test.UserModel;

@Controller
@RequestMapping(value = "/login")
public class LoginControler {

	@Autowired
	private LoginService loginService;

	@ModelAttribute("UM")
	public UserModel init() {
		return new UserModel();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loginGet() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loginPost(@ModelAttribute("UM") UserModel userModel) {

		ModelAndView mv = new ModelAndView("login");
		if (loginService.checkLogin(userModel)) {
			mv.addObject("msg", "ログイン成功");
		} else {
			mv.addObject("msg", "ログイン失敗");
		}
		return mv;
	}
}