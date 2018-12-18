package eif.viko.lt.fakultetas.test;

public class Test {
  public static void skaiciuoti(int ... skaicius){
    for (int i = 0; i < skaicius.length; i++) {
      System.out.println(skaicius[i]);
    }
  }

  public static void main(String[] args) {
    skaiciuoti(50);
  }
}
