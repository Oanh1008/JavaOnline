import java.util.Arrays;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		List<Document> listDoc = Arrays.asList(
				new Document("DB tools", null),
				new Document("MSDN", null),
				new Document("Case tools", null),
				new Document("dotNET", null),
				new Document("Eclipse", null));
		DocumentGroup development = new DocumentGroup("Development tools", listDoc, null);
		development.setCapacity();
		List<BaseDocument> group = List.of(new DocumentGroup("Office tools", null, null),
												development) ;
	}
}
