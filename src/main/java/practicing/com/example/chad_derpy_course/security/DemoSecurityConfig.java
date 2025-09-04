package practicing.com.example.chad_derpy_course.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/instructors").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/instructors/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/instructors").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/instructors").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PATCH,"/api/instructors/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/instructors/**").hasRole("ADMIN")
      );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
