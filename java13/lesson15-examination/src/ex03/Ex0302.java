package ex03;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex0302 {
	public static void main(String[] args) {
		String text="aaaababbbbddc";
	
		Map<Character, Long>letterStatistic= text.chars()   // IntStream
		    .mapToObj(t -> (char)t) // Stream<Character>
		    .collect(Collectors.groupingBy(t->t,Collectors.counting()))
		    ;
		    
	    OptionalLong max= 	letterStatistic.entrySet()
		    .stream()
		    .mapToLong(letter->letter.getValue())
		    .max();
	    if(max.isPresent()) {
	    	letterStatistic.forEach((letter,count)->
	    	{
	    		if(count==max.getAsLong()) {
	    			System.out.println(letter +"= "+count);
	    		}
	    	});
	    	
	    }
	}
}
