package c.ba.beekeeping.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Frame {

	@Id
	@GeneratedValue
	private Integer id;
	private int number;
	private String describe;
	private int brood;
	private int broodClosed;
	private int honey;
	private int honeyClosed;
	private boolean pollen;
	private String condition;

	@ManyToOne
	@JoinColumn(name = "chamber_id")
	private Chamber chamber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getBrood() {
        return brood;
    }

    public void setBrood(int brood) {
        this.brood = brood;
    }

    public int getBroodClosed() {
        return broodClosed;
    }

    public void setBroodClosed(int broodClosed) {
        this.broodClosed = broodClosed;
    }

    public int getHoney() {
        return honey;
    }

    public void setHoney(int honey) {
        this.honey = honey;
    }

    public int getHoneyClosed() {
        return honeyClosed;
    }

    public void setHoneyClosed(int honeyClosed) {
        this.honeyClosed = honeyClosed;
    }

    public boolean isPollen() {
        return pollen;
    }

    public void setPollen(boolean pollen) {
        this.pollen = pollen;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Chamber getChamber() {
        return chamber;
    }

    public void setChamber(Chamber chamber) {
        this.chamber = chamber;
    }
}
