package dataStructure;

public class TravelCity {
	String name;
//	Date arrivalTime;
//	Date departureTime;  
	int miles;
	
	TravelCity(String name,int miles){
		this.name = name;
		this.miles = miles;
	}  
	
	public String toString(){
		return name+",\t����ʼ������"+miles+"����";
	}
	
	public String getName(){
		return name;
	} 
	
	public boolean equals(TravelCity x){
		return name.equals(x);
	}
	
	public int distance(TravelCity x){
		return miles - x.miles;
	}
}