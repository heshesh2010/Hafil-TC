package com.ictfox.hafil_tc;

import android.app.Application;

import java.util.HashMap;

public class MyApplication extends Application {
	
	
	
	
	public HashMap<Integer, Integer> AnswerAndQuestion = new HashMap<Integer, Integer>();
	public HashMap<Integer, String> ImgAndPath = new HashMap<Integer, String>();
	public HashMap<Integer, String> ImgAndWebServiceName = new HashMap<Integer, String>();
	//��� ���� � ���� ����� ������
	public HashMap<String, String> ImgUpload = new HashMap<String, String>();
	public HashMap<Integer, String> NotesMap = new HashMap<Integer, String>();



public  int sectionBatrrey ;
public    String pathBatrrey ;
public    int section ;
public   String path;
	public int BusId;
	public int fleetnumber;
	public String platenumber;
	public String model ;
	public int seat1;
	public String nationalid;
	public String name;
	public String busType;
	public String schoolNum;
public	String schoolName;


//

public int GoodSeatsCount ;
public    int   BadSeatsCount;
public int NASeatsCounts;

public    int   KMCounter;
public int SeatBeltsCount;

public   int     NASeatBeltsCount;

public int BatteryVoltage;

    
	public void setall(int fleetnumber2,String platenumber , String model,  int seat12,  String nationalid,  String name, String busType, int BusId ){
		this.fleetnumber = fleetnumber2;
		this.platenumber = platenumber;
		this.model = model;
		this.seat1 = seat12;
		this.nationalid =nationalid;
		this.name = name ;
		this.busType=busType;
		this.BusId=BusId;
	}
	
	
	public void setallLocationInfo(String schoolNum, String schoolName){
		this.schoolNum =schoolNum ;
		this.schoolName = schoolName;

	}
	

	public void setAnswerAndSection(int section, int answer) {

		AnswerAndQuestion.put(section, answer);

	}



public void setfirstThreeCounts(int GoodSeatsCount, int BadSeatsCount, int NASeatsCounts ,  int SeatBeltsCount,int NASeatBeltsCount ) {

    this.GoodSeatsCount=GoodSeatsCount;
    this.BadSeatsCount=BadSeatsCount;
    this.NASeatsCounts=NASeatsCounts;
    this.SeatBeltsCount=SeatBeltsCount;
    this.NASeatBeltsCount=NASeatBeltsCount;

}

public void setKMCounter(int KMCounter ){

    this.KMCounter =KMCounter ;

}

public void setBatteryVoltage(int BatteryVoltage){

    this.BatteryVoltage=BatteryVoltage;

}

}
