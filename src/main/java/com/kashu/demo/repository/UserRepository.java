package com.kashu.demo.repository;

import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;
import com.kashu.demo.entity.User;
import java.util.UUID;

public interface UserRepository extends TypedIdCassandraRepository<User, UUID> {
}