package arrayList.GestionDeCuentas;

public abstract class Cuenta {

    //atributos
    protected  int numeroCuenta;
    protected double saldo;

    //metodos
    public abstract void depositar(double cantidad);
    public abstract void retirar(double cantidad);
    public abstract void mostrarInformacion();


}
