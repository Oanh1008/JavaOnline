import java.math.BigDecimal;

public interface BaseDocument {

	DocumentGroup findDocuments(BaseDocument base);
	BigDecimal totalOfCapacity();
}
