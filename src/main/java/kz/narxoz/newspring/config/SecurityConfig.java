package kz.narxoz.newspring.config;

import kz.narxoz.newspring.services.UserService;
import kz.narxoz.newspring.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public UserService userService(){
    return new UserServiceImpl();
  }

  @Bean
public BCryptPasswordEncoder passwordEncoder(){
  return new BCryptPasswordEncoder();
}

  @Autowired
  private UserService userService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.exceptionHandling().accessDeniedPage("/403");

    http.authorizeRequests().antMatchers("/","/css/","/js/**").permitAll();

    http.formLogin()
        .loginPage("/login").permitAll()
        .usernameParameter("user_email")
        .passwordParameter("user_password")
        .loginProcessingUrl("/auth")
        .failureUrl("/login?error")
        .defaultSuccessUrl("/profile");

    http.logout()
        .logoutUrl("/logout").permitAll()
        .logoutSuccessUrl("/login");




  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService);
  }
}
