package arrayList.GestionDeCuentas;

public class CuentaPersona extends Cuenta {

    //atributos
    private String nombre;
    private String apellido;

    CuentaPersona(int nroCuenta, double saldo, String nombre, String apellido){
        this.numeroCuenta=nroCuenta;
        this.saldo=saldo;
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public int getNumCuenta() {
        return numeroCuenta;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    //metodos
    @Override
    public void depositar(double cantidad){
        this.saldo+=cantidad;
        System.out.println("se depositaron $"+cantidad);
        System.out.println("nuevo saldo: $"+this.saldo);
    }

    @Override
    public void retirar(double cantidad){


        if(this.saldo>=cantidad){
            this.saldo=this.saldo-cantidad;
            System.out.println("se retiraron $"+cantidad);
            System.out.println("nuevo saldo: $"+this.saldo);
        }else{
            System.out.println("no hay ese dinero en la cuenta :(");
        }

    }

    @Override
    public void mostrarInformacion(){
        System.out.println("cuenta: "+this.numeroCuenta+"   -   nombre: "+this.nombre+", "+this.apellido+"   -   saldo: $"+this.saldo);
    }



}
