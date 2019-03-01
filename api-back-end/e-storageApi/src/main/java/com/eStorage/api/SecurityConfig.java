package com.eStorage.api;


import com.eStorage.api.security.AccountLoginAuthenticationProvider;
import com.eStorage.api.security.DeniedPageHandler;
import com.eStorage.api.security.LoginSucessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccountLoginAuthenticationProvider accountLoginAuthenticationProvider;

    @Autowired
    private LoginSucessHandler loginSucessHandler;


    @Bean
    public DeniedPageHandler accessDeniedHandler(){
        return new DeniedPageHandler();
    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()

                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/login")
                .successHandler(loginSucessHandler)
                .permitAll()
                .and()



                .logout()
                .logoutUrl("/logOut")
                .logoutSuccessUrl("/")
                .permitAll()


                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/logOut").permitAll()
                .antMatchers("/admin/**","/api/**").hasAuthority("ADMIN")
                .antMatchers("/owner/**").hasAuthority("USER")
                .and()




                .authenticationProvider(accountLoginAuthenticationProvider)


                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and()
                .headers()
                .frameOptions()
                .sameOrigin();
        ;
    }

}
