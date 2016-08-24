package com.kashu.demo.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;


@Table("cass_user_item")
public class UserItem {

	@PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private UUID userId;
	
	@PrimaryKeyColumn(name = "item_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
	private UUID itemId;

    @Column("auction_finished")
    private Boolean auctionFinished;
    
    @Column("available_units")
    private Integer availableUnits;

    @Column("end_date")
    private Date endDate;
    
    @Column("item_name")
    private String itemName;
    
	@Column("unit_price")
	private BigDecimal unitPrice;
    
	@Deprecated
	public UserItem(){
		
	}
	
	public UserItem(UUID userId,UUID itemId,Boolean auctionFinished,Integer availableUnits,Date endDate,String itemName,BigDecimal unitPrice){
		this.userId = userId;
		this.itemId = itemId;
		this.auctionFinished = auctionFinished;
		this.availableUnits = availableUnits;
		this.endDate = endDate;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public UUID getItemId() {
		return itemId;
	}

	public void setItemId(UUID itemId) {
		this.itemId = itemId;
	}

	public Boolean getAuctionFinished() {
		return auctionFinished;
	}

	public void setAuctionFinished(Boolean auctionFinished) {
		this.auctionFinished = auctionFinished;
	}

	public Integer getAvailableUnits() {
		return availableUnits;
	}

	public void setAvailableUnits(Integer availableUnits) {
		this.availableUnits = availableUnits;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
