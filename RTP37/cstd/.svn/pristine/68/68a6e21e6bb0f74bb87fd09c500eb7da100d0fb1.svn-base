package com.citybank.statementdtls.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="channel_details")
public class ChannelDetails {
	@Id
	@Column
	protected int id;
	@Column(name="channel_id")
	protected String ChannelId;
	@Column(name="description")
	protected String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChannelId() {
		return ChannelId;
	}

	public void setChannelId(String channelId) {
		ChannelId = channelId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
