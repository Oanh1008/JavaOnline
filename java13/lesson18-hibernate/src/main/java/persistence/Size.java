package persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "KichCo")
public class Size {
	@Id
	@Column(name = "MaKC")
	private String id;
	
	@Column(name = "MoTa")
	private String desciption;
	
	
	
	public Size() {
		// TODO Auto-generated constructor stub
	}
	public Size(String id, String desciption) {
		super();
		this.id = id;
		this.desciption = desciption;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	@Override
	public String toString() {
		return "Size [id=" + id + ", desciption=" + desciption + "]";
	}
	
}
