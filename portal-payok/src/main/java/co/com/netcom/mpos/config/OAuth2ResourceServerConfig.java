package co.com.netcom.mpos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
    @Override
    public void configure(final ResourceServerSecurityConfigurer config) {
        config.tokenServices(tokenService());
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll();
    }
    @Primary
    @Bean
    public RemoteTokenServices tokenService() {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(
          "https://support.netcom.com.co:9544/oauth2/token");
        tokenService.setClientId("CFGkFIU4JKhy9cjG6HnoctOg8aQa");
        tokenService.setClientSecret("Tek1bEVvPXLNb7AI5fkVVbhToEMa");
        return tokenService;
    }

}
