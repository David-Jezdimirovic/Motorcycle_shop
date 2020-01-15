/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Lenovo
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;


    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            return bCryptPasswordEncoder;
	}

    //enkripcija sifre
//    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      //  User.UserBuilder users = User.withDefaultPasswordEncoder();
                auth.jdbcAuthentication()
                .dataSource(securityDataSource)
                .usersByUsernameQuery("select email, sifra, aktivan from korisnici where email=?")
                .authoritiesByUsernameQuery("SELECT korisnici.email, uloge.uloga_naziv FROM korisnici JOIN uloge ON korisnici.uloga_id = uloge.uloga_id where korisnici.email=?")
                .passwordEncoder(passwordEncoder());
                                      //"SELECT k.email, u.uloga_naziv FROM korisnici k JOIN uloge u ON k.uloga_id = u.uloga_id where k.email=?"
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/login").permitAll()
////                .antMatchers("/css/**").permitAll()
////                .antMatchers("/img/**").permitAll()
////                .antMatchers("/api/**").permitAll()//error)
//                .antMatchers("/index").permitAll()
//                .antMatchers("/korisnik/**").permitAll()
//                //.antMatchers("/korisnik/registracija").permitAll()
//                //.antMatchers("/korisnik/registrujkorisnika").permitAll()
//               // .antMatchers("/addkorisnik").permitAll()
//               // .antMatchers("/adduloga").permitAll()
//                .antMatchers("/dodajulogu").permitAll()
//                .antMatchers("/saveuloga").permitAll()
//                .antMatchers("/vozilo/**").permitAll()
//                .antMatchers("/api/**").permitAll()
////                .antMatchers("/item/admin/**").hasRole("ADMIN")
////                .antMatchers("/admin/**").hasRole("ADMIN")
////                .antMatchers("/user/**").hasRole("USER")
////                .antMatchers("/users/items").hasRole("USER")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/authenticateTheUser")
//                //.failureUrl("/login?error=true")
//                .defaultSuccessUrl("/dodajulogu")
//                .permitAll().and()
//                .logout().logoutSuccessUrl("/index")
//                .permitAll();
//        http.csrf().disable();

               http.
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/korisnik/**").permitAll()
                .antMatchers("/dodajulogu").hasAuthority("ADMIN")
                //.antMatchers("/saveuloga").hasAuthority("ADMIN")
                .antMatchers("/vozilo/**").hasAuthority("ADMIN")
                .antMatchers("/vozila/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/listaporudzbina").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/api/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/vozila/listamotora")
                .usernameParameter("email")
                .passwordParameter("sifra")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

}

