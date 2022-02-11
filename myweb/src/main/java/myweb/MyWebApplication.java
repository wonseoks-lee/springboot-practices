package myweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MyWebApplication {
	
	
	@Controller
	public class HelloController{
		//RequestMethod.GET 이랑 같은 의미 
		@GetMapping("/hello")
		public String hello1() {
			return "hello";
		}
	}
	
	@RestController
	public class HelloController2{
		
		@GetMapping("/hello2")
		public String hello2() {
			return "<h1>Hello World2</h1>";
		}
	}
	
	//WebApplication에서는 try ~ resource 를 쓰면 안된다 
	public static void main(String[] args) {
		SpringApplication.run(MyWebApplication.class, args);
	}

}
