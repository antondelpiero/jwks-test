package example.micronaut.security;

import com.nimbusds.jose.JWSAlgorithm;

import javax.annotation.PostConstruct;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class MyKeyPair {
    RSAPrivateKey privateKey;
    RSAPublicKey publicKey;
    JWSAlgorithm jwsAlgorithm = JWSAlgorithm.RS256;

    @PostConstruct
    public void init() {
        try {
            KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
            gen.initialize(2048);
            KeyPair keyPair = gen.generateKeyPair();

            privateKey = (RSAPrivateKey) keyPair.getPrivate();
            publicKey = (RSAPublicKey) keyPair.getPublic();
        } catch (Exception e) {

        }
    }

    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

    public JWSAlgorithm getJwsAlgorithm() {
        return jwsAlgorithm;
    }
}
