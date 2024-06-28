package ejercicio_1;

public class Main {
    public static void main(String[] args) {
        EmpleadoBase empleadoB = new EmpleadoBase("Israel", 1234, 5, 5000.00, 560.0, 150.0);
        System.out.println(empleadoB.calcularSalario());

        EmpleadoTemporal empleadoT = new EmpleadoTemporal("Eduardo", 4321, 120.00, 22);
        System.out.println(empleadoT.calcularSalario());

        //Polimorfismo
        // Es la capacidad de un objeto de comportarse de manera distinta
        // poliEmpleado es un Empleado(hereda de la Clase Empelado), que hahora se le asigna el comprotamiento de un EmpleadoTemporal(empleadoT)
        Empleado poliEmpleado = empleadoT;
        System.out.println("poliEmpleado (ahora temporal) calcula su salario: " + poliEmpleado.calcularSalario());
        // En este caso al poliEmpleado(que anteriormente se comportaba como un EmpleadoTemporal), se le asigna el comportamiento de un EmpleadoBase (empleadoB)
        poliEmpleado = empleadoB;
        System.out.println("poliEmpleado (ahora base) calcula su salario: " + poliEmpleado.calcularSalario());

        // ##### Casteo implícito (upcasting) #####
        // empleadoBase01(de tipo EmpleadoBase) es un EmpleadoBase
        EmpleadoBase empleadoBase01 = new EmpleadoBase("Test", 285, 4, 2800.0, 350.0, 180.0);
        // empleadoTest(de tipo Empleado) ahora se comporta como un empleadoBase01(de tipo EmpleadoBase)
        Empleado empleadoTest = empleadoBase01;
        System.out.println("empleadoTest calcular salario: " + empleadoTest.calcularSalario());

        // ##### Casteo explícito (downcasting) #####
        // empleadoTemporal01(de tipo Empleado) es un EmpleadoTemporal y se comportará como tal
        Empleado empleadoTemporal01 = new EmpleadoTemporal("Ana", 174, 110.0, 36);
        // empleadoTemporal02(de tipo EmpleadoTemporal) se le asigna el comportamiento de emppleadoTemporal01(de tipo Empleado)
        // Aquí tendremos un error, puesto que no está permitido decir que un Empleado "es" un EmpleadoBase o EmpleadoTemporal,
        // Lo correcto es decir que un EmpleadoBase o un EmpleadoTemporal es un Empleado (y no a la inversa)
        // Para solucionarlo se hace un "casteo" explícitp => (EmpleadoTemporal), donde se establece que empleadoTemporal01 "debe" comportarse como un EmpleadoTemporal
        EmpleadoTemporal empleadoTemporal02 = (EmpleadoTemporal) empleadoTemporal01;
        System.out.println("empleadoTemporal02.calcularSalario() = " + empleadoTemporal02.calcularSalario());

        // ########## Casteo de variables ##########
        double numDouble = 3.14;
        // int numInt = numDouble; // Esto da error, ya que estamos asignando a una variable int un valor double
        int numInt = (int) numDouble; // Se castea (se cambia el tipo de dato) de double a int
        System.out.println("numDouble = " + numDouble + ", numInt = " + numInt);
        // String numString = numDouble; // Esto da error, ya que estamos asignando a una variable Strin un valor double
        // String numString = (String) numDouble; // Esto tambien da un error, ya que en Java no se puede castear un tipo de dato numerico a string
        String numString = Double.toString(numDouble); // Se utiliza el método .toString() para poder cambiar el tipo de dato
        System.out.println("numString = " + numString);
        String numString2 = "123";
        // int numInt2 = numString2; // Esto da error debidoa a que en Java no se puede castear de un tipo de dato string a un tipo de dato numérico
        int numInt2 = Integer.parseInt(numString2); // Se utiliza el método .prseInt() para poder cambiar el tipo de dato
        System.out.println("numInt2 = " + numInt2);
    }
}