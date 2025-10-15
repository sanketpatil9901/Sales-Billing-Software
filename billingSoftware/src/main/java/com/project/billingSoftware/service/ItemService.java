package com.project.billingSoftware.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.billingSoftware.io.ItemRequest;
import com.project.billingSoftware.io.ItemResponse;

public interface  ItemService {
    ItemResponse add(ItemRequest request, MultipartFile file) throws IOException;

    List<ItemResponse> fetchItems();

    void deleteItem(String itemId);
}
