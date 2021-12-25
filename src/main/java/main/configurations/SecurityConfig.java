package main.configurations;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        UserDetails admin = userBuilder.username("admin")
                .password("admin")
                .roles(Roles.EMPLOYEE)
                .build();

        UserDetails alex = userBuilder.username("alex")
                .password("alex")
                .roles(Roles.MANAGER)
                .build();

        UserDetails tom = userBuilder.username("tom")
                .password("tom")
                .roles(Roles.MANAGER, Roles.HR)
                .build();

        auth.inMemoryAuthentication()
                .withUser(admin)
                .withUser(alex)
                .withUser(tom);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                .hasAnyRole(Roles.EMPLOYEE, Roles.MANAGER, Roles.HR)
                .antMatchers("/hr-info/**")
                .hasRole(Roles.HR)
                .antMatchers("/manager-info/**")
                .hasRole(Roles.MANAGER)
                .and()
                .formLogin()
                .permitAll();
    }

    private static class Roles {
        public static final String EMPLOYEE = "EMPLOYEE";
        public static final String MANAGER = "MANAGER";
        public static final String HR = "HR";
    }
}
