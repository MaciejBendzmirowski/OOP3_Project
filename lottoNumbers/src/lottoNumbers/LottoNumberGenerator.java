package lottoNumbers;
 
 import java.util.Random;
 import java.util.Set;
 import java.util.TreeSet;
 

public class LottoNumberGenerator {
 
private final Set<Integer> lottoNumbers = new TreeSet<>();


 public void generateNumbers() {
 
Random rand = new Random();
 
do {
 
Integer i = 1 + rand.nextInt(49);

lottoNumbers.add(i);

} while (lottoNumbers.size() < 6);
 
}

 
public Set<Integer> getLottoNumbers() {
 
return lottoNumbers;
 
 }

 
}