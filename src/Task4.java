public class Task4 {
    public static void main(String[] args) {

        Function f = (x) -> {
            double s = 0.0;
            for (int k = 1; k <= 100; k++) {
                s += Math.pow(x / (Math.PI * k) - 1.0, 2.0);
            }
            return s;
        };

        Function[] myFunction = {Math::cos,
                Task4::f,
                (x) -> (-Math.pow(x / Math.PI, 2.0) - 2.0 * x + 5.0 * Math.PI),
                f,
                new Function() {
                    @Override
                    public double function(double x) {
                        if (x < 0) {
                            return 0.25 * Math.sin(x) * Math.sin(x) + 1.0;
                        }

                        return 0.5 * Math.cos(x) - 1.0;
                    }
                }
        };


        for (int i = 0; i < 5; i++) {
            int count = tFunctionCount(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, myFunction[i],(x)-> x<0);
            System.out.println("For f[" + i + "] kal = " + count);

        }

        for (int i = 0; i < 5; i++) {
            int count = tFunctionCount(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, myFunction[i],(x)-> (x>= -1.0&&x<=1.0));
            System.out.println("For f[" + i + "] kal[1 , -1] = " + count);

        }

    }

    public static double f(double x) {
        return 2.0 * Math.sqrt(Math.abs(x - 1.0)) + 1.0;
    }

    public static int tFunctionCount(double a, double b, double dx, Function f, Predicate p) {
        int k = 0;
        for (double x = a; x < b + dx; x += dx) {
            double y = f.function(x);
            System.out.println("x = " + x + "\s F(x) = " + y);

            if (p.check(y)) k++;
        }
        return k;
    }

    public static void getFunctionVal(double a, double b, double dx, Function f){
        for (double x= a; x<b+dx;x+=dx){
            System.out.println("x = "+x+"\s F(x) = "+f.function(x) );
        }
    }
}
