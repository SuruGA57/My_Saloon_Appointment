package com.my_apppintmt.mainController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

		@GetMapping("/get")
		public String red() {
			
			return "Hii my first project";
			
		}		
}
