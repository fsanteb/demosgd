package pe.gob.pnp.gestiondocumental.dao;

import pe.gob.pnp.gestiondocumental.bean.DocumentoTiposBean;

import java.util.List;

public interface DocumentoTiposDao {
    List<DocumentoTiposBean> listar();
    DocumentoTiposBean obtenerDocumentoTipo(Integer id);
}
