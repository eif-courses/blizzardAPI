import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {


  private Fizz f;

  @Before
  public void setUp() throws Exception {
    f = new Fizz();
  }
  @Test
  public void tirkrinamPerduotaParametra() {
    f.isKoDalinasi(1);
  }

  @Test
  public void tikrinamArGausimeVienetaPerdavusParametra1() {
    assertEquals("1", f.isKoDalinasi(1));
  }
  @Test
  public void tikrinamArGausimeDvejetaPerdavusParametra2() {
    assertEquals("2", f.isKoDalinasi(2));
  }

  @Test
  public void sesetasGrazinaFizz() {
    assertEquals("Fizz", f.isKoDalinasi(6));
  }

  @Test
  public void PenketasGrazinaFizz() {
    assertEquals("Buzz", f.isKoDalinasi(5));
  }
  @Test
  public void SesetasDalinasiIs3GrazinaFizz() {
    assertEquals("Fizz", f.isKoDalinasi(3));
  }



//  @Test
//  public void PenkiolikaGrazinaFizzBuzz() {
//    assertEquals("FizzBuzz", f.isKoDalinasi(5));
//  }


}
