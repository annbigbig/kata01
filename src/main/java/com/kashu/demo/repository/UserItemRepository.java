package com.kashu.demo.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.kashu.demo.entity.UserItem;

public interface UserItemRepository extends CassandraRepository<UserItem>{

	@Query("select * from cass_user_item where user_id=?0 and item_id=?1")
	UserItem findOneById(UUID userId,UUID itemId);
	
	@Query("select * from cass_user_item where user_id=?0")
	Iterable<UserItem> findListByUser(UUID userId);
}
