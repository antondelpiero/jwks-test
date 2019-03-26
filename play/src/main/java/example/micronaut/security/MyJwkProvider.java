package example.micronaut.security;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import io.micronaut.security.token.jwt.endpoints.JwkProvider;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Singleton
public class MyJwkProvider implements JwkProvider {

    @Inject
    MyKeyPair provider;

    List<JWK> jsonWebKeys = new ArrayList<>();

    @PostConstruct
    public void init() {
            JWK jwk1 = new RSAKey.Builder(provider.getPublicKey()).privateKey(provider.getPrivateKey())
                                                                  .keyUse(KeyUse.SIGNATURE)
                                                                  .keyID(UUID.randomUUID()
                                                                             .toString())
                                                                  .algorithm(provider.getJwsAlgorithm())
                                                                  .build();
            jsonWebKeys.add(jwk1);
    }

    @Override
    public List<JWK> retrieveJsonWebKeys() {
        return jsonWebKeys;
    }
}
