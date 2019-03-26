package example.micronaut.security;

import io.micronaut.security.token.jwt.signature.rsa.RSASignatureConfiguration;

import javax.inject.Singleton;
import java.security.interfaces.RSAPublicKey;

@Singleton
public class MyRSASignatureGeneratorConfiguration implements RSASignatureConfiguration {
    @Override
    public RSAPublicKey getPublicKey() {
        return null;
    }
}
