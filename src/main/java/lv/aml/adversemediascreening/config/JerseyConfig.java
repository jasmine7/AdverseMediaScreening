package lv.aml.adversemediascreening.config;

import lv.aml.adversemediascreening.rest.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(SearchResourceImpl.class);
        register(KeywordResourceImpl.class);
        register(ClientResourceImpl.class);
        register(UserResourceImpl.class);
        register(DecisionResourceImpl.class);
        register(ResultResourceImpl.class);
    }
}
