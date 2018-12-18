package com.company.eif.viko.lt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {



  public static void main(String ...args) {
    Funckcija<String, String> func= String::strip;
    System.out.println(func.apply("             Labas\n"));
    Funckcija.def();
    var list = new ArrayList<>();


  }

}
@FunctionalInterface
interface Funckcija<T, R>{
  abstract R apply(T t);
  default void c(){
    System.out.println("Default metodas");
  }
  static String def(){
    System.out.println("Static metodas");
    return ";awe";
  }
  private void metod(){
    System.out.println("Private metodas");
  }
}
class Po{}
