package zh.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hellocontrol{
	@RequestMapping("hello")
	public ModelAndView hello(){
		System.out.println("springmvc");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","haha");
		mav.setViewName("/WEB-INF/jsp/hello.jsp");
		return mav;
	}
}
