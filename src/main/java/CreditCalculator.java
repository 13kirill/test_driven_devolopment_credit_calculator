public class CreditCalculator {
    private final double credit = 3_411_300;
    private final double percent = 8.2;
    private final int months = 360;
    private final double monthlyPercent = ((percent / 12) / 100);

    public double monthlyPayment(double credit, double percent, int months) {

        double monthlyPayment = credit *
                (monthlyPercent *
                        (Math.pow((1 + monthlyPercent), months)) /
                        ((Math.pow(1 + monthlyPercent, months)) - 1));

        String resultMonthlyPayment = format(monthlyPayment);
        double monthlyPaymentResult = Double.parseDouble(resultMonthlyPayment);

        return monthlyPaymentResult;
    }

    public double overpayment(double credit, double percent, int months) {

        double monthlyPayment = monthlyPayment(credit, percent, months);

        double overpayment = monthlyPayment * months - credit;

        String resultOverpayment = format(overpayment);

        double overpaymentResult = Double.parseDouble(resultOverpayment);

        return overpaymentResult;
    }

    public double returnedBalance(double credit, double percent, int months) {

        double returnedBalance = overpayment(credit, percent, months) + credit;

        String resultReturnedBalance = format(returnedBalance);

        double returnedBalanceResult = Double.parseDouble(resultReturnedBalance);

        return returnedBalanceResult;
    }

    public static String format(double d){
        return String.format("%.2f",d).replace(",", ".");
    }

    public static void main(String[] args) {
        CreditCalculator creditCalculator = new CreditCalculator();
        System.out.println(creditCalculator.monthlyPayment(creditCalculator.credit, creditCalculator.percent, creditCalculator.months));
        System.out.println(creditCalculator.overpayment(creditCalculator.credit, creditCalculator.percent, creditCalculator.months));
        System.out.println(creditCalculator.returnedBalance(creditCalculator.credit, creditCalculator.percent, creditCalculator.months));
    }
}