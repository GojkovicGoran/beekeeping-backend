package c.ba.beekeeping.domain;

import c.ba.beekeeping.config.LocalDateDeserializer;
import c.ba.beekeeping.config.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Beehive {

	@Id
	@GeneratedValue
	private Integer id;
	private String type;
	private int number;
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@Column(name = "created_at")
	private LocalDate createdAt;
	private String description;
	@Column(name = "queen_color")
	private String queenColor;
	private int honey;
	private String notice;

	@ManyToOne
	@JoinColumn(name = "apiary_site_id")
	private ApiarySite apiarySite;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQueenColor() {
		return queenColor;
	}

	public void setQueenColor(String queenColor) {
		this.queenColor = queenColor;
	}

	public int getHoney() {
		return honey;
	}

	public void setHoney(int honey) {
		this.honey = honey;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public ApiarySite getApiarySite() {
		return apiarySite;
	}

	public void setApiarySite(ApiarySite apiarySite) {
		this.apiarySite = apiarySite;
	}
}
