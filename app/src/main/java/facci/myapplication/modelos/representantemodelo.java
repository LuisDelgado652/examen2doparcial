package facci.myapplication.modelos;

public class representantemodelo {
    private String id, cedula, nombresapellidos, correo, iniactividades, tipocomercio;

    public representantemodelo() {
    }

    public representantemodelo(String id, String cedula, String nombresapellidos, String correo, String iniactividades, String tipocomercio) {
        this.id = id;
        this.cedula = cedula;
        this.nombresapellidos = nombresapellidos;
        this.correo = correo;
        this.iniactividades = iniactividades;
        this.tipocomercio = tipocomercio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombresapellidos() {
        return nombresapellidos;
    }

    public void setNombresapellidos(String nombresapellidos) {
        this.nombresapellidos = nombresapellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIniactividades() {
        return iniactividades;
    }

    public void setIniactividades(String iniactividades) {
        this.iniactividades = iniactividades;
    }

    public String getTipocomercio() {
        return tipocomercio;
    }

    public void setTipocomercio(String tipocomercio) {
        this.tipocomercio = tipocomercio;
    }
}
