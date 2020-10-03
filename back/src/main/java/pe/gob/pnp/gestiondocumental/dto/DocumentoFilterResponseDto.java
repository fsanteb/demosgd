package pe.gob.pnp.gestiondocumental.dto;

import java.io.Serializable;

public class DocumentoFilterResponseDto implements Serializable {

    private String tipoDocumentoDesc;
    private String asunto;
    private String siglas;
    private String archivo;
    private int idDocumento;

    public String getTipoDocumentoDesc() {
        return tipoDocumentoDesc;
    }

    public void setTipoDocumentoDesc(String tipoDocumentoDesc) {
        this.tipoDocumentoDesc = tipoDocumentoDesc;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }
}
