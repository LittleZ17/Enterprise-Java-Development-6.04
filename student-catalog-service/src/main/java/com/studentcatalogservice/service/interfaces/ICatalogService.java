package com.studentcatalogservice.service.interfaces;

import com.studentcatalogservice.model.Catalog;

public interface ICatalogService {
    Catalog getCatalog(String courseCode);
}
