package com.example.demo;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableEncryptableProperties
@PropertySource(name="EncryptedProperties", value = "classpath:application-personal-profile.properties")
public class DemoConfigEncodeApplication {

	@PostConstruct
	void started() {
	//	System.getProperties().setProperty("jasypt.encryptor.password", "MYPAS_WORD");
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoConfigEncodeApplication.class, args);
	}
}
