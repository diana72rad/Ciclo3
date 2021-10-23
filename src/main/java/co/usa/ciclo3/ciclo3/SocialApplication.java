/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3;

import java.util.Collections;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author diana
 */
@SpringBootApplication
//@RestController
//@EntityScan(basePackages={"co.usa.ciclo3.ciclo3.entities"})
public class SocialApplication extends WebSecurityConfigurerAdapter {
    
    public static void main(String[] args) {
        SpringApplication.run(SocialApplication.class, args);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	// @formatter:off
        http
            .authorizeRequests(a -> a
                .antMatchers("/","/h2-console/**","/api/Category/**","/api/Client/**", "/api/Message/**","/api/Reservation/**","/api/Message/**","/api/Motorbike/**","/error", "/webjars/**").permitAll()
                .anyRequest().authenticated()
            )
            .exceptionHandling(e -> e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            )
            .logout(l -> l
            .logoutSuccessUrl("/").permitAll()
                )
            .oauth2Login();
        // @formatter:on
        http.cors().and().csrf().disable();
    }

}
