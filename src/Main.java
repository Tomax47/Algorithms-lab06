import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        doFunction();

        System.out.println("\nSecond function : \n");
        doFunction2();

    }

    public static void getFunctionVal(double a, double b, double dx, Function<Double, Double> f) {
        for (double x = a; x < b + dx; x += dx) {
            System.out.println("x = " + x + "\s F(x) = " + f.apply(x));
        }
    }

    public static double f(double x) {
        return 2.0 * Math.sqrt(Math.abs(x - 1.0)) + 1.0;
    }

    public static void doFunction(){
        getFunctionVal(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, Math::cos);
        getFunctionVal(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, Main::f);
        getFunctionVal(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, (x) -> (-Math.pow(x / Math.PI, 2.0) - 2.0 * x + 5.0 * Math.PI));

        Function<Double, Double> f = (x) -> {
            double s = 0.0;
            for (int k = 1; k <= 100; k++) {
                s += Math.pow(x / (Math.PI * k) - 1.0, 2.0);
            }
            return s;
        };

        getFunctionVal(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, f);

        getFunctionVal(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, new Function<Double, Double>() {
            @Override
            public Double apply(Double x) {
                if (x < 0) {
                    return 0.25 * Math.sin(x) * Math.sin(x) + 1.0;
                }
                return 0.5 * Math.cos(x) - 1.0;
            }
        });
    }

    //2nd Function
    public static void getFunction2(double a, double b, double dx, DoubleUnaryOperator f){
        for (double x= a; x<b+dx;x+=dx){
            System.out.println("x = "+x+"\s F(x) = "+f.applyAsDouble(x) );
        }
    }

    public static void doFunction2(){
        getFunction2(-2.0*Math.PI,2.0*Math.PI,Math.PI/6.0,Math::cos);
        getFunction2(-2.0*Math.PI,2.0*Math.PI,Math.PI/6.0,Main::f);
        getFunction2(-2.0*Math.PI,2.0*Math.PI,Math.PI/6.0,(x) -> (-Math.pow(x/Math.PI,2.0) - 2.0 * x + 5.0 * Math.PI));

        DoubleUnaryOperator f = (x )->{
            double s= 0.0;
            for (int  k=1;k<=100;k++){
                s+=Math.pow(x/(Math.PI*k)-1.0,2.0);
            }
            return s;
        } ;

        getFunction2(-2.0*Math.PI,2.0*Math.PI,Math.PI/6.0,f);
        getFunction2(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, new DoubleUnaryOperator() {
            public double applyAsDouble(double x) {
                if (x<0){
                    return 0.25*Math.sin(x)* Math.sin(x)+1.0;
                }

                return 0.5 *Math.cos(x)-1.0;
            }
        });
    }

}
