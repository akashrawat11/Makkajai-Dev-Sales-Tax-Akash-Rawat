import taxes.Book;
import taxes.Food;
import taxes.Goods;
import taxes.Medicine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws java.lang.Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> typeOfGoods = new HashMap<>();
        typeOfGoods = populateKeywords(typeOfGoods);
        int numberOfGoods = Integer.parseInt(br.readLine());
        String[] result = new String[numberOfGoods];
        double salesTax = 0;
        double totalPrice = 0;
        int curIndex = 0;
        while(numberOfGoods > curIndex) {
            String goodsDetails = br.readLine();
            String[] details = goodsDetails.split(" at ");
            String output = details[0];
            double price = Double.parseDouble(details[details.length-1]);
            details = details[0].split("of");
            String name = "";
            if (details.length > 1)
                name = details[details.length-1].trim();
            details = details[0].split(" ");
            int quantity = Integer.parseInt(details[0]);
            if (name.length() == 0)
                name = details[details.length-1].trim();
            Goods goods = getGoodsType(name, typeOfGoods, price);
            double finalPrice = goods.getFinalPrice();
            result[curIndex] = output + ": " + String.format( "%,.2f", goods.getFinalPrice());
            curIndex += 1;
            salesTax +=(finalPrice-price);
            totalPrice += finalPrice;
        }
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
        System.out.println("Sales Tax: " + String.format( "%,.2f", salesTax));
        System.out.println("Total: "+ String.format( "%,.2f", totalPrice));
    }

    public static Goods getGoodsType(String type, Map<String, String> map, double amount){
        String goodType = map.get(type);
        if (goodType == "food")
            return new Food(amount);
        if (goodType == "book")
            return new Book(amount);
        if (goodType == "medicine")
            return new Medicine(amount);
        return new Goods(amount, 10);
    }

    public static Map populateKeywords(Map<String, String> map){
        map.put("chocolate", "food");
        map.put("chocolates", "food");
        map.put("book", "book");
        map.put("books", "book");
        map.put("headache pills", "medicine");
        return map;
    }
}
//1
//1 imported bottle of perfume at 47.50
