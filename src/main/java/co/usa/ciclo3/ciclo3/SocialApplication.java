/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
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
