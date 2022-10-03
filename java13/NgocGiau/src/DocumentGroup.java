import java.math.BigDecimal;
import java.util.List;

public class DocumentGroup implements BaseDocument{

	private String nameOfGroup;
	private List<Document> documents;
	private BigDecimal capacity;
	@Override
	public DocumentGroup findDocuments(BaseDocument base) {
		// TODO Auto-generated method stub
		return null;
	}
	public DocumentGroup() {
		// TODO Auto-generated constructor stub
	}
	public DocumentGroup(String nameOfGroup, List<Document> documents, BigDecimal capacity) {
		super();
		this.nameOfGroup = nameOfGroup;
		this.documents = documents;
		this.capacity = capacity;
	}
	@Override
	public BigDecimal totalOfCapacity() {
		// TODO Auto-generated method stub
		return documents.stream().map(d ->d.getCapacity()).reduce((d1,d2)->d1.add(d2)).get();
	}
	public void setCapacity() {
		this.capacity = totalOfCapacity();
	}
	
}
