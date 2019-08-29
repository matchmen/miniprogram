package com.mt.oauth2server.suports;

import com.mt.oauth2server.entity.ClientDetail;
import com.mt.oauth2server.repository.ClientDetailReporsity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * author: liqm
 * 2019-08-26
 */
@Component
public class MyClientDetailsService implements ClientDetailsService {


    @Autowired
    private ClientDetailReporsity clientDetailReporsity;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {


        ClientDetail clientDetail = clientDetailReporsity.findByClientId(clientId);

        if(Objects.isNull(clientDetail)){
            return null;
        }

        BaseClientDetails baseClientDetails = new BaseClientDetails();
//                clientId,
//                clientDetail.getSecret(),
//                clientDetail.getScope(),
//                clientDetail.getGrantType(),
//                "",
//                clientDetail.getRedirectUrl());

        baseClientDetails.setClientId(clientDetail.getClientId());
        baseClientDetails.setAuthorizedGrantTypes(Arrays.asList(clientDetail.getGrantType()));
        Set<String> stringSet = new HashSet<>();
        stringSet.add(clientDetail.getRedirectUrl());
        baseClientDetails.setRegisteredRedirectUri(stringSet);
        baseClientDetails.setAutoApproveScopes(Arrays.asList("true"));
        baseClientDetails.setClientSecret(clientDetail.getSecret());
        baseClientDetails.setScope(Arrays.asList(clientDetail.getScope()));
        //baseClientDetails.setAutoApproveScopes(StringUtils.commaDelimitedListToSet(scopes));

        return baseClientDetails;
    }
}
