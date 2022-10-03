package persistence;

/**
 * Role -> Entity, Mapping, Receiving data from Table LoaiHang
 * @author Oanhpv1008
 *
 */
public class ItemGroup {
	
	private Integer id;
	private String name;
	
	// List item
	public ItemGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemGroup(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ItemGroup [id=" + id + ", name=" + name + "]";
	}
	
	
}
