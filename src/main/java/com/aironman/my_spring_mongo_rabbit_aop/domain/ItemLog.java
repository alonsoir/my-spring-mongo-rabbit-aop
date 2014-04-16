package com.aironman.my_spring_mongo_rabbit_aop.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents an item log entity
 * 
 * @author aironman
 */
@Document
public class ItemLog implements Serializable {

	private static final long serialVersionUID = 1326887243102331826L;
	
	@Id
	private String id;
	
	private Date dateAccesed;
	
	private String name;
	private String description;
	private String prize;
	
	public ItemLog(Date dateAccesed, String name, String description, String prize) {
		super();
		this.dateAccesed = dateAccesed;
		this.name = name;
		this.description = description;
		this.prize = prize;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDateAccesed() {
		return dateAccesed;
	}
	public void setDateAccesed(Date dateAccesed) {
		this.dateAccesed = dateAccesed;
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
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	@Override
	public String toString() {
		return "Items [dateAccesed=" + dateAccesed + ", name=" + name + ", description=" + description + ", prize="
				+ prize + " id= " + id +"]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateAccesed == null) ? 0 : dateAccesed.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((prize == null) ? 0 : prize.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemLog other = (ItemLog) obj;
		if (dateAccesed == null) {
			if (other.dateAccesed != null)
				return false;
		} else if (!dateAccesed.equals(other.dateAccesed))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (prize == null) {
			if (other.prize != null)
				return false;
		} else if (!prize.equals(other.prize))
			return false;
		return true;
	}
	
	
}
