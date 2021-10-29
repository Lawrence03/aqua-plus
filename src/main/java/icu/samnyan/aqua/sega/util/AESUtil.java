package icu.samnyan.aqua.sega.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
public class AESUtil {
    private static Map<Double, SecretKeySpec> keys = Map.of(1.00,  new SecretKeySpec("Kk3Bj+GUuM4SohIBwPE826vKBGGhWrTW".getBytes(), "AES"), 1.10, new SecretKeySpec("RP77N6nQkRPcrh9HdT6gCrTWKbWLnLbH".getBytes(), "AES"), 1.14, new SecretKeySpec("CE2uAPm2SN3W9ZXWVj3ymH6Vt2YQxJ7Z".getBytes(), "AES"), 1.17, new SecretKeySpec("wxjWYzikknQkTNPhsYTCEnNWA64jBzFS".getBytes(), "AES"));
    private static Map<Double, String> ivs = Map.of(1.00, "C8scXXB6V8yo99C9", 1.10, "BB5MhMnnd6Nsh2ua", 1.14, "r3LPGCH69AH5WSfT", 1.17, "XbuPfC8pSaSucAC3");
    private static String arg = "AES/CBC/PKCS5Padding";

    private static Map<Integer, SecretKeySpec> keys_ongeki = Map.of(
            115,  new SecretKeySpec("M:53X83\\\\:cdlfYqS0c5zmn>N?\\J70<7".getBytes(), "AES"),
            120, new SecretKeySpec("O8XWdN5AJl;>O0;227>LP2<^iUxqpkMs".getBytes(), "AES"),
            125, new SecretKeySpec("g0E8CBH5m`X;VOq0AK8@6uvm4]oJA<wU".getBytes(), "AES"),
            130, new SecretKeySpec("93VEvyNI;qV0XhHLTsj;;CVO]0bZ7FQ9".getBytes(), "AES"));
    private static Map<Integer, String> ivs_ongeki = Map.of(
            115, "E3;\\V7R[O`VWBovC",
            120, "2>KPq^jEPl[1[kQT",
            125, "Sio5vT9]963;3269",
            130, "RhPuZaMTYHa:cPr6");

    private static Map<Integer, SecretKeySpec> keys_chuni = Map.of(145, new SecretKeySpec(";XShM|{&]=H<`{%s}\"7Lm&[GAM.R+8H.".getBytes(), "AES"), 150, new SecretKeySpec("TV^7W&+?J[XWLd5CzJa3+bUxn[0-ay(S".getBytes(), "AES"));
    private static Map<Integer, String> ivs_chuni = Map.of(145, "czp2.-b-#n.q)<[Z", 150, "czp2.-b-#n.q)<[Z");

    public static byte[] decrypt(byte[] data, double ver) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(arg);
        cipher.init(Cipher.DECRYPT_MODE, keys.get(ver), new IvParameterSpec(ivs.get(ver).getBytes()));
        return cipher.doFinal(data);
    }

    public static byte[] encrypt(byte[] data, double ver) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(arg);
        cipher.init(Cipher.ENCRYPT_MODE, keys.get(ver), new IvParameterSpec(ivs.get(ver).getBytes()));
        return cipher.doFinal(data);
    }

    public static byte[] decrypt_ongeki(byte[] data, Integer ver) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(arg);
        cipher.init(Cipher.DECRYPT_MODE, keys_ongeki.get(ver), new IvParameterSpec(ivs_ongeki.get(ver).getBytes()));
        return cipher.doFinal(data);
    }

    public static byte[] encrypt_ongeki(byte[] data, Integer ver) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(arg);
        cipher.init(Cipher.ENCRYPT_MODE, keys_ongeki.get(ver), new IvParameterSpec(ivs_ongeki.get(ver).getBytes()));
        return cipher.doFinal(data);
    }

    public static byte[] decrypt_chuni(byte[] data, Integer ver) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(arg);
        cipher.init(Cipher.DECRYPT_MODE, keys_chuni.get(ver), new IvParameterSpec(ivs_chuni.get(ver).getBytes()));
        return cipher.doFinal(data);
    }

    public static byte[] encrypt_chuni(byte[] data, Integer ver) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(arg);
        cipher.init(Cipher.ENCRYPT_MODE, keys_chuni.get(ver), new IvParameterSpec(ivs_chuni.get(ver).getBytes()));
        return cipher.doFinal(data);
    }
}
