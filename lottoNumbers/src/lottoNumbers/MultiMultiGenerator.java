package lottoNumbers;
 
 import java.util.Random;
 import java.util.Set;
 import java.util.TreeSet;
 

public class MultiMultiGenerator {
 
private final Set<Integer> MultiMultiNumbers = new TreeSet<>();


 public void generateNumbers() {
 
Random rand = new Random();
 
do {
 
Integer i = 1 + rand.nextInt(80);
 
MultiMultiNumbers.add(i);

} while (MultiMultiNumbers.size() < 20);
 
}

 
public Set<Integer> getMultiMultiNumbers() {
 
return MultiMultiNumbers;
 
}
 
}