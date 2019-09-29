package org.o2.payment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="channel_details")
public class ChannelDetails {
	
	@Id
	@Column
	private String channel_id;
	@Column
	private String description;
	public final String getChannel_id() {
		return channel_id;
	}
	public final void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	public final String getDescription() {
		return description;
	}
	public final void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChannelDetails [channel_id=");
		builder.append(channel_id);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
	
}
