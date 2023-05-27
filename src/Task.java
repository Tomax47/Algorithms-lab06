//lab06 1 c)
public class Task {
    public static void main(String[] args) {

        Function f = (x )->{
            double s= 0.0;
            for (int  k=1;k<=100;k++){
                s+=Math.pow(x/(Math.PI*k)-1.0,2.0);
            }
            return s;
        } ;

        Function []myFunction= {Math::cos,
                Main::f,
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


        for (int i = 0; i <5 ; i++) { getFunction3(-2.0*Math.PI,2.0*Math.PI,Math.PI/6.0,Math::cos);

        }

    }
    public static void getFunction3(double a, double b, double dx, Function f){
        for (double x= a; x<b+dx;x+=dx){
            System.out.println("x = "+x+"\s F(x) = "+f.function(x) );
        }
    }

    public static double f(double x){
        return 2.0*Math.sqrt(Math.abs(x-1.0))+1.0;
    }
}