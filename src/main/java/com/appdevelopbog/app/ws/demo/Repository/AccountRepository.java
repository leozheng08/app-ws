package com.appdevelopbog.app.ws.demo.Repository;

import com.appdevelopbog.app.ws.demo.io.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    AccountEntity findByAid(String aid);
    void deleteByAid(String aid);
    Iterable<AccountEntity> findAllByPhone(String keyWord);
    Iterable<AccountEntity> findAllByFirstName(String keyWord);
    Iterable<AccountEntity> findAllByLastName(String keyWord);
}
