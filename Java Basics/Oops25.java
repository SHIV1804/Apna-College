import java.util.*;
public class Oops25 {
public static void main(String[] args) {
   
    Complex x = new Complex(1,0,2,-2); 
    System.out.println(x.sum());
    System.out.println(x.subtract());
    System.out.println(x.product());
}
    
}

class Complex {
     float number01;
     float number02;
     float number11;
     float number12;
    Complex(float number01, float number02,float number11, float number12){
        this.number01 = number01;
        this.number02 = number02;
        this.number11 = number11;
        this.number12 = number12;
    }
    String sum(){
        float real = this.number01 + this.number11;
        float imag = this.number02 + this.number12;
        return imag>=0?(real +"+"+imag+"i"):(real +""+imag+"i");
    }
    String subtract(){
        float real = this.number01 - this.number11;
        float imag = this.number02 - this.number12;
        return imag>=0?(real +"+"+imag+"i"):(real +""+imag+"i");

    }
    String product(){
        float real = this.number01*this.number11 - this.number02*this.number12;
        float imag = this.number01*this.number12+this.number02*this.number11;
        return imag>=0?(real +"+"+imag+"i"):(real +""+imag+"i");

    }
}