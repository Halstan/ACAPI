package com.ac.ac.auth

import com.ac.ac.entity.User
import com.ac.ac.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken
import org.springframework.security.oauth2.common.OAuth2AccessToken
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.security.oauth2.provider.token.TokenEnhancer
import org.springframework.stereotype.Component

@Component
class InfoAditionalToken constructor(
        @Autowired
        val userService: UserService
    ): TokenEnhancer {

    override fun enhance(accessToken: OAuth2AccessToken?, authentication: OAuth2Authentication?): OAuth2AccessToken {
        val user: User = this.userService.findByUsername(authentication!!.name)
        val info: MutableMap<String, Any> = HashMap()

        info["Id"] = user.idUser!!.toString()
        info["Nombre"] = user.name!!.toString()
        info["Apellido"] = user.lastName!!.toString()
        info["Email"] = user.email!!.toString()

        (accessToken as DefaultOAuth2AccessToken).additionalInformation = info

        return accessToken
    }

}