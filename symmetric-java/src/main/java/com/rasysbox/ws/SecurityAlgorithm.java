package com.rasysbox.ws;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
public class SecurityAlgorithm {

    private static final String ALGORITHM = "RSA/None/OAEPWithSHA-1AndMGF1Padding";
    private static final String PROVIDER = "BC";

    @Value("${key.private}")
    private String rsaPrivateKey;

    @Value("${key.public}")
    private String rsaPublicKey;

    public String decrypt(String data)
            throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            NoSuchProviderException,
            InvalidKeySpecException,
            InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {
        Security.addProvider(new BouncyCastleProvider());

        byte[] privateKeyBytes = Base64.getDecoder().decode(rsaPrivateKey);
        var keyFactory = KeyFactory.getInstance("RSA", "BC");
        var privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));

        var cipher = Cipher.getInstance(ALGORITHM, PROVIDER);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] usernameDecryptedBytes = cipher.doFinal(Base64.getDecoder().decode(data));

        return new String(usernameDecryptedBytes);
    }

    public String encrypt(String data)
            throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            NoSuchProviderException,
            InvalidKeySpecException,
            InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {
        Security.addProvider(new BouncyCastleProvider());

        byte[] publicKeyBytes = Base64.getDecoder().decode(rsaPublicKey);
        var keyFactory = KeyFactory.getInstance("RSA", "BC");
        var publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));

        var cipher = Cipher.getInstance(ALGORITHM, PROVIDER);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] encryptedBytes = cipher.doFinal(data.getBytes());

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

}
