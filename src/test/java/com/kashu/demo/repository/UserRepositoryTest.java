package com.kashu.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.datastax.driver.core.utils.UUIDs;
import com.kashu.demo.config.CassandraConfig;
import com.kashu.demo.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CassandraConfig.class)
public class UserRepositoryTest {
	@Autowired UserRepository userRepository;
	@Autowired CassandraOperations template;
	
	@Before
	public void setUp() throws Exception {
		template.truncate("cass_user");
	}

	@Test
    public void shouldInsertUser() throws Exception {
        //given
        UUID uuid = UUIDs.timeBased();
        String login = "cassandra_kata";
        int age = 34;
        User user = new User(uuid, login, age);

        //when
        userRepository.save(user);
        //Thread.sleep(1000);

        //then
        User foundUser = userRepository.findOne(uuid);
        assertThat(foundUser.getLogin()).isEqualTo(login);
        assertThat(foundUser.getAge()).isEqualTo(age);
    }
	
}
