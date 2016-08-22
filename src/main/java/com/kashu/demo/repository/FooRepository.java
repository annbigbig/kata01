package com.kashu.demo.repository;

import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;
import com.kashu.demo.entity.Foo;

public interface FooRepository extends TypedIdCassandraRepository<Foo, Long> {
}