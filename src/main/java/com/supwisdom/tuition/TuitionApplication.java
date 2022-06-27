package com.supwisdom.tuition;

import com.supwisdom.tuition.biz.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author hanlei
 * @date 2022/04/18
 */
@SpringBootApplication
@MapperScan("com.supwisdom.tuition.biz.mapper")
public class TuitionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(TuitionApplication.class, args);
		User bean = run.getBean(User.class);
		System.out.println(bean);
		for (String s : run.getBeanNamesForType(User.class)) {
			System.out.println(s);
		}
	}

}
