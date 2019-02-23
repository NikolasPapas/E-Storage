package com.eStorage.api;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AccountLoginAuthenticationProvider accountLoginAuthenticationProvider;
//
//    @Autowired
//    private LoginSucessHandler loginSucessHandler;
//
//
//    @Bean
//    public DeniedPageHandler accessDeniedHandler(){
//        return new DeniedPageHandler();
//    }
//

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()

                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/login")
//                .successHandler(loginSucessHandler)
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
                /*.antMatchers("/admin/*").hasAuthority("ADMIN")
                .antMatchers("/admin/repairs/*").hasAuthority("ADMIN")
                .antMatchers("/admin/owners/*").hasAuthority("ADMIN")*/
                .antMatchers("/owner/**").hasAuthority("USER")
                .and()




//                .authenticationProvider(accountLoginAuthenticationProvider)
//
//
//                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
//                .and()
                .headers()
                .frameOptions()
                .sameOrigin();
        ;
    }

}
