package view.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import bean.Trader;
import bean.Transaction;
import model.DataModel;

public class StreamExercises {
	public static void main(String[] args) {
//		1. Find all transactions in the year 2011 and sort them by value (small to high).
		List<Trader>traders=DataModel.getTraders();
		List<Transaction>transactions= DataModel.getTransactions();
		
		List<Transaction> one= transactions.stream()
										   .filter(transaction->transaction.getYear()==2011)
										   .sorted(Comparator.comparing(Transaction::getValue))
										   .collect(Collectors.toList());
		System.out.println(" transactions in the year 2011 and sort them by value (small to high)");
		one.forEach(System.out::println);
		
//		2. Find all transactions have value greater than 300 and sort them by trader’s city 
		List<Transaction> two= transactions.stream()
										   .filter(transaction->transaction.getValue()>300)
										   .sorted(Comparator.comparing(t->t.getTrader().getCity()))
										   .collect(Collectors.toList());
		System.out.println("\n\nFind all transactions have value greater than 300 and sort them by trader’s city");
		two.forEach(System.out::println);
		
//		3. What are all the unique cities where the traders work?
		List<String> three= transactions.stream()
				   .map(t->t.getTrader().getCity())
				   .distinct()
				   .collect(Collectors.toList());
		System.out.println("\n\n What are all the unique cities where the traders work?");
		three.forEach(System.out::println);
//		4. Find all traders from Cambridge and sort them by name desc.
		
		List<Trader>four= traders.stream()
								 .filter(t->"Cambridge".equals(t.getCity()))
								 .sorted(Comparator.comparing(Trader::getName,Comparator.reverseOrder()))
								 .collect(Collectors.toList());
		System.out.println("\n\n Find all traders from Cambridge and sort them by name desc.");
		four.forEach(System.out::println);
//		5. Return a string of all traders’ names sorted alphabetically.
		String five= traders.stream()
								 .map(t->t.getName())
								 .sorted()
								 .collect(Collectors.joining(", "));
		System.out.println("\n\n Return a string of all traders’ names sorted alphabetically.");
		System.out.println(five);
		
//		6. Are any traders based in Milan?
		boolean six= traders.stream()
							.anyMatch(t->"Milan".equals(t.getCity()));
		System.out.println("\n\nAre any traders based in Milan? "+six);
//		7. Count the number of traders in Milan.
			Long seven= traders.stream()
						  	.filter(t->"Milan".equals(t.getCity()))
						  	.count()
						   ;
		System.out.println("\n\n7. Count the number of traders in Milan. "+seven);
						   
//		8. Print all transactions’ values from the traders living in Cambridge.
		List<Integer>eight= transactions.stream()
									.filter(t->t.getTrader().getCity().equals("Cambridge"))
									.map(t->t.getValue())
									.collect(Collectors.toList());
		System.out.println("\n\n8Print all transactions’ values from the traders living in Cambridge.");
		eight.forEach(System.out::println);
//		9. What’s the highest value of all the transactions?
		Integer nine= transactions.stream()
					.map(t->t.getValue())
					.reduce(Integer.MIN_VALUE, Integer::max);
		System.out.println("\n\n9. What’s the highest value of all the transactions? " +nine );
		
//		10. Find the transaction with the smallest value.
		Integer ten= transactions.stream()
				.map(t->t.getValue())
				.reduce(Integer.MAX_VALUE,Math::min);
	System.out.println("\n\n10. Find the transaction with the smallest value." +ten);
	}

	
}
