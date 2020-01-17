package com.example.ek.recordapp.web.top;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * record-app
 * com.example.ek.recordapp.web.top.TopController.java
 *
 * Top画面を返却するためのコントローラクラス
 *
 * @author E-Kanegae
 *
 */
@Controller
public class TopController {

	@GetMapping("/")
	public String top(Model model) {
		model.addAttribute("hello", "Welocome to My Application.");
		return "top/top";
	}

}
