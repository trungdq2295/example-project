package com.example.google.tink.googletinkexample.encryption;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadFactory;
import com.google.crypto.tink.aead.AeadKeyTemplates;

import java.security.GeneralSecurityException;

public class EncryptionUtil {

    private static final String KEY = "ABC";

    private static KeysetHandle keysetHandle;

    private static Aead aead;

    static {
        try {
            AeadConfig.register();
            keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES256_GCM);
            aead = AeadFactory.getPrimitive(keysetHandle);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(String data) {
        try {
            byte[] ciphertext = aead.encrypt(data.getBytes(), KEY.getBytes());
            byte[] decrypted = aead.decrypt(ciphertext, KEY.getBytes());
            System.out.println("abc" + new String(decrypted));
            return ciphertext;
        } catch (GeneralSecurityException ex) {

        }
        return null;
    }

    public static String decrypt(byte[] data) {
        try {
            byte[] decrypted = aead.decrypt(data, KEY.getBytes());
            return new String(decrypted);
        } catch (GeneralSecurityException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
