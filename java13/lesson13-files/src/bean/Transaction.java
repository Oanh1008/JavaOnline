package bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction implements  FileTransfer,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5328077540491581337L;
	private int id;
	private String traderName;
	private double value;
	private LocalDate date;

	public Transaction() {

	}

	public Transaction(int id, String traderName, double value, LocalDate date) {
		super();
		this.id = id;
		this.traderName = traderName;
		this.value = value;
		this.date = date;
	}
	@Override
	public String toLine() {
		// TODO Auto-generated method stub
		return id+", "+traderName+", "+value+", "+date;
	}
	public Transaction(String line) {
	 String[] e= line.split("[,\\s]+");
   	 if(e.length==4) {
   		 this.id=Integer.parseInt(e[0]);
   		 this.traderName=e[1];
   		 this.value=Double.parseDouble(e[2]);
   		 this.date=LocalDate.parse(e[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}
   	 
	}
	public static Transaction transfer(String line) {
		String[] e = line.split("[,\\s]+");
		if (e.length != 4) {
			return null;
		}
		return new Transaction(
				Integer.parseInt(e[0]), 
				e[1], 
				Double.parseDouble(e[2]),
				LocalDate.parse(e[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"))
				);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTraderName() {
		return traderName;
	}

	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", traderName=" + traderName + ", value=" + value + ", date=" + date + "]\n";
	}

}
