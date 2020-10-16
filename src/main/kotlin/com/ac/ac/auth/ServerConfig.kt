package com.ac.ac.auth

/*import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.TokenEnhancer
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore
import java.util.*

@Configuration
@EnableAuthorizationServer
class ServerConfig @Autowired constructor(
        private val authenticationManager: AuthenticationManager,
        private val infoAditionalToken: InfoAditionalToken
    )   : AuthorizationServerConfigurerAdapter(){

    @Value("\${user.oauth.clientId}")
    val clientId: String = ""

    @Value("\${user.oauth.clientSecret}")
    val clientSecret: String = ""

    @Value("\${application.jwt.privateKey}")
    val privateKey: String = ""

    @Value("\${application.jwt.publicKey}")
    val publicKey: String = ""

    override fun configure(security: AuthorizationServerSecurityConfigurer?) {
        security!!.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
    }

    override fun configure(clients: ClientDetailsServiceConfigurer?) {
        clients!!.inMemory().withClient(clientId)
                .secret(clientSecret)
                .scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(3600)
    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer?) {
        val tokenEnhancer = TokenEnhancerChain()
        tokenEnhancer.setTokenEnhancers(listOf(infoAditionalToken, accessTokenConverter()))

        endpoints!!.authenticationManager(authenticationManager)
                .tokenStore(tokenStorage())
                .accessTokenConverter(accessTokenConverter())
                .tokenEnhancer(tokenEnhancer)
    }

    @Bean
    fun tokenStorage(): TokenStore? {
        return JwtTokenStore(accessTokenConverter())
    }

    @Bean
    fun accessTokenConverter(): JwtAccessTokenConverter? {
        val jwtAccessTokenConverter = JwtAccessTokenConverter()
        jwtAccessTokenConverter.setSigningKey(privateKey)
        jwtAccessTokenConverter.setVerifierKey(publicKey)
        return jwtAccessTokenConverter
    }
}*/