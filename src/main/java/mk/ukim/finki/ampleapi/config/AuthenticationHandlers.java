package mk.ukim.finki.ampleapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class AuthenticationHandlers {

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request,
                                 HttpServletResponse response,
                                 AuthenticationException authenticationException) throws IOException,
                                 ServletException {
                                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
                                 }
        };
    }
}
