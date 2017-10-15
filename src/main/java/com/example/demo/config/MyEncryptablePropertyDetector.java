package com.example.demo.config;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyDetector;

/**
 * Created by stas on 10/15/2017.
 */

class MyEncryptablePropertyDetector implements EncryptablePropertyDetector {
    @Override
    public boolean isEncrypted(String value) {
        if (value != null) {
            return value.startsWith("ENC");
        }
        return false;
    }

    @Override
    public String unwrapEncryptedValue(String value) {
        return value.substring("ENC".length());
    }
}