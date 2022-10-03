import java.math.BigDecimal;
import java.util.Formatter.BigDecimalLayoutForm;

public class Document implements BaseDocument{

	private String nameOfDoc;
	private BigDecimal capacity;
	@Override
	public DocumentGroup findDocuments(BaseDocument base) {
		// TODO Auto-generated method stub
		return null;
	}
	public Document() {
		// TODO Auto-generated constructor stub
	}
	public Document(String nameOfDoc, BigDecimal capacity) {
		super();
		this.nameOfDoc = nameOfDoc;
		this.capacity = capacity;
	}
	@Override
	public BigDecimal totalOfCapacity() {
		// TODO Auto-generated method stub
		return capacity;
	}
	public BigDecimal getCapacity() {
		return capacity;
	}
	public String getNameOfDoc() {
		return nameOfDoc;
	}
	
}
