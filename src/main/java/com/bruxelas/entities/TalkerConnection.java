package com.bruxelas.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bruxelas.helpers.CalendarToStringSerializerHelpser;
import com.bruxelas.helpers.StringToCalendarDeserializerHelper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class TalkerConnection {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Talker talker;

	@ManyToOne
	private Connection connection;

	private Boolean status;

	@Enumerated(EnumType.STRING)
	private RequestedType requested;

	@JsonSerialize(using = CalendarToStringSerializerHelpser.class)
	@JsonDeserialize(using = StringToCalendarDeserializerHelper.class)
	@Temporal(TemporalType.DATE)
	private Calendar dateRequested = Calendar.getInstance();

	@JsonSerialize(using = CalendarToStringSerializerHelpser.class)
	@JsonDeserialize(using = StringToCalendarDeserializerHelper.class)
	@Temporal(TemporalType.DATE)
	private Calendar dateResponsed;

	public TalkerConnection() {
	}

	public TalkerConnection(Long id, Talker talker, Connection connection, Boolean status, RequestedType requested) {
		this.id = id;
		this.talker = talker;
		this.connection = connection;
		this.status = status;
		this.requested = requested;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Talker getTalker() {
		return talker;
	}

	public void setTalker(Talker talker) {
		this.talker = talker;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public RequestedType getRequested() {
		return requested;
	}

	public void setRequested(RequestedType requested) {
		this.requested = requested;
	}

	public Calendar getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(Calendar dateRequested) {
		this.dateRequested = dateRequested;
	}

	public Calendar getDateResponsed() {
		return dateResponsed;
	}

	public void setDateResponsed(Calendar dateResponsed) {
		this.dateResponsed = dateResponsed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TalkerConnection other = (TalkerConnection) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		return "TalkerConnection [id=" + id + ", talker=" + talker + ", connection=" + connection + ", status=" + status
				+ ", requested=" + requested + ", dateRequested=" + dateFormat.format(dateRequested.getTime()) 
				+ ", dateResponsed=" + dateFormat.format(dateResponsed.getTime())
				+ "]";
	}

}
