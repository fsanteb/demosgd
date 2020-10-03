package pe.gob.pnp.gestiondocumental.dto;

import pe.gob.pnp.gestiondocumental.bean.UsuariosBean;

import java.io.Serializable;
import java.util.List;

public class DcoumentoDetalleResponseDto implements Serializable {
    private String tipoDocumentoDesc;
    private String siglas;
    private String asunto;
    private String xArchivo;
    private List<UsuariosBean> usuarios;

    public String getTipoDocumentoDesc() {
        return tipoDocumentoDesc;
    }

    public void setTipoDocumentoDesc(String tipoDocumentoDesc) {
        this.tipoDocumentoDesc = tipoDocumentoDesc;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getxArchivo() {
        return xArchivo;
    }

    public void setxArchivo(String xArchivo) {
        this.xArchivo = xArchivo;
    }

    public List<UsuariosBean> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuariosBean> usuarios) {
        this.usuarios = usuarios;
    }
}
