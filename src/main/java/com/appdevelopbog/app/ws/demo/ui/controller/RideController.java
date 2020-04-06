package com.appdevelopbog.app.ws.demo.ui.controller;

import com.appdevelopbog.app.ws.demo.shared.dto.RideDto;
import com.appdevelopbog.app.ws.demo.ui.model.request.RideDetailsRequestModel;
import com.appdevelopbog.app.ws.demo.ui.model.response.RideRest;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("rides")
public class RideController {

    @PostMapping
    public RideRest createRider(@Valid @RequestBody RideDetailsRequestModel rideDetails, BindingResult result){
        if(result.hasErrors()) throw new RideServiceException();
        RideDto ridedto = new RideDto();
        BeanUtils.copyProperties(rideDetails,ridedto);
    }

}
