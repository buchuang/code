package com.nyist.microserviceprovideruser.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.nyist.microserviceprovideruser.entity.User;

@Repository
@Mapper
public interface UserRepository{

	public User findById(String id);
}
