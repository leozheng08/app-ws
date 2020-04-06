package com.appdevelopbog.app.ws.demo.ui.controller;


import com.appdevelopbog.app.ws.demo.exceptions.AccountServiceException;
import com.appdevelopbog.app.ws.demo.service.AccountService;
import com.appdevelopbog.app.ws.demo.shared.dto.AccountDto;

import com.appdevelopbog.app.ws.demo.ui.model.request.AccountDetailsRequestModel;
import com.appdevelopbog.app.ws.demo.ui.model.response.AccountErrorMessage;
import com.appdevelopbog.app.ws.demo.ui.model.response.AccountRest;

import com.appdevelopbog.app.ws.demo.ui.model.response.AccountRestForDetails;
import com.appdevelopbog.app.ws.demo.ui.model.response.AccountRestForView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Accounts")
public class AccountController {

    @Autowired
    AccountService accountService;


    @PostMapping
    public ResponseEntity<AccountRest> createAccount(@Valid @RequestBody AccountDetailsRequestModel accountDetails, BindingResult result) throws Exception {
        if(result.hasErrors())  throw new AccountServiceException("Invalid "+result.getFieldError().getField(),HttpStatus.BAD_REQUEST,"/Accounts");
        AccountRest returnValue = new AccountRest();
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(accountDetails,accountDto);
        accountDto.setCreatedDate();
        AccountDto createdAccount = accountService.createAccount(accountDto);
        BeanUtils.copyProperties(createdAccount,returnValue);
        return new ResponseEntity<AccountRest>(returnValue,HttpStatus.OK);
    }

    @PutMapping(path = "/{aid}/status")
    public ResponseEntity<AccountRest> activeAccount(@Valid @RequestBody AccountDetailsRequestModel accountDetails, BindingResult result, @PathVariable("aid") String aid) {
        if(result.hasErrors()) throw new AccountServiceException("Invalid "+result.getFieldError().getField(),HttpStatus.BAD_REQUEST,"/Accounts/"+aid+"/status");
        AccountRest returnValue = new AccountRest();
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(accountDetails,accountDto);
        if(!accountDto.getIsActived()) throw new AccountServiceException("Invalid value for isActived", HttpStatus.BAD_REQUEST, "/Accounts/"+aid+"/status");
        AccountDto activedAccount = accountService.activeAccount(aid,accountDto);
        BeanUtils.copyProperties(activedAccount,returnValue);
        return new ResponseEntity<AccountRest>(HttpStatus.OK);

    }

    @PutMapping(path = "/{aid}")
    public ResponseEntity<AccountRest> UpdateAccount(@Valid @RequestBody AccountDetailsRequestModel accountDetails, BindingResult result, @PathVariable("aid") String aid){
        if(result.hasErrors()) throw new AccountServiceException("Invalid "+result.getFieldError().getField(),HttpStatus.BAD_REQUEST,"/Accounts/"+aid);
        AccountRest returnValue = new AccountRest();
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(accountDetails,accountDto);
        AccountDto updatedAccount = accountService.updateAccount(aid,accountDto);
        BeanUtils.copyProperties(updatedAccount,returnValue);
        return new ResponseEntity<AccountRest>(HttpStatus.OK);

    }


    @DeleteMapping(path = "/{aid}")
    public ResponseEntity<AccountRest> deleteAccount(@PathVariable("aid") String aid) {
        AccountRest returnValue = new AccountRest();
        AccountDto deletedAccount = accountService.deleteAccount(aid);
        BeanUtils.copyProperties(deletedAccount,returnValue);
        return new ResponseEntity<AccountRest>(HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<AccountRestForView>> ViewAllAccounts() {
        List<AccountRestForView> returnValues = new ArrayList<>();
        List<AccountDto> accountDtos =  accountService.viewAllAccounts();
        for(AccountDto ele : accountDtos){
            AccountRestForView returnValue = new AccountRestForView();
            returnValue.setAid(ele.getAid());
            returnValue.setName(ele.getFirstName()+" "+ele.getLastName());
            returnValue.setCreatedDate(ele.getCreatedDate());
            returnValue.setActived(ele.getIsActived());
            returnValues.add(returnValue);
        }
        return new ResponseEntity<List<AccountRestForView>>(returnValues, HttpStatus.OK);
    }

    @GetMapping(path = "/{aid}")
    public ResponseEntity<AccountDto> ViewAccountDetails(@PathVariable("aid") String aid) {
        AccountDto accountDto = accountService.viewAccountDetails(aid);
        return  new ResponseEntity<>(accountDto, HttpStatus.OK);

    }

    @GetMapping(params = {"key"})
    public ResponseEntity<List<AccountRestForView>> searchAccounts(@RequestParam(value = "key", defaultValue = "") String keyWord) {
        if(keyWord.length()==0) return ViewAllAccounts();
        List<AccountRestForView> returnValues = new ArrayList<>();
        List<AccountDto> accountDtos = accountService.searchAccounts(keyWord);
        for(AccountDto ele : accountDtos){
            AccountRestForView returnValue = new AccountRestForView();
            returnValue.setAid(ele.getAid());
            returnValue.setName(ele.getFirstName()+" "+ele.getLastName());
            returnValue.setCreatedDate(ele.getCreatedDate());
            returnValue.setActived(ele.getIsActived());
            returnValues.add(returnValue);
        }
        return new ResponseEntity<>(returnValues, HttpStatus.OK);

    }



}