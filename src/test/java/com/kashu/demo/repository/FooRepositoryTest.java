package com.kashu.demo.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.kashu.demo.repository.FooRepository;
import com.kashu.demo.config.CassandraConfig;
import com.kashu.demo.entity.Foo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CassandraConfig.class)
public class FooRepositoryTest {
	@Autowired FooRepository fooRepository;
	@Autowired CassandraOperations template;

	@Before
	public void setUp() throws Exception {
		template.truncate("cass_foo");
	}
	
	@Test
    public void shouldInsertFoo() throws Exception {
        //given
        Foo foo = new Foo(39L,"ka","shu");

        //when
        fooRepository.save(foo);
        //Thread.sleep(1000);

        //then
        Foo foundFoo = fooRepository.findOne(39L);
        assertThat(foundFoo.getFirstname()).isEqualTo("ka");
        assertThat(foundFoo.getLastname()).isEqualTo("shu");
    }

}
