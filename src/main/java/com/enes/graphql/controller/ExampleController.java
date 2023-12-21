package com.enes.graphql.controller;

import com.enes.graphql.model.Item;
import com.enes.graphql.repository.ItemRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ExampleController {

    private final ItemRepository itemRepository;

    public ExampleController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @QueryMapping
    public List<Item> getAllItems() {
        return this.itemRepository.findAll();
    }

    @MutationMapping
    public Item createItem(@Argument Item item) {
        return this.itemRepository.save(item);
    }

}
