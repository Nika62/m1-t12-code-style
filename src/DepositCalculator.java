import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercentFunction(double amount, double yearRate,int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundAvoid(pay,2);
    }
    double calculateSimplePercentFunction(double amount, double yearRate, int depositPeriod) {
        return roundAvoid(amount+amount * yearRate * depositPeriod,2);
    }
    double  roundAvoid(double value, int places) {
        double scaLe= Math.pow(10, places);
        return Math.round(value*scaLe) / scaLe;
    }
    void calculateDeposit() {
        int period;
        int action ;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );
        System.out.println (   "Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double out = 0;

        if (action == 1) {
            out = calculateSimplePercentFunction(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercentFunction(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
    new DepositCalculator().calculateDeposit();
    }

}