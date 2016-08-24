package com.kashu.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
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
import com.kashu.demo.entity.Item;
import com.kashu.demo.entity.UserItem;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CassandraConfig.class)
public class ItemRepositoryTest {
	@Autowired ItemRepository itemRepository;
	@Autowired UserItemRepository userItemRepository;
	@Autowired CassandraOperations template;
	
	@Before
	public void setUp() throws Exception {
		template.truncate("cass_master_item");
		template.truncate("cass_user_item");
	}

	@Test
	public void shouldInsertItem() throws InterruptedException{
		 //given
        UUID itemId = UUIDs.timeBased();
        UUID userId = UUIDs.timeBased();
        String name = "item-1-name";
        String desc = "item-1-desc";
        // TODO: change to DateProvider
        Date startDate = new Date();
        Date endDate = new Date();
        BigDecimal unitPrice = BigDecimal.ONE;
        Integer offeredUnits = 10;
        Integer availableUnits = 8;
        Boolean finished = false;

        Item item = new Item(itemId, userId, name, desc, unitPrice, offeredUnits, availableUnits, startDate, endDate, finished);
        
        //when
        itemRepository.saveItem(item);
        
        //wait 2 seconds
        Thread.sleep(2000);

        //then
        Item foundItem = itemRepository.findOneById(itemId);
        assertThat(foundItem.getId()).isEqualTo(itemId);
        assertThat(foundItem.getName()).isEqualTo("item-1-name");
        
        UserItem foundUserItem = userItemRepository.findOneById(userId, itemId);
        assertThat(foundUserItem).isNotNull();
        assertThat(foundUserItem.getItemId()).isEqualTo(itemId);
        assertThat(foundUserItem.getItemName()).isEqualTo("item-1-name");
       
		
	}
}
