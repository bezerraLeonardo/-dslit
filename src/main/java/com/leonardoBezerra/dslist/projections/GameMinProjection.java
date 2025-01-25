package com.leonardoBezerra.dslist.projections;

public interface GameMinProjection {

    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();

    String getLongDescription();
}
