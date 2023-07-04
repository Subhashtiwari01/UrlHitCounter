package com.project.URLHitConter.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlService {
    int count=0;

    Map<String,Integer> hm=new HashMap<>();



    public int getHitCount() {
        return ++count;
    }

    public int getHitCountByName(String username) {
        int hitCount=hm.getOrDefault(username,0);
        hm.put(username,++hitCount);
        return hitCount;

    }
}
