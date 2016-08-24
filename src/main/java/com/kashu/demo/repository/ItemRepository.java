package com.kashu.demo.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.kashu.demo.entity.Item;

public interface ItemRepository extends CassandraRepository<Item>, ItemRepositoryCustom {
	
	@Query("select * from cass_master_item where item_id=?0")
	Item findOneById(UUID id);
}
