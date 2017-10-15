package com.example.demo;

import com.example.demo.service.DefaultServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoConfigEncodeApplicationTests {

	@Autowired
	DefaultServiceImpl defaultService;


	@Test
	public void contextLoads() {
	}

	@Test
	public void createSomeDataTest(){

		defaultService.createSomeData();

	}



	@Test
	public void testJasypt(){
		String[] text = {"input=MYPAS_WORD","password=password"};
		org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI.main(text);

	}

}
