package pe.gob.pnp.gestiondocumental.util;

public enum MensajeResponse {
    MSG_200("200","Información procesada correctamente"),
    MSG_226("226","Información procesada. IM Used"),
    MSG_400("400","Error en el servicio.");

    private String codigo;
    private String mensaje;

    private MensajeResponse(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
