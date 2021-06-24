package es.pedcod.main.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Configuration
@EnableWebSecurity
@Profile("openldap")
@PropertySource("classpath:application-openldap.properties")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter(AccessLevel.PRIVATE)
public class AuthOpenLdapConfig extends WebSecurityConfigurerAdapter {

	/**
	 * The hostname and port to connect. The OU (organizational unit) to add users
	 * included.
	 */
	@Value("${ldap.url}")
	String ctxSourceUrl;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder.ldapAuthentication().userSearchFilter("(uid={0})").contextSource().url(getCtxSourceUrl());
	}
}