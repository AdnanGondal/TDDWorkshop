//package org.example.order;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class OrderAdnan {
//
//    private String orderCode;
//
//    public Order(String orderCode){
//        this.orderCode = orderCode;
//    }
//    public String getOrderCode(){
//        return orderCode;
//    }
//
//    public ArrayList getPayments() throws Exception{
//        try{
//            List<Object> dbPaymentsList = Db.getPayments(orderCode.trim());
//            ArrayList<Payment> paymentsList = new ArrayList<>();
//            for (int i=0; i<dbPaymentsList.size(); i++){
//                DbRow dbRow = (DbRow) dbPaymentsList.get(i);
//                Payment payment = mapPaymentFromDbRow(dbRow);
//                paymentsList.add(payment);
//            }
//            return paymentsList;
//        } catch (SQLException ex){
//            // "Can't retrieve transactions from the database for ordercode",orderCode
//            throw new DataRetreivelException(String.format("Can't retrieve transactions from the database for ordercode",orderCode));
//        }
//    }
//    public Payment mapPaymentFromDbRow(DbRow row){
//        double currencyAmountInPounds = Double.parseDouble(row.getValueForField("amt"));
//        String description = row.getValueForField("desc");
//        return new Payment(description, currencyAmountInPounds); // return the new Payment object
//    }
//
//    // Override the equals method
//    public boolean equals(Order o) {
//
//        if (o.getOrderCode() != null && getOrderCode()!=null){
//            return o.getOrderCode().equals(getOrderCode());
//        }
//        return false;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OrderAdnan that = (OrderAdnan) o;
//        return Objects.equals(orderCode, that.orderCode);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(orderCode);
//    }
//}
////
////Order adnansOrder = new Order("code1");
////Order tomsOrder = new Order("code1");
////
//// adnansOrder.equals(tomsOrder)
