package BTEC.Management.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import BTEC.Management.Configuration.*;
import BTEC.Management.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@Component
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
        http.csrf().disable();
        
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
 
        http.authorizeRequests().antMatchers("/all-courses").access("hasAnyRole('ROLE_TRAINER', 'ROLE_STAFF')");
 
        http.authorizeRequests().antMatchers("/index-2", "/index", "/index-1", "/add-user", "/edit-user", "/show-user").access("hasRole('ROLE_ADMIN')");
         
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/404");
 
        http.authorizeRequests().and().formLogin()//
               
                .loginProcessingUrl("/j_spring_security_check") 
                .loginPage("/login")//
                .successHandler(myAuthenticationSuccessHandler())
                .failureUrl("/login?error=true")
                //.failureHandler(authenticationFailureHandler())//
                .usernameParameter("username")//
                .passwordParameter("password")
                .and().logout().logoutSuccessUrl("/landing");
                // .deleteCookies("auth_code", "JSESSIONID").invalidateHttpSession(true)
                // .logoutSuccessHandler(logoutSuccessHandler());
 
    }
  
}