package com.example.appcrud.mapper;

public interface IMapper<I, O> {
    public O map(I input);
}
