# Spring Boot 실행 순서



1. 애플리케이션 컨텍스트(Application Context, Spring Container) 생성
2. 웹애플리케이션 타입(Web Applcation 인 경우, MVC or Reative 타입 결정)
3. 어노테이션 스캐닝(auto) or Configuration Class(Explicit) 통한 빈 생성/등록 및 와이어링
4. 웹 애플리케이션(MVC)
    - 내장(embeded) 서버(TomcatEmbeddedServletContainer) 인스턴스 생성
    - 서버 인스턴스 웹애플리케이션을 배포
    - 서버 인스턴스 실행
5. ApplicationRunner 인터페이스 구현한 빈을 찾아서 실행(run 호출)




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

# JPA

1. [https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager/5.6.5.Final](https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager/5.6.5.Final) 접속
2. dependency 추가

```xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-entitymanager</artifactId>
    <version>5.6.5.Final</version>
</dependency>
```

pom.xml파일 <version> 테그의 경고 메시지는 의미가 없으므로 무시해도 되며, 심지어 삭제해도 상관없다

```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

hibernate-entitymanager 의존성을  삭제하고 JPA스타터로 변경
 

---
title: Visual Studio Code - Spring boot 개발 환경 세팅
tags: Springboot
---

## Summry  

본 문서에서는 VSC(Visual Studio Code)에서 Spring boot 개발 환경을 구성하는 방법을 정리한다.  

많은 사람들이 spring boot project에서 Intellij나 Eclipse를 IDE로 사용하지만 VSC가 익숙하고 또 VSC를 이용해 개발하고자 하는 사람들을 위해 VSCode에서 spring boot 기반 java application을 개발할 수 있는 환경을 구축하는 방법을 정리한다.  

**본 문서는 VSC IDE의 install 방법은 설명하지 않는다.**  

<!--more-->

---

## plugin install

**VSCode 내 확장 마켓플레이스 검색: ```Cmd + Shift + X``` 를 눌러 VSCode ‘Extension Marketplace’ 를 패널을 띄운다.**  

### Java Extension Pack


* **Java Extension Pack은 Visual Studio Code에서 Java 응용 프로그램을 작성, 테스트 및 디버그하는 데 도움이 될 수 있는 널리 사용되는 확장팩이다.**  

### Spring Boot Extenstion Pack


* **Spring Boot 애플리케이션 개발 및 배포를 위한 확장팩이다.**

### Lombok Annotations Support for VS Code


* **Java 라이브러리로 반복되는 getter, setter, toString .. 등의 반복 메서드 작성 코드를 줄여준다.**  

[Lombok Library 정리글](https://limjunho.github.io/2021/08/01/JAVA-LOMBOK.html)

### Spring Initializr Java Support


* **Spring Initializr Java Support 확장팩으로 VSCode 내에서 Spring Initialzr(https://start.spring.io/) API를 이용하여 스프링 부트 프로젝트를 구성할 수 있다.**

### Spring Boot Dashboard


* **피보탈이 이클립스를 통해 제공하는 대시보드와 유사하게 작동한다. 등록된 스프링 부트 애플리케이션 조회, 실행, 중단, 디브그 및 실행중인 스프링 부트 앱을 브라우저에서 열어볼 수 있다.**

## create project

1. **```Command + Shift + P``` 를 눌러 커맨드 팔레트(Command palette)를 열어 ‘Spring initalizr: Create a Maven Project’ 를 선택한다.**
2. **Spring Boot version 선택**
3. **Project language 선택**
4. **Group Id 등록**
    * 모든 프로젝트 중에서 당신의 프로젝트를 식별하게 해주는 식별자
    * groupId는 Java의 패키지 이름 규칙을 따라야 함 즉 제어하는 도메인 이름의 반대로 시작
    ex) org.apache.maven, org.apache.commons 
    * 만약에 프로젝트가 다중 모듈 프로젝트인 경우 부모의 groupId에 새 식별자를 추가해 사용
    * org.apache.maven, org.apache.maven.plugins, org.apache.maven.reporting
5. **Artifact Id**
    * artifactId는 버전이 없는 jar의 이름
6. **Packaging type 선택: JAR**
7. **Java Version 선택**
8. **Dependnecies 선택(사용하려는 기술에 따라 다름)**
    * Spring Boot DevTools
    * Lombok
    * Spring Configuration Processor
    * Spring Web
    * Spring Data JPA
    * H2 Database
    * Flyway Migration
    * MariaDB Driver
9. **저장소 생성위치 지정**
10. **finish**

## test code 작성

**임의로 TestController를 만들어 /test uri로 접근 시 "test!!"문자열을 반환하는 api를 작성해본다.**  


```java
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "test!!";
    }
}

```

## 실행

**코드 작성을 했다면 메인클래스(@SpringBootTest 와 메인메서드(public static void main(String[] args)) 선언)를 선택하여 우클릭 후 Run 을 실행하거나 소스코드를 열면 메인메서드 위에 Run \| Debug 가 노출된다.**  


* **해당 uri로 접근(get) 시 test!! 문자열을 확인할 수 있다.**  
* **별도 설정을 하지 않는다면 기본 port는 8080이다.**  
## Reference

> [[spring-boot] Visual Studio Code 에서 스프링 부트 프로젝트 개발하기 - honeymon](http://honeymon.io/tech/2021/01/06/use-vs-code-for-spring-boot.html)  
> [[SPRING]Maven 프로젝트 groupId, artifactId, version 이란? - 코딩 시그널](https://junghn.tistory.com/entry/SPRINGMaven-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-groupId-artifactId-version-%EC%9D%B4%EB%9E%80)  

## lombok설치
1.  Dependency install
+ [Available] -> [Core] -> Lombok check
2.  lombok.jar Library add
+ https://procjectlombok.or 접속, Download
+ terminal -> java -jar lombok.jar

## 회사에서만 사용하는 스타터, 자동설정
1.	원하는 스타터 dependency추가
	-	버전관리를 일괄적으로 하고 싶다면, dependencyManager 추가
2.	자동설정기능 구현
	-	spring-boot-autoconfiguration dependency 추가 
	
# @SpringBootApplication

@EnableAutoConfiguration, @ComponentScan, @SpringBootConfiguration 를 합쳐놓은 어노테이션

@SpringBootConfiguration → 빈클래스를 표현하기위해 사용, @Configuration 에 이름만 스프링부트를 붙힌 것

@EnableAutoConfiguration, @ComponentScan → 스프링 컨테이너 초기화와 관련된 어노테이션

- ComponentScan : @Configuration, @Repository, @Service, @Controller, @RestController객체를 메모리에 올리는 역할
    
    → 가장 먼저 처리되며, 사용자가 등록한 빈을 먼저 메모리에 올린다
    
- EnableAutoConfiguration : 스프링부트는 스프링 컨테이너를 구동 할 때 두단계로 나누어 객체를 생성한다. ( 애플리케이션을 운영하기 위해서는 두 종류의 빈들이 필요하기 때문 )
    
    → 멀티파트 리졸버 객체들을 메모리에 올리는 작업 처리 
    
    → spring-boot-autoconfigure-2.1.5.RELEASE.jar 의 META-INF 폴더에 spring.factories 파일을 참조하여 여러가지 빈을 생성
    
    →  ComponentScan단계에서 메모리에 올린 빈들(자동설정에 의한)의 등록을 처리한다.
    

# Maven

package : target 폴더에 jar 파일만 생성

install : 다른 프로젝트에서 현재 프로젝트를 사용할 수 있도록 메이븐 로컬 리포지터리에도 등록

# Bean Overriding

```
# Bean Overriding
spring.main.allow-bean-definition-overriding=true
```

같은 타입을 가진 빈을 생성 시, 충돌이 발생한다

이를 방지하기위해, application.properties 의 bean Overriding설정을 해준다.

그러나, 이를 실행하더라도 기존 프로젝트의 빈이 @EnableAutoConfiguration 에 의해 덮어씌어진다.

이를 해결하기위해 @Conditional 을 사용하여 기본 빈생성을 언제해줄지 설정한다.

# @Conditional

@Conditional : 조건에 따라 새로운 객체를 생성할지 말지 결정

빈을 오버라이딩이 가능해도 기존 스타터프로젝트(board-spring-boot-starter)에서 빈으로 등록한  JDBCManager가 사용된다. 

새로 설정한 JDBCManager객체를 사용하기 위해서는 @Conditional 조건을 사용하여 

## @ConditionalOnMissingBean

등록하려는 빈이 메모리에 없는 경우에만 현재의 빈 등록을 처리

```java
@Configuration
public class BoardAutoConfiguration {
	
	@Bean
	@ConditionalOnMissingBean
	public JDBCConnectionManager getJDBCConnectionManager()	{
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass("oracle.jdbc.driver.OracleDriver");
		manager.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		manager.setUsername("hr");
		manager.setPassword("hr");
		return manager;
	}
}
```

따로 빈등록을 해주지 않았을때만 위 코드가 작동된다 ( default Bean 설정 )

# @ConfigurationProperties

```
# DataSoruce : Oracle
board.jdbc.driverClass=oracle.jdbc.driver.OracleDriver
board.jdbc.url=jdbc:oracle:thin:@localhost:1521:xe
board.jdbc.username=hr
board.jdbc.password=hr
```

프로퍼티파일에 설정할 프로퍼티를 접근하기위한 접두사

```java
@ConfigurationProperties(prefix="board.jdbc")
public class JDBCConnectionManagerProperties {
	private String driverClass;
	private String url;
	private String username;
	private String password;
	...
}
```

접두사 뒤에 있는 프로퍼티에 해당하는 Setter 메소드들이 자동으로 실행되어 프로퍼티 값들을 설정하는 것

Ex)  board.jdbc.driverClass 라면 board.jdbc 뒤에 있는 프로퍼티 이름인 driverClass 에 해당하는 setDriverClass() 메소드가 자동으로 호출

## @EnableConfigurationProperties

활성화할 프로퍼티 클래스를 지정할 때 사용
 