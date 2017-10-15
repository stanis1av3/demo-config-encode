package com.example.demo;

import com.example.demo.service.DefaultServiceImpl;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoConfigEncodeApplicationTests {

    @Autowired
    DefaultServiceImpl defaultService;

    @Autowired
    @Qualifier("jasyptStringEncryptor")
    StringEncryptor encryptor;

    @Test
    public void contextLoads() {

        String encrypted = encryptor.encrypt("HI THIS IS A MESSAGE");
        System.out.println(encrypted);

        String decrypted = encryptor.decrypt(encrypted);
        System.out.println(decrypted);
    }

    @Test
    public void createSomeDataTest() {

        defaultService.createSomeData();

    }


    @Test
    public void testJasypt() {
        String[] text = {"input=MYPAS_WORD", "password=password"};
        org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI.main(text);

    }

}
