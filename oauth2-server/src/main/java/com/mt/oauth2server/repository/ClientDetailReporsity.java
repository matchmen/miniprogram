package com.mt.oauth2server.repository;

import com.mt.oauth2server.entity.ClientDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: liqm
 * 2019-08-26
 */
public interface ClientDetailReporsity extends JpaRepository<ClientDetail,ClientDetail> {

    ClientDetail findByClientId(String clientId);

}
