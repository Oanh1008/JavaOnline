package persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.codec.language.bm.NameType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "LoaiHang")
@NamedQueries(
		//Required : JPQL( HQL)
		@NamedQuery(name = ItemGroup.Q_SELECT_ALL, 
					query = "SELECT ig FROM ItemGroup ig")
)
public class ItemGroup {
	public static final String Q_SELECT_ALL="SELECT ALL ITEM GROUP";
	@Id
	@Column(name = "MaLH")
	private Integer id;
	
	@Column(name = "TenLH")
	private String name;
	
	@OneToMany(mappedBy = "itemGroup")
	// Default : FetchLazy
	private List<Item> items;
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
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "ItemGroup [id=" + id + ", name=" + name + "]";
	}
}
