package io.magentys.training.ncp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;
import org.mongodb.morphia.utils.IndexType;

import io.magentys.mvc.authentication.User;

@Entity("messages")
@Indexes({
	@Index(fields = @Field(value = "pubDate", type = IndexType.DESC)),
	@Index(fields = @Field(value = "username"))
	})
public class Message {
	@Id
	private ObjectId id;
	
	@Reference
	private User user;
	
	private String username;
	
	private String text;
	
	private Date pubDate;

	@NotSaved
	private String pubDateStr;
	

	public ObjectId getId() {
		return id;
	}

	public void ObjectId(ObjectId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUser(User user) {
		this.user = user;
		this.username = user.getUsername();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getPubDateStr() {
		if(pubDate != null) {
			pubDateStr = new SimpleDateFormat("yyyy-MM-dd @ HH:mm").format(pubDate);
		}
		return pubDateStr;
	}

}
