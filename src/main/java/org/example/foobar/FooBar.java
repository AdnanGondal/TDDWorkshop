package org.example.foobar;


public class FooBar {
    public static void main(String[] args) throws Exception {
        for(int i=1; i<=100; i++){
            System.out.println(textForNumber(i));
        }
    }

    public static String textForNumber (int number) {
        // Complete this method.
        // You can create more methods as required
        if (number == 0 || number<0){
            return "";
        }
        String[] numString = String.valueOf(number).split("");

        StringBuilder sb = new StringBuilder();
        if (number % 3 == 0){
            sb.append("Foo");
        }

        if (number % 5 == 0){
            sb.append("Bar");
        }

        for (String digit : numString){
            if (digit.equals("3")) {
                sb.append("Foo");
            } else if (digit.equals("5")){
                sb.append("Bar");
            }
        }

        return sb.toString();
    }
}