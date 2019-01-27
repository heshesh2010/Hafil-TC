package com.ictfox.hafil_tc;

import java.io.Serializable;

public class LastDaysHelper  implements Serializable{
	private static final long serialVersionUID = 1L;
	private  String Date;
	  private String PlateNumber;
	  
	  public LastDaysHelper(String Date) {
		    this.Date = Date;
		  }

		  public  String getDate() {
		    return Date;
		  }

		  public void setDate(String Date) {
		    this.Date = Date;
		  }

		  public String getPlateNumber() {
		    return PlateNumber;
		  }

		  public void setSelected(String PlateNumber) {
		    this.PlateNumber = PlateNumber;
		  }
		  
}
