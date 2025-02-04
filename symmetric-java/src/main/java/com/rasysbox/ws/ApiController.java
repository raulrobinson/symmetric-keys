package com.rasysbox.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

@RestController()
@RequestMapping("/api")
public class ApiController {
    @Autowired private SecurityAlgorithm securityAlgorithm;

    /**
     * Encrypts the data
     * @param data the data to encrypt
     * @return the encrypted data
     */
    @PostMapping(value = "/encrypt", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public String encrypt(final @RequestParam(name = "data") String data)
            throws NoSuchPaddingException,
            IllegalBlockSizeException,
            NoSuchAlgorithmException,
            InvalidKeySpecException,
            BadPaddingException,
            NoSuchProviderException,
            InvalidKeyException {
        return securityAlgorithm.encrypt(data);
    }

    /**
     * Decrypts the data
     * @param data the data to decrypt
     * @return the decrypted data
     */
    @PostMapping(value ="/decrypt", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public String decrypt(final @RequestParam(name = "data") String data)
            throws NoSuchPaddingException,
            IllegalBlockSizeException,
            NoSuchAlgorithmException,
            InvalidKeySpecException,
            BadPaddingException,
            NoSuchProviderException,
            InvalidKeyException {
        return securityAlgorithm.decrypt(data);
    }

}
