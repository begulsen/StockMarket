package model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Share {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "share id")
	@Column(name = "share_id")
	private Integer id;
	@ApiModelProperty(notes = "share code")
	@Column(name = "share_code")
	private String code;
	@ApiModelProperty(notes = "share name")
	@Column(name = "share_name")
	private String name;
	@ApiModelProperty(notes = "share price")
	@Column(name = "share_price")
	private BigDecimal price;
	@ApiModelProperty(notes = "share date")
	@Column(name = "share_date")
	private Date date;

	public Integer getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	private Share() {
		
	}
	 
	public static class Sharebuilder{
		private String code;
		private String name;
		private BigDecimal price;
		private Date date;
		
		public Sharebuilder setCode(String code) {
			this.code = code;
			return this;
		}
		
		public Sharebuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Sharebuilder setPrice(BigDecimal price) {
			this.price = price;
			return this;
		}
		
		public Sharebuilder setDate(Date date) {
			this.date = date;
			return this;
		}
		
		public Share build() {
			Share share = new Share();
			share.code = this.code;
			share.name = this.name;
			share.price = this.price;
			share.date = this.date;
			return share;
		}
	}

}
