package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;

@Controller("/")
@Secured("isAuthenticated()")
public class SecretController {

    @Get("/")
    String index() {
        return "Authenticated";
    }

}
