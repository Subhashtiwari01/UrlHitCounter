package com.project.URLHitConter.Controller;


import com.project.URLHitConter.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlController {
    @Autowired
    UrlService urlService;




    @GetMapping("count")

    public Map<String,Integer> getHitCount(){
        int count=urlService.getHitCount();

        Map<String,Integer> totalCount=new HashMap<>();
        totalCount.put("visitors",count);
        return totalCount;

    }
    @GetMapping("username/{username}/count")

    public Map<String,String> getUserHitCount(@PathVariable String username){
        int count=urlService.getHitCountByName(username);

        Map<String,String> response=new HashMap<>();
        response.put("username",username);
        response.put("hitcount",String.valueOf(count));
        return response;
    }



}
