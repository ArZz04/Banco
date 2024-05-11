package builders;

public class Cliente {

    // ID, NOMBRE, APELLIDO PATERNO, APELLIDO MATERNO, domicilio
    private String nombre, apellidoP, apellidoM, domicilio, ciudad, tipoCuenta;
    private Long telefono;

    public Cliente(String nombre, String apellidoP, String apellidoM, String domicilio, String ciudad, Long telefono, String tipoCuenta){
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.tipoCuenta = tipoCuenta;
    }

    public Cliente(String nombre) {
    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Long getTelefono() {
        return telefono;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
}
