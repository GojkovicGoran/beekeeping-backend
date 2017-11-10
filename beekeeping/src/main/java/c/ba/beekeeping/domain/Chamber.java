package c.ba.beekeeping.domain;

import c.ba.beekeeping.config.LocalDateDeserializer;
import c.ba.beekeeping.config.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;

@Entity
public class Chamber {

	@Id
	@GeneratedValue
	private Integer id;
	private String describe;
	private String color;
	private String condition;
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate createdAt;

	@ManyToOne
	@JoinColumn(name = "beehive_id")
	private Beehive beehive;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Beehive getBeehive() {
		return beehive;
	}

	public void setBeehive(Beehive beehive) {
		this.beehive = beehive;
	}

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
