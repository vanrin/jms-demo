package com.thetinydev.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vanrin on 12/24/16.
 */
@RestController
public class UserController {

    @RequestMapping({ "/user", "/me" })
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return map;
    }

}
