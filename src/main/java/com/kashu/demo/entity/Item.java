package com.kashu.demo.entity;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Table("cass_master_item")
public class Item {

    @PrimaryKey("item_id")
    private UUID id;

    @Column("user_id")
    private UUID userId;

    @Column("item_name")
    private String name;

    @Column("item_desc")
    private String description;

    @Column("unit_price")
    private BigDecimal unitPrice;

    @Column("offered_units")
    private Integer offeredUnits;

    @Column("available_units")
    private Integer availableUnits;

    @Column("start_date")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date startDate;

    @Column("end_date")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date endDate;

    @Column("auction_finished")
    private Boolean finished;
    
    public Item(){
    	
    }

    public Item(UUID id,UUID userId,String name,String description,BigDecimal unitPrice,Integer offeredUnits,Integer availableUnits,Date startDate,Date endDate,Boolean finished){
    	this.id = id;
    	this.userId = userId;
    	this.name = name;
    	this.description = description;
    	this.unitPrice = unitPrice;
    	this.offeredUnits = offeredUnits;
    	this.availableUnits = availableUnits;
    	this.startDate = startDate;
    	this.endDate = endDate;
    	this.finished = finished;
    }
    
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getOfferedUnits() {
		return offeredUnits;
	}

	public void setOfferedUnits(Integer offeredUnits) {
		this.offeredUnits = offeredUnits;
	}

	public Integer getAvailableUnits() {
		return availableUnits;
	}

	public void setAvailableUnits(Integer availableUnits) {
		this.availableUnits = availableUnits;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}
    

}