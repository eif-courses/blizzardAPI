public class Fizz {
  public String isKoDalinasi(int skaicius) {
    if(arDalinasiIs3(skaicius)){
      return "Fizz";
    }
    else if(skaicius % 5 == 0){
      return "Buzz";
    }
    return String.valueOf(skaicius);
  }

  private boolean arDalinasiIs3(int i) {
    return i %  3==0;
  }
}
