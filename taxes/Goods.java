package taxes;

import java.text.DecimalFormat;

public class Goods{
    private double amount;
    private double salesTax;
    private double importDuty = 5;

    public Goods(double amount, double salesTax){
        this.amount = amount;
        this.salesTax = salesTax;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }
    public void seSalesTax(double salesTax){
        this.salesTax = salesTax;
    }
    public void setImportDuty(double importDuty){
        this.importDuty = importDuty;
    }
    public double getAmount(double amount){
        return this.amount;
    }
    public double getSalesTax(double salesTax){
        return this.salesTax;
    }
    public double getImportDuty(double importDuty){
        return this.importDuty;
    }

    public double getFinalPrice(){
        return this.amount + this.getSalesTaxAmount() + getImportDutyAmount();
    }

    public double getSalesTaxAmount(){
        return new Double(Math.round(this.amount*salesTax*0.2)/20.00);
    }

    public double getImportDutyAmount(){
        return new Double(Math.round(this.amount*importDuty*0.2)/20.00);
    }
}