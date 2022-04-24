package com.supwisdom.tuition;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author hanlei
 * @date 2022/04/18
 */
@SpringBootApplication
@MapperScan("com.supwisdom.tuition.biz.mapper")
public class TuitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuitionApplication.class, args);
	}

}
