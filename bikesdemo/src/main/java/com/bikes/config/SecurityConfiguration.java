package com.bikes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;

/***
 * Tells Java spring this is configuration and it should start when container started
 * Now you may test access in post man and it should not grant access on hasAuthority methods
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Value(value = "${auth0.apiAudience}")//values added to the applications properites files
	private String apiAudience;
	@Value(value = "${auth0.issuer}")
	private String issuer;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    JwtWebSecurityConfigurer
        .forRS256(apiAudience, issuer)//
        .configure(http)
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/api/v1/bikes").permitAll()
        .antMatchers(HttpMethod.GET, "/api/v1/bikes").hasAuthority("view:registrations")//scopes
        //created in the dashboard that require authentication 
        .antMatchers(HttpMethod.GET, "/api/v1/bikes/**").hasAuthority("view:registration")
        .anyRequest().authenticated();
	}

}