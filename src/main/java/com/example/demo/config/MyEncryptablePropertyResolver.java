package com.example.demo.config;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyResolver;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 * Created by stas on 10/15/2017.
 */
class MyEncryptablePropertyResolver implements EncryptablePropertyResolver {


    private final PooledPBEStringEncryptor encryptor;

    public MyEncryptablePropertyResolver(char[] password) {
        this.encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPasswordCharArray(password);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize(1);
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
    }

    @Override
    public String resolvePropertyValue(String value) {
        if (value != null && value.startsWith("{cipher}")) {
            return encryptor.decrypt(value.substring("{cipher}".length()));
        }
        return value;
    }
}