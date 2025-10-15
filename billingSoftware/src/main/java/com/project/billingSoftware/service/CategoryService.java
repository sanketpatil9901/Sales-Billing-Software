package com.project.billingSoftware.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.billingSoftware.io.CategoryRequest;
import com.project.billingSoftware.io.CategoryResponse;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request, MultipartFile file) throws IOException;

    List<CategoryResponse> read();

    void deleteCategory(String categoryId);
}
