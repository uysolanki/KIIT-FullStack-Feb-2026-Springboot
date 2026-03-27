package com.kiit.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
	
		
	    public String title;
	    public double price;
	    public String description;
	    public String category;
	    public String image;
	    
	    public RatingDTO rating;
}
