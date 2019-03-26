package example.micronaut.security;

import com.nimbusds.jose.JWSAlgorithm;
import io.micronaut.security.token.jwt.signature.rsa.RSASignatureGeneratorConfiguration;

import javax.inject.Inject;
import javax.inject.Named;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Named("generator")
public class MySignatureGenerator implements RSASignatureGeneratorConfiguration {

    @Inject
    MyKeyPair provider;

    @Override
    public RSAPrivateKey getPrivateKey() {
        return provider.getPrivateKey();
    }

    @Override
    public JWSAlgorithm getJwsAlgorithm() {
        return provider.getJwsAlgorithm();
    }

    @Override
    public RSAPublicKey getPublicKey() {
        return provider.getPublicKey();
    }
}
