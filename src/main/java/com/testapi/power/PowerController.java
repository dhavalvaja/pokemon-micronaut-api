package com.testapi.power;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;
import java.util.logging.Logger;

@Controller("/power")
public class PowerController {

    private final PowerService powerService;

    public PowerController(PowerService powerService) {
        this.powerService = powerService;
    }

    @Get()
    public List<Power> getPowerList(){
        return powerService.getAll();
    }

    @Post()
    public HttpResponse<Power> create(@Body PowerForm power){
        Power savedPower = powerService.create(power);
        return HttpResponse.created(savedPower);
    }

}
