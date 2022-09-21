package com.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Failed to determine a suitable driver class
//SpringExampleApplication.java에서 클래스명 위에 어노테이션 추가(디비 연동전에 임시로 넣는 코드)

@SpringBootApplication
public class SpringQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringQuizApplication.class, args);
	}

	

}
