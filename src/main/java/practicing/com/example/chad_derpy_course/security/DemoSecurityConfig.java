package practicing.com.example.chad_derpy_course.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails mohamed = User.builder().username("mohamed").password("{noop}mohamed").roles("EMPLOYEE").build();
        UserDetails ahmed = User.builder().username("ahmed").password("{noop}ahmed").roles("EMPLOYEE", "MANAGER").build();
        UserDetails shadi = User.builder().username("shadi").password("{noop}shadi").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(mohamed,ahmed,shadi);
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
