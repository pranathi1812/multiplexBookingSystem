package com.multiplex.dto;

import com.multiplex.entities.Hall;
import com.multiplex.entities.Movie;

public class ShowDTO {
private Integer showId;
private Hall hall;
public ShowDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public ShowDTO(Integer showId, Hall hall) {
	super();
	this.showId = showId;
	this.hall = hall;
}
public Integer getShowId() {
	return showId;
}
public void setShowId(Integer showId) {
	this.showId = showId;
}
public Hall getHall() {
	return hall;
}
public void setHall(Hall hall) {
	this.hall = hall;
}
@Override
public String toString() {
	return "ShowDTO [showId=" + showId + ", hall=" + hall + "]";
}


}
