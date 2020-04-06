package com.appdevelopbog.app.ws.demo.service;

import com.appdevelopbog.app.ws.demo.shared.dto.AccountDto;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto acountDto);
    AccountDto activeAccount(String aid, AccountDto accountDto);
    AccountDto updateAccount(String aid, AccountDto accountDto);
    AccountDto deleteAccount(String aid);
    List<AccountDto> viewAllAccounts();
    AccountDto viewAccountDetails(String aid);
    List<AccountDto> searchAccounts(String keyWord);
}
