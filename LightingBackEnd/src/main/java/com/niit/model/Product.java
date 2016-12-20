package com.niit.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")
@Component
public class Product {
	
	@Id
	private String pro_Id;
	@NotNull//(message="name cannot be empty")
	@Column(name = "prod_ID",unique=true)
	private String prod_ID;	
	private String pro_name;
	@NotNull//(message="name cannot be empty")
	private String comp_name;
	@NotNull//(message="description cannot be empty")
	private String description;
	@NotNull//(message="price cannot be empty")
	@DecimalMin(value="100.00")
	private float price;
	@NotNull //(message=" cannot be empty") 
	@Min(0)
	private int quantity;
	@Transient
	private MultipartFile image;
	@Transient
	private MultipartFile img;
	
	
	public String getPro_Id() {
		return pro_Id;
	}
	
	public void setPro_Id(String pro_Id) {
		this.pro_Id = pro_Id;
	}
	
	

	public String getProd_ID() {
		return prod_ID;
	}

	public void setProd_ID(String prod_ID) {
		this.prod_ID = prod_ID;
	}

	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
		
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name="sup_id", insertable=false ,updatable=false )
	private Supplier supplier;
	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	private String sup_id;
	
	public String getSup_id() {
		return sup_id;
	}

	public void setSup_id(String sup_id) {
		this.sup_id = sup_id;
	}

	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name="cat_id", insertable=false ,updatable=false )
	private Category category;
		
    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	private String cat_id;

	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	
	    	
		}
