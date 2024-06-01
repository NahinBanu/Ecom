package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Items;
import com.example.demo.model.MyModel;
import com.example.demo.service.MyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/ecom")
public class MyController {
    @Autowired
    MyService service; 
	@GetMapping("/")
	private String welcome() {
		System.out.println("welcome");
		return "index";
	}
	@GetMapping("/Reg")
	public String reg() {
		return "Registration";
	}
	@GetMapping("/Registration")
		public String register(@ModelAttribute MyModel model ) {
			service.save(model);
			return "ResSuc";			
	}
	@GetMapping("/login")
	public String login() {
		System.out.println("Login");
		return "Resplog";		
	}	
	@GetMapping("/item")
	public String items() {
		System.out.println("Hii");
		return "additems";
	}
	@GetMapping("/itemForm")
    public String itemform(@ModelAttribute Items itm) {
		System.out.println("Data Entry");
		service.saveItem(itm);
		return "respitem";		
	}	
	@GetMapping("/loginForm")
	public String loginForm(@RequestParam String name, @RequestParam String password, HttpServletRequest request, Model model) {
		MyModel list = service.login(name, password);
		
		if(list!=null) {
			model.addAttribute("key", list);
			HttpSession session = request.getSession(true);
			session.setAttribute("name", list);			
			List<Items>fetchItem=service.fetchItem();
			model.addAttribute("item", fetchItem);
			System.out.println(fetchItem);			
			return "Resplogform";			
		}
		else {
			return "Reslogfailed";
		}	
	}	
	@GetMapping("/addCard/{id}")	// ====================Add to Card======================
	public String addCard(@PathVariable int id, HttpServletRequest request) {
		  HttpSession session = request.getSession(false);
		  MyModel model = (MyModel) session.getAttribute("name");
		  System.out.println("Customer   ==="+model);
		  service.addItem(id,model);	
		return "respcard";
	}
	
	@GetMapping("/card")		//=====================My Card=====================
	public ModelAndView card(HttpServletRequest request, Model m) {	
		 HttpSession session = request.getSession(false);
		 MyModel model = (MyModel) session.getAttribute("name");
		 System.out.println("cus ===================== "+model);
		 m.addAttribute("user", model);	
		 MyModel fetchall = service.fetchall(model);
		 List<Items> list = fetchall.getItem();
		 System.out.println("list========== "+list);
		
		return new ModelAndView("mycard", "list" , list) ;
	}	
	
	@GetMapping("/order")
	public String order(HttpServletRequest request, Model m) {	
		 HttpSession session = request.getSession(false);
		 MyModel model = (MyModel) session.getAttribute("name");
		 m.addAttribute("user", model);	
		 MyModel fetchall = service.fetchall(model);
		 List<Items> list = fetchall.getItem();
		 
		 
		 int price=0;
		 for(Items item : list) {
			 price+=item.getPrice();	
			 }
		 m.addAttribute("price", price);
		 System.out.println("Total price"+price);
		 m.addAttribute("list", list); 
		 return "billdetails";	
	}
	@GetMapping("/confirm")
	private String confirm() {
		return "confirm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request ) {
		HttpSession session = request.getSession(false);
		
	//	session.setMaxInactiveInterval(5);
		session.invalidate();	
		return "redirect:/login";
	}
}
