package dw.secauth.seguranca;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private final String clientId;
    private final String logoutURL;
    private final String redirectURI;

    public SecurityConfiguration (@Value("${spring.security.oauth2.client.registration.cognito.clientId}") String clientId, 
                                    @Value("${app.cognito.logoutURL}") String logoutURL, 
                                    @Value("${app.cognito.redirectURI}") String redirectURI) { 

            this.clientId = clientId;
            this.logoutURL = logoutURL;
            this.redirectURI = redirectURI;
    }

    // Configura a atorização e requests, login, logout e limpa autenticação e cookies
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .and()
                    .authorizeRequests(authz -> authz.mvcMatchers("/")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                    .oauth2Login()
                .and()
                    .logout()
                    .logoutSuccessHandler(new CognitoOidcLogoutSuccessHandler(clientId, logoutURL, redirectURI))
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .deleteCookies("JSESSIONID");
    }
}