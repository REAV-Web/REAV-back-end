package shop.reav.reavproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // DB 연결 안했기 때문에 인자에 exclude 뭐시기 추가함
public class ReavprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReavprojApplication.class, args);
	}

}
