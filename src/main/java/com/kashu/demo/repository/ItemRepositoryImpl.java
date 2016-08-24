package com.kashu.demo.repository;

import com.datastax.driver.core.BatchStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.kashu.demo.entity.Item;
import com.kashu.demo.repository.ItemRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;


public class ItemRepositoryImpl implements ItemRepositoryCustom {

    @Autowired
    private CassandraOperations cassandraOperations;

    @Override
    public void saveItem(Item item) {
        Session session = cassandraOperations.getSession();
        BatchStatement batch = new BatchStatement();
        PreparedStatement masterItemPs = 
        		session.prepare("insert into cass_master_item "
        				+ "(item_id, user_id, item_name, item_desc, unit_price, offered_units, available_units, start_date, end_date, auction_finished) "
        				+ "values (?,?,?,?,?,?,?,?,?,?);");
        PreparedStatement userItemPs = 
        		session.prepare("insert into cass_user_item "
        				+ "(user_id, item_id, auction_finished, available_units, end_date, item_name, unit_price) "
        				+ "values (?,?,?,?,?,?,?);");
        batch.add(masterItemPs.bind(
        		item.getId(),item.getUserId(),item.getName(),
        		item.getDescription(),item.getUnitPrice(),item.getOfferedUnits(),
        		item.getAvailableUnits(),item.getStartDate(),item.getEndDate(),item.getFinished()
        		));
        batch.add(userItemPs.bind(
        		item.getUserId(),item.getId(),item.getFinished(),
        		item.getAvailableUnits(),item.getEndDate(),item.getName(),item.getUnitPrice()
        		));
        session.execute(batch);
        //session.close();
    }

    
}
