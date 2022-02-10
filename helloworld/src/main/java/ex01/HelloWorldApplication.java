package ex01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*
 * 
 * Bootstrapping class 모든 준비를 마치는 클래스
 * 
 * 1. 스프링부트 애플리케이션의 부트스래핑(Bootstrapping)
 * 2. 설정 클래스로 역할(Configuration Class)
 * 
 */
@SpringBootApplication
public class HelloWorldApplication {
	public static void main(String[] args) {
		// run 안에서 .class를 configuration 으로 써준다
		/*
		 * 1. 애플리케이션 컨텍스트(Application Context, Spring Container) 생성
		 * 2. 웹애플리케이션 타입(Web Applcation 인 경우, MVC or Reative 타입 결정)
		 * 3. 어노테이션 스캐닝(auto) or Configuration Class(Explicit) 통한 빈 생성/등록 및 와이어링
		 * 4. 웹 애플리케이션(MVC)
		 * 		- 내장(embeded) 서버(TomcatEmbeddedServletContainer) 인스턴스 생성
		 * 		- 서버 인스턴스 웹애플리케이션을 배포
		 * 		- 서버 인스턴스 실행
		 * 5. ApplicationRunner 인터페이스 구현한 빈을 찾아서 실행(run 호출)
		 */
//		ConfigurableApplicationContext c = null;
//		try {
//			c = SpringApplication.run(HelloWorldApplication.class, args);
//		} catch(Throwable ex) {
//			ex.printStackTrace();
//		} finally {
//			c.close();
//		}
		
		// configurableApplication c = null 코드 더러워보이니 없애는 법 
		// try ~ with resource
		try(ConfigurableApplicationContext c = SpringApplication.run(HelloWorldApplication.class, args)){
			
		}
	}

}