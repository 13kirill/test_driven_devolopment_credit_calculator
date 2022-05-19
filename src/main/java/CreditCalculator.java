import java.text.DecimalFormat;

public class CreditCalculator {
    private final double credit = 3_411_300;
    private final double percent = 8.2;
    private final int months = 360;
    private final double monthlyPercent = ((percent/12)/100);

    public double monthlyPayment(double credit, double percent, int months) {

        CreditCalculator creditCalculator = new CreditCalculator();

        double monthlyPayment = credit *
                (monthlyPercent *
                        (Math.pow((1 + monthlyPercent), months)) /
                        ((Math.pow(1 + monthlyPercent, months)) - 1));

        String resultMonthlyPayment = creditCalculator.format(monthlyPayment);
        double monthlyPaymentResult = Double.parseDouble(resultMonthlyPayment);

        return monthlyPaymentResult;
    }

    public double overpayment(double credit, double percent, int months) {

        CreditCalculator creditCalculator = new CreditCalculator();

        double monthlyPayment = creditCalculator.monthlyPayment(credit, percent, months);

        double overpayment = monthlyPayment * months - credit;

        String resultOverpayment = creditCalculator.format(overpayment);
        double overpaymentResult = Double.parseDouble(resultOverpayment);

        return overpaymentResult;
    }

    public double returnedBalance(double credit, double percent, int months) {

        CreditCalculator creditCalculator = new CreditCalculator();

        double returnedBalance = creditCalculator.overpayment(credit, percent, months) + credit;

        String resultReturnedBalance = creditCalculator.format(returnedBalance);

        double returnedBalanceResult = Double.parseDouble(resultReturnedBalance);

        return returnedBalanceResult;
    }

    public String format(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("###.00");

/*        Здесь пытался похимичить с форматом, но что то не вышло. Даже при текущем формате значения выводятся не одинаково.
        Должно быть два знака после запятой, а так только в первом значении. Что не так?
        Ведь к результатам всех методов применяется один единый метод форматирования.*/

//        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ROOT);
//        decimalFormatSymbols.setDecimalSeparator('|');
//        String s = "#,##0.###";

        return decimalFormat.format(d).replace(",", ".");
    }

    public static void main(String[] args) {
        CreditCalculator creditCalculator = new CreditCalculator();
        System.out.println(creditCalculator.monthlyPayment(creditCalculator.credit, creditCalculator.percent, creditCalculator.months));
        System.out.println(creditCalculator.overpayment(creditCalculator.credit, creditCalculator.percent, creditCalculator.months));
        System.out.println(creditCalculator.returnedBalance(creditCalculator.credit, creditCalculator.percent, creditCalculator.months));
    }
}