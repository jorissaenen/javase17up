package be.abis.exercise.model;

import be.abis.exercise.util.DateUtils;

import java.time.LocalDate;

public record Course (String title,int days,double dailyPrice, LocalDate releaseDate){

	@Override
	public String toString() {
		return "title:" + this.title() + " , duration:" + this.days() + " , price:" + this.dailyPrice()+ " , release date:" + DateUtils.format(this.releaseDate());
	}

	
}