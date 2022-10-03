package persistence;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ItemGroupDto {
	private Integer igrId;
	private String igrName;
	private Map<String, Integer> items;
	private Integer totalOfItems;
	public ItemGroupDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemGroupDto(Integer igrId, String igrName, Map<String, Integer> items, Integer totalOfItems) {
		super();
		this.igrId = igrId;
		this.igrName = igrName;
		this.items = items;
		this.totalOfItems = totalOfItems;
	}
	public ItemGroupDto (ItemGroupRawData data) {
		this.igrId = data.getIgrId();
		this.igrName = data.getIgrName();
		this.items = Pattern.compile(",")
			    .splitAsStream(data.getItems())
				.collect(Collectors.toMap(item->item.substring(0,item.indexOf("-")),
		   									item->Integer.parseInt(item.substring(item.indexOf("-")+1))));
		this.totalOfItems = data.getTotalOfItems();
		
		
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
	public Map<String, Integer> getItems() {
		return items;
	}
	public void setItems(Map<String, Integer> items) {
		this.items = items;
	}
	public Integer getTotalOfItems() {
		return totalOfItems;
	}
	public void setTotalOfItems(Integer totalOfItems) {
		this.totalOfItems = totalOfItems;
	}
	@Override
	public String toString() {
		return "ItemGroupDto [igrId=" + igrId + ", igrName=" + igrName + ", items=" + items + ", totalOfItems="
				+ totalOfItems + "]";
	}
	
}
