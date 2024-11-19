//package org.example.order;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Order {
//
//    private String orderCode;
//
//    public Order(String orderCode){
//        // Constructor
//        this.orderCode = orderCode;
//    }
//    public String getOrderCode(){
//        return orderCode; // return the order code
//    }
//
//    public ArrayList getPayments() throws Exception{
//        try{
//            List<Object> dbPaymentsList = Db.getPayments(orderCode.trim()); //Get the list of transactions
//            ArrayList<Payment> paymentsList = new ArrayList<>();
//            for (int i=0; i<dbPaymentsList.size(); i++){
//                DbRow dbRow = (DbRow) dbPaymentsList.get(i);
//                Payment payment = makePaymentsFromDbRow(dbRow);
//                paymentsList.add(payment);
//            }
//            return paymentsList;
//        } catch (SQLException ex){
//            // There was a database error
//            throw new Exception("Can't retrieve transactions from the database");
//        }
//    }
//    public Payment makePaymentsFromDbRow(DbRow row){
//        double currencyAmountInPounds = Double.parseDouble(row.getValueForField("amt"));
//        String description = row.getValueForField("desc");
//        return new Payment(description, currencyAmountInPounds); // return the new Payment object
//    }
//    // Override the equals method
//    public boolean equals(Order o) {
//        return o.getOrderCode() == getOrderCode(); // check order codes are the same
//    }
//}