package main.java;

public class LongitudeLatitude{

	private GeoPosition longitude;
	private GeoPosition latitude;
	private String title;

	public LongitudeLatitude(double passedLongitude, double passedLatitude){
		this.longitude = new GeoPosition(passedLongitude);
		this.latitude = new GeoPosition(passedLatitude);
	}

	public LongitudeLatitude(String passedTitle){
		this.title = passedTitle;
	}

	public LongitudeLatitude(){
		this.longitude = new GeoPosition();
		this.latitude = new GeoPosition();
	}


	public static class Builder{
		
		private GeoPosition longitude = new GeoPosition(); // variable named longitude that uses geoposition.
		private GeoPosition latitude = new GeoPosition(); // variable named latitude that uses geoposition.
		private String title; // Variable that holds the title of the location.
	
		public Builder title(String title){ // Builder function that sets the title.  Must have an argument passed.
			this.title = title;
			return this;
		}
		
	//	public Builder longitude(){
			//this.longitude.SetCoordinate(passedLongitude);
	//		throw new IOException("Error");
	//		return this;
	//	}
		
		public Builder longitude(double passedLongitude){ // Builder function that sets longitude.
			this.longitude.SetCoordinate(passedLongitude);
			return this;
		}
		
		public Builder latitude(double passedLatitude){ // Builder function that sets latitude.
			this.latitude.SetCoordinate(passedLatitude);
			return this;
		}
		
		public LongitudeLatitude build(){
			return new LongitudeLatitude(this);
		}
	}
	
	private LongitudeLatitude(Builder builder){
		title = builder.title;
		longitude = builder.longitude;
		latitude = builder.latitude;
	}
			
	public void SetLongitude(double passedLongitude){ // Passes through to the geoposition functions, sets longitude to passed double.
		this.longitude.SetCoordinate(passedLongitude);
	}
	
	public void SetLatitude(double passedLatitude){ // Passes through to the geoposition functions, sets latitude to passed double.
		this.latitude.SetCoordinate(passedLatitude);
	}

	public double GetLongitude(){ // Pass through to the geoposition function, returns longitude double value.  
		return this.longitude.GetCoordinate();
	}
	
	public double GetLatitude(){ // Pass through to the geoposition function, returns latitude double value. 
		return this.latitude.GetCoordinate();
	}
	
	public void SetTitle(String passedTitle){ // Pass through to the geoposition function, sets title to passed title.
		this.title = passedTitle;
	}

	public String GetTitle(){ // Pass through to the geoposition function, returns the title. 
		return this.title;
	}
	
	static class GeoPosition{
		private double coordinate; // Contains the location coordinate, as a double value.  
		private double blankCoordinate = 0.0; 
		
		public GeoPosition(){ // Default constructor without any arguments, sets the coordinate to 0.0
			this.coordinate = blankCoordinate;
		}
		
		public GeoPosition(double passedDouble){ // Constructor with a passed double, sets the coordinate.
			this.coordinate = passedDouble;
		}
		
		public void SetCoordinate(double passedCoordinate){ // Similar to the constuctor, passed double sets the coordinate.
			this.coordinate = passedCoordinate;
		}
	
		public double GetCoordinate(){ //Returns the coordinate value as a double.  
			return this.coordinate;
		}
	}
}
