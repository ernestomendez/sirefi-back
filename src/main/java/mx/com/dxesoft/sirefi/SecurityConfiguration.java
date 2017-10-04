package mx.com.dxesoft.sirefi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * sirefi-back, mx.com.dxesoft.sirefi . SecurityConfiguration
 * Created by ernesto on 24/09/17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    private DataSource dataSource;
//
//    @Value("${spring.queries.user-query}")
//    private String userQuery;
//
//    @Value("${spring.queries.roles-query}")
//    private String rolesQuery;

//    @Autowired
//    public SecurityConfiguration(BCryptPasswordEncoder bCryptPasswordEncoder, DataSource dataSource) {
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//        this.dataSource = dataSource;
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").authorities("ADMIN", "USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index.html", "/app/app.js", "/css/**").permitAll()
                .antMatchers("/api/**").hasAnyAuthority("ADMIN")
                .anyRequest().fullyAuthenticated().and()
                .httpBasic().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable();
    }
}
