package com.delivery.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {
	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	private int OrderId;

	@Column(name = "userId")
	private int userId;

	@Column(name = "hotelId")
	private int hotelId;

	@Column(name = "foodId")
	private int foodId;

	@Column(name = "orderedTime")
	private LocalDateTime orderedTime;

	@Column(name = "paymentType")
	private String paymentType;

	@Column(name = "actualFoodRate")
	private int actualFoodRate;

	@Column(name = "count")
	private int count;

	@Column(name = "isDelivered")
	private boolean isDelivered;

	@Column(name = "isCanceled")
	private boolean isCanceled;

	@Column(name = "DeviBoyId")
	private int DeviBoyId;

	@Column(name = "deliveryLocation")
	private String deliveryLocation;

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public LocalDateTime getOrderedTime() {
		return orderedTime;
	}

	public void setOrderedTime(LocalDateTime orderedTime) {
		this.orderedTime = orderedTime;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getActualFoodRate() {
		return actualFoodRate;
	}

	public void setActualFoodRate(int actualFoodRate) {
		this.actualFoodRate = actualFoodRate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public int getDeviBoyId() {
		return DeviBoyId;
	}

	public void setDeviBoyId(int deviBoyId) {
		DeviBoyId = deviBoyId;
	}

	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

}
