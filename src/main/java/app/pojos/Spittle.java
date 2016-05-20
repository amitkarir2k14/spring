package app.pojos;

import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.sun.istack.internal.NotNull;

@Component
public class Spittle {
	private String id;
	@NotNull
	@Size(min = 15, max = 1000)
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Spittle() {
	}

	public Spittle(String message, Date date) {
		super();
		this.message = message;
		this.date = date;
	}

	private Date date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
