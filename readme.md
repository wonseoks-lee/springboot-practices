# Spring Boot 실행 순서

---

1. 애플리케이션 컨텍스트(Application Context, Spring Container) 생성
2. 웹애플리케이션 타입(Web Applcation 인 경우, MVC or Reative 타입 결정)
3. 어노테이션 스캐닝(auto) or Configuration Class(Explicit) 통한 빈 생성/등록 및 와이어링
4. 웹 애플리케이션(MVC)
    - 내장(embeded) 서버(TomcatEmbeddedServletContainer) 인스턴스 생성
    - 서버 인스턴스 웹애플리케이션을 배포
    - 서버 인스턴스 실행
5. ApplicationRunner 인터페이스 구현한 빈을 찾아서 실행(run 호출)

# 자원 정리 코드 최적화

---

### try catch finally

```java
ConfigurableApplicationContext c = null;
		try {
			c = SpringApplication.run(HelloWorldApplication.class, args);
		} catch(Throwable ex) {
			ex.printStackTrace();
		} finally {
			c.close();
		}
```

### try ~ with resource

```java
// try ~ with resource
		try(ConfigurableApplicationContext c = SpringApplication.run(HelloWorldApplication.class, args)){
			
		}
```