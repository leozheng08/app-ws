package com.appdevelopbog.app.ws.demo.service.impl;


import com.appdevelopbog.app.ws.demo.Repository.AccountRepository;
import com.appdevelopbog.app.ws.demo.exceptions.AccountServiceException;
import com.appdevelopbog.app.ws.demo.io.entity.AccountEntity;
import com.appdevelopbog.app.ws.demo.service.AccountService;

import com.appdevelopbog.app.ws.demo.shared.Utils;
import com.appdevelopbog.app.ws.demo.shared.dto.AccountDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    Utils utils;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        AccountEntity accountEntity = new AccountEntity();
        BeanUtils.copyProperties(accountDto,accountEntity);
        String aid = utils.generateAid(3);
        accountEntity.setAid(aid);
        AccountEntity storedAccountDetails = accountRepository.save(accountEntity);
        AccountDto returnValue = new AccountDto();
        BeanUtils.copyProperties(storedAccountDetails, returnValue);
        return returnValue;
    }

    @Override
    public AccountDto activeAccount(String aid, AccountDto accountDto) {
        AccountEntity accountEntity = accountRepository.findByAid(aid);
        if(accountEntity==null) throw new AccountServiceException("Invalid Aid",HttpStatus.NOT_FOUND,"/Accounts/"+aid+"/status");
        accountEntity.setIsActived(accountDto.getIsActived());
        AccountEntity storedAccountDetails = accountRepository.save(accountEntity);
        AccountDto returnValue = new AccountDto();
        BeanUtils.copyProperties(storedAccountDetails, returnValue);
        return returnValue;
    }

    @Override
    public AccountDto updateAccount(String aid, AccountDto accountDto) {
        AccountEntity accountEntity = accountRepository.findByAid(aid);
        if(accountEntity==null) throw new AccountServiceException("Invalid Aid",HttpStatus.NOT_FOUND,"/Accounts/"+aid);
        accountEntity.setFirstName(accountDto.getFirstName());
        accountEntity.setLastName(accountDto.getLastName());
        accountEntity.setPhone(accountDto.getPhone());
        accountEntity.setPicture(accountDto.getPicture());
        accountEntity.setIsActived(accountEntity.getIsActived());
        AccountEntity storedAccountDetails = accountRepository.save(accountEntity);
        AccountDto returnValue = new AccountDto();
        BeanUtils.copyProperties(storedAccountDetails, returnValue);
        return returnValue;

    }

    @Override
    public AccountDto deleteAccount(String aid) {
        AccountEntity accountEntity = accountRepository.findByAid(aid);
        if(accountEntity==null) throw new AccountServiceException("Invalid Aid",HttpStatus.NOT_FOUND,"/Accounts/"+aid);
        accountRepository.delete(accountEntity);
        AccountDto returnValue = new AccountDto();
        BeanUtils.copyProperties(accountEntity, returnValue);
        return returnValue;
    }

    @Override
    public List<AccountDto> viewAllAccounts() {
        List<AccountDto> returnValues = new ArrayList<>();
        Iterable<AccountEntity> storedAccounts = accountRepository.findAll();
        for(AccountEntity ele : storedAccounts){
            AccountDto returnValue = new AccountDto();
            BeanUtils.copyProperties(ele, returnValue);
//            returnValue.setCreatedDate(returnValue.getCreatedDate());
            returnValues.add(returnValue);
        }
        return returnValues;
    }

    @Override
    public AccountDto viewAccountDetails(String aid) {
        AccountEntity accountEntity = accountRepository.findByAid(aid);
        if(accountEntity==null) throw new AccountServiceException("Invalid Aid",HttpStatus.NOT_FOUND,"/Accounts/"+aid);
        AccountDto returnvalue = new AccountDto();
        BeanUtils.copyProperties(accountEntity,returnvalue);
        return returnvalue;
    }

    @Override
    public List<AccountDto> searchAccounts(String keyWord) {
        Map<Long,AccountEntity> map = new HashMap<>();
        List<AccountDto> returnValues = new ArrayList<>();
        Iterable<AccountEntity> storedAccounts = accountRepository.findAllByPhone(keyWord);
        Iterator<AccountEntity> storeAccountsIts = storedAccounts.iterator();
        while(storeAccountsIts.hasNext()){
            AccountEntity accountEntity = storeAccountsIts.next();
            if(!map.containsKey(accountEntity.getId())){
                map.put(accountEntity.getId(),accountEntity);
            }

        }
        Iterable<AccountEntity> storedAccounts2 = accountRepository.findAllByFirstName(keyWord);
        Iterator<AccountEntity> storeAccountsIts2 = storedAccounts2.iterator();
        while(storeAccountsIts2.hasNext()){
            AccountEntity accountEntity = storeAccountsIts2.next();
            if(!map.containsKey(accountEntity.getId())){
                map.put(accountEntity.getId(),accountEntity);
            }
        }
        Iterable<AccountEntity> storedAccounts3 = accountRepository.findAllByLastName(keyWord);
        Iterator<AccountEntity> storeAccountsIts3 = storedAccounts3.iterator();
        while(storeAccountsIts3.hasNext()){
            AccountEntity accountEntity = storeAccountsIts3.next();
            if(!map.containsKey(accountEntity.getId())){
                map.put(accountEntity.getId(),accountEntity);
            }
        }
        for(Map.Entry<Long,AccountEntity> ele : map.entrySet()){
            AccountDto returnValue = new AccountDto();
            BeanUtils.copyProperties(ele.getValue(),returnValue);
            returnValues.add(returnValue);
        }

        return returnValues;
    }


}
