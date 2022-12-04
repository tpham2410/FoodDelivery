package com.cybersoft.food_project.security;

import com.cybersoft.food_project.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SeSecurityConfig {

    @Autowired
    CustomAuthenProvider customAuthenProvider;
    /*
        Tao danh sach users in Memory
     */

    @Autowired
    JwtTokenFilter jwtTokenFilter;


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws  Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder =
                httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(customAuthenProvider);

        return authenticationManagerBuilder.build();
    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailService(){
//        UserDetails user1 = User.withUsername("Nguyen Van A")
//                .password(passwordEncoder().encode("123"))
//                .roles("USER").build();
//
//        UserDetails user2 = User.withUsername("Nguyen Van B")
//                .password(passwordEncoder().encode("admin123"))
//                .roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }

    /*
        Kieu ma hoa password
     */

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*
        Cau hinh spring security
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        /*
           antMatchers: định nghĩa link cần xác thực
           authenticated: bắc buộc chứng thực đăng nhập
           permitAll: cho phép full quyền đăng nhập vào link chỉ định ở antMachers
           anyRequest: toàn bộ gọi vào API
         */

        httpSecurity.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/signin").permitAll()
                .antMatchers("/refresh-token").permitAll()
                .antMatchers("/signin/test").authenticated()
                .anyRequest().authenticated();


        //Add filter A trước cái gì đó
        httpSecurity.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();

    }

}
