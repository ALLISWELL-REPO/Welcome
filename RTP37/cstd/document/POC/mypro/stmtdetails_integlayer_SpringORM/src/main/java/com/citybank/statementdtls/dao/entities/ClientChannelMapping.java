package com.citybank.statementdtls.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client_channel_mapping")
public class ClientChannelMapping {
	@Id
	private int id;
	
	@Column(name="client_id")
	private String clientid;
	
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

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
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
		return "ClientChannelMapping [id=" + id + ", clientid=" + clientid + ", channelid=" + channelid
				+ ", description=" + description + "]";
	}
	
	

}
