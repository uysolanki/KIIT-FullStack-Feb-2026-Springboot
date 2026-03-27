package com.kiit.lms.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    public Integer id;
	    public String title;
	    public double price;
	    public String description;
	    public String category;
	    public String image;
	    
	    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		@JoinColumn(name = "fkrid",referencedColumnName = "ratingId")
	    public Rating rating;
	    
	    private LocalDateTime createdAt;
		
	       private LocalDateTime modifiedAt;
		
		@PrePersist
		protected void atCreation()
		{
			LocalDateTime now=LocalDateTime.now();
			this.createdAt=now;
			this.modifiedAt=now;
		}
		
		@PreUpdate
		protected void atUpdation()
		{
			this.modifiedAt=LocalDateTime.now();
		}

}
