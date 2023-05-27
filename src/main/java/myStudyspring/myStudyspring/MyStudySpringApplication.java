package myStudyspring.myStudyspring;

//이 경로 하위의 것들은 스프링 빈이 다 뒤져서 찾아낸다. - 컴포넌트 스캔 가능
// 따라서 myStudyspring.myStudyspring 자체는 x

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyStudySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyStudySpringApplication.class, args);
	}

}
