package com.nihao.elastic_demo.dao;

import com.nihao.elastic_demo.entity.Bidding_application;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface BiddingApplicationMapper {
    @Select("SELECT * FROM bidding_application")
    List<Bidding_application> findAll();
}
