package org.o2.payment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client_details")
public class ClientDetails {
	
	@Id
	@Column
	private String client_id;
	@Column
	private String description;
	
	public final String getClient_id() {
		return client_id;
	}
	public final void setClient_id(String client_id) {
		this.client_id = client_id;
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
		builder.append("ClientDetails [client_id=");
		builder.append(client_id);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
	 
}
