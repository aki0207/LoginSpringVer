package spring.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.test.UserModel;

@Controller
@RequestMapping(value = "/login")
public class LoginControler {

	@ModelAttribute("UM")
	public UserModel init() {
		return new UserModel();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loginGet(@ModelAttribute("UM") UserModel userModel) {
		userModel.setId("初期値");
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loginPost(@ModelAttribute("UM") UserModel userModel) {

		String id = userModel.getId();
		ModelAndView mv = new ModelAndView("login");
		if (id.equals("abc")) {
			userModel.setName("ABCさん");
			mv.addObject("msg", "ログイン成功");
		} else {
			userModel.setName("");
			mv.addObject("msg", "ログイン失敗");
		}
		return mv;
	}
}
