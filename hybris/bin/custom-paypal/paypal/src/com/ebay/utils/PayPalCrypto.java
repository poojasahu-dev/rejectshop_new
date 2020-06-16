package com.ebay.utils;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;


public class PayPalCrypto {
    private static final Logger LOG = Logger.getLogger(PayPalCrypto.class);
    private static final String ALGORITHM_AES = "AES";

    public static String decrypt(final String key, final String encryptedData) {
        Key generatedKey = null;
        byte[] decValue = {};
        try {
            generatedKey = new SecretKeySpec(key.getBytes(), ALGORITHM_AES);
            Cipher c = Cipher.getInstance(ALGORITHM_AES);
            c.init(Cipher.DECRYPT_MODE, generatedKey);
            byte[] decodedValue = Base64.getDecoder().decode(encryptedData);
            decValue = c.doFinal(decodedValue);
        } catch (final Exception e) {
            LOG.error("Decryption error, message: " + e.getMessage(), e);
            return "Button_Source";
        }
        return new String(decValue);
    }

}
