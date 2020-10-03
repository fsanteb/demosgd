package pe.gob.pnp.gestiondocumental.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class DocumentoBean implements Serializable {
    @JsonIgnore
    private int id;
    private String numero_siglas;
    private String asunto;
    private String archivo;
    private int documentotipo_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero_siglas() {
        return numero_siglas;
    }

    public void setNumero_siglas(String numero_siglas) {
        this.numero_siglas = numero_siglas;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public int getDocumentotipo_id() {
        return documentotipo_id;
    }

    public void setDocumentotipo_id(int documentotipo_id) {
        this.documentotipo_id = documentotipo_id;
    }
}
