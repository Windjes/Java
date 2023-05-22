package Part10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        String string = "123";
try {
    char ch = string.charAt(12);
}
catch (IndexOutOfBoundsException qw){
    System.out.println(qw.getMessage());
}
        System.out.println("Конец программы!");
    }
}

