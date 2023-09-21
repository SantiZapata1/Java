package arrayList.GestionDeCuentas;

public class CuentaSociedad extends Cuenta {

    //atributos
    private String nombreEmpresa;
    private String tipoEmpresa;

    CuentaSociedad(int nroCuenta, double saldo, String nombreEmpresa, String tipoEmpresa){
        this.numeroCuenta=nroCuenta;
        this.saldo=saldo;
        this.nombreEmpresa=nombreEmpresa;
        this.tipoEmpresa=tipoEmpresa;
    }
    public int getNumCuenta() {
        return numeroCuenta;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
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
        System.out.println("cuenta: "+this.numeroCuenta+"   -   nombre empresa: "+this.nombreEmpresa+"  -  tipo empresa: "+this.tipoEmpresa+"   -   saldo: $"+this.saldo);
    }



}
