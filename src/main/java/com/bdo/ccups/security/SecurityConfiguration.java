package com.bdo.ccups.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// @EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  
  @Autowired
  CCUPSUserDetailsService ccupsUserDetailsService;

  @Autowired
	private JwtRequestFilter jwtRequestFilter;
  /**
   * This section defines the user accounts which can be used for
   * authentication as well as the roles each user has.
   */
  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {

    // auth.inMemoryAuthentication()
    //   .withUser("a012001164").password("{noop}password").roles("USER").and()
    //   .withUser("ollie").password("gierke").roles("USER", "ADMIN");
      auth.userDetailsService(ccupsUserDetailsService).passwordEncoder(passwordEncoder());
  }
  @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
  }
  
  @Bean
  @Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
  /**
   * This section defines the security policy for the app.
   * - BASIC authentication is supported (enough for this REST-based demo)
   * - /employees is secured using URL security shown below
   * - CSRF headers are disabled since we are only testing the REST interface,
   *   not a web one.
   *
   * NOTE: GET is not shown which defaults to permitted.
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // http 
    //   .csrf().disable()
    //   .authorizeRequests()
      
    //   .antMatchers(HttpMethod.GET,"/api/**").permitAll();
      //   .antMatchers(HttpMethod.POST,"/api/applications/actions/**").hasRole("ADMIN")
      //   .antMatchers(HttpMethod.PUT, "/api/applications/actions/**").hasRole("ADMIN")
      //   .antMatchers(HttpMethod.PATCH, "/api/applications/actions/**").hasRole("ADMIN")
        // .antMatchers("/api/authenticate").permitAll().anyRequest().authenticated().and()
        // .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				// .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // .anyRequest().authenticated().and()
        
      // .csrf().disable();

    http
    .csrf().disable()
				// dont authenticate this particular request
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS,"/api/**").permitAll()
        .antMatchers("/h2-console/**").permitAll()
        .antMatchers("/api/authenticate").permitAll().
				// all other requests need to be authenticated
				anyRequest().authenticated().and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http.headers().frameOptions().sameOrigin();
  }
}