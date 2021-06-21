package com.application.project3.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService detailsService;


    @Override
    protected void configure (HttpSecurity http) throws Exception {

        http.authorizeRequests()/*.antMatchers("/", "/**").hasRole("ADMIN")*/



                    .antMatchers("/login", "/registration", "/resetpassword", "/forgotpassword", "/javascript/**", "/css/**")
                        .permitAll().antMatchers("/**").hasAnyRole("ADMIN", "STUDENT")
//                    .antMatchers("/student/**")
//                        .hasRole("STUDENT")
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .usernameParameter("userId")
                            .permitAll()
                    .and()
                        .logout()
                        .logoutSuccessUrl("/login");
        }

        @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{

            auth.userDetailsService(detailsService).passwordEncoder(encoder());
        }

        @Bean
        public PasswordEncoder encoder(){

        return new BCryptPasswordEncoder();
        }
    }

