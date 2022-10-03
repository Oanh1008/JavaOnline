package persistence;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ItemGroupRawData {
	private Integer igrId;
	private String igrName;
	private String items;
	private Integer totalOfItems;
	public ItemGroupRawData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemGroupRawData(Integer igrId, String igrName, String items, Integer totalOfItems) {
		super();
		this.igrId = igrId;
		this.igrName = igrName;
		this.items = items;
		this.totalOfItems = totalOfItems;
	}
	public Integer getIgrId() {
		return igrId;
	}
	public void setIgrId(Integer igrId) {
		this.igrId = igrId;
	}
	public String getIgrName() {
		return igrName;
	}
	public void setIgrName(String igrName) {
		this.igrName = igrName;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public Integer getTotalOfItems() {
		return totalOfItems;
	}
	public void setTotalOfItems(Integer totalOfItems) {
		this.totalOfItems = totalOfItems;
	} 
	public ItemGroupDto transfer() {
		ItemGroupDto igrDto= new ItemGroupDto();
		igrDto.setIgrId(getIgrId());
		igrDto.setIgrName(getIgrName());
		
		// convert String to Map<String,Integer>
		 igrDto.setItems(Pattern.compile(",")
			    .splitAsStream(getItems())
				.collect(Collectors.toMap(item->item.substring(0,item.indexOf("-")),
		   									item->Integer.parseInt(item.substring(item.indexOf("-")+1))))); 
			   
		igrDto.setTotalOfItems(getTotalOfItems());;
		return igrDto;
	}
	@Override
	public String toString() {
		return "ItemGroupDto [igrId=" + igrId + ", igrName=" + igrName + ", items=" + items + ", totalOfItems="
				+ totalOfItems + "]";
	}
	
}
