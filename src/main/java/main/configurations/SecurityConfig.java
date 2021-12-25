package main.configurations;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                .hasAnyAuthority(Roles.EMPLOYEE, Roles.MANAGER, Roles.HR)
                .antMatchers("/hr-info/**")
                .hasAuthority(Roles.HR)
                .antMatchers("/manager-info/**")
                .hasAuthority(Roles.MANAGER)
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
