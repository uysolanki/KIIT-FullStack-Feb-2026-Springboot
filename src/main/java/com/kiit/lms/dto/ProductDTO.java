package com.kiit.lms.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
	
		
		@Size(min = 6, max = 100, message = "title must be between 6 and 100 characters") 
	    public String title;
		
		@Min(value = 1, message = "Price must be greater than 0")
		@Max(value = 500, message = "Price must be less than or equal to 500") 
	    public Double price;
		
		@NotBlank
	    public String description;
	    public String category;
	    public String image;
	    
	    public RatingDTO rating;
}
