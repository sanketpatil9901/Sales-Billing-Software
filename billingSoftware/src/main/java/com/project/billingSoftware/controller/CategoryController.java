package com.project.billingSoftware.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.billingSoftware.io.CategoryRequest;
import com.project.billingSoftware.io.CategoryResponse;
import com.project.billingSoftware.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/admin/categories")
    public ResponseEntity<CategoryResponse> addcategory(@RequestPart("category") String Request, 
                                        @RequestPart("file") MultipartFile file) throws IOException{
        try {
        ObjectMapper mapper = new ObjectMapper();
        CategoryRequest categoryRequest = mapper.readValue(Request, CategoryRequest.class);
        CategoryResponse categoryResponse = categoryService.add(categoryRequest, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
        } catch(JsonProcessingException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exception occured while Parsing the json");
        }
    }

    @GetMapping("/categories")
    public List<CategoryResponse> fetchCategories() {
        return categoryService.read();
    }

    @DeleteMapping("admin/categories/{categoryId}")
    public ResponseEntity<String> removeCategory(@PathVariable String categoryId) {
        try {
            categoryService.deleteCategory(categoryId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
