package zh.control;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import zh.pojo.Item;
@Controller
public class ItemsControl {
	
	@RequestMapping("itemList")
	public ModelAndView itemList(){
		ModelAndView mav = new ModelAndView();
		//ģ���ѯ��Ʒ�б�
		List<Item> list = Arrays.asList(new Item(1, "����", 1999, new Date(), "�������"), new Item(2, "����2", 1999, new Date(), "�������2"),
				new Item(3, "����3", 1999, new Date(), "�������3"),new Item(4, "����4", 1999, new Date(), "�������"));
		mav.addObject("itemList", list);
//		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		mav.setViewName("itemList");
		return mav;
	}
}
