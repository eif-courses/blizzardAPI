package com.company.eif.viko.lt.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
interface Greeting{
  void message();
}
class Hello implements Greeting{
  @Override
  public void message() {
    System.out.println("Hello");
  }
}
class Goodbye implements Greeting{
  @Override
  public void message() {
    System.out.println("Goodbye");
  }
}


class Greeter implements Greeting{
  public void printMessage(Greeting greeting){
    greeting.message();
  }

  @Override
  public void message() {

  }
}

class A{
  void print(){
    System.out.println("KLASES METODAS A");
  }
}
class B extends A{


}
class C extends B{
  @Override
  void print(){
    System.out.println("KLase B metodas");
    super.print();
  }
}



public class Main {

  public static void main(String[] args) {



    new C().print();

    Greeter greeter = new Greeter();

    // Senas budas
    Greeting atsisveikinti = new Goodbye();
    Greeting pasisveikinti = new Hello();

    //greeter.printMessage(atsisveikinti);
    //greeter.printMessage(pasisveikinti);

    // SU LAMBDA

    // Greeting tipo ->public void message();
    //greeter.printMessage(()-> System.out.println("Hello from lambda"));

    Predikatas<String> predicate = tekstas -> tekstas.startsWith("c");
    System.out.println(predicate.test("cepelinai"));
    System.out.println(predicate.test("cebabai"));

    Masina<Greeter> masina = new Masina<>();



  }

}
interface Predikatas<LABAS> {
  boolean test(LABAS l);
}


class Masina<T extends Greeter & Greeting>{
  T t;

  public Masina() {
  }
  public static void uzkurti(List<? super Number> l){}

  public <RRR extends Integer & Runnable> RRR  skaiciuoti(RRR t){
    return t;
  }


  public Masina(T t) {
    this.t = t;
  }

  public T getT() {
    return t;
  }

  public void setT(T t) {
    this.t = t;
  }


  @Override
  public String toString() {
    return "Masina{" +
        "t=" + t +
        '}';
  }
}







