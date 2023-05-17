package com.studentcatalogservice.controller;

import com.studentcatalogservice.model.*;
import com.studentcatalogservice.service.interfaces.ICatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CatalogController {

    @Autowired
    ICatalogService catalogService;

    @GetMapping("/catalog/course/{courseCode}")
    @ResponseStatus(HttpStatus.OK)
    public Catalog getCatalog(@PathVariable String courseCode){
        return catalogService.getCatalog(courseCode);
    }
}
