package com.chandra.spring.springbootjpah2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chandra.spring.springbootjpah2.entity.Order;

@Repository
public interface OrderRepostiroty extends CrudRepository<Order, String> {

}
