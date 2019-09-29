package com.citybank.statementdtls.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="channel_details")
public class ChannelDetails {
	@Id
	private int id;
	
	@Column(name="channel_id")
	private String channelid;
	
	@Column(name="desc")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChannelid() {
		return channelid;
	}

	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ChannelDetails [id=" + id + ", channelid=" + channelid + ", description=" + description + "]";
	}
	
 
}
