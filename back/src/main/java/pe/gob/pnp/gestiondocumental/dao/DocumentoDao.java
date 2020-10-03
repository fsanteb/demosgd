package pe.gob.pnp.gestiondocumental.dao;

import pe.gob.pnp.gestiondocumental.bean.DocumentoBean;
import pe.gob.pnp.gestiondocumental.dto.DocumentoFilterRequestDto;
import pe.gob.pnp.gestiondocumental.dto.DocumentoFilterResponseDto;

import java.util.List;

public interface DocumentoDao {
    int registrar(DocumentoBean bean);
    List<DocumentoFilterResponseDto> buscar(DocumentoFilterRequestDto dto);
    DocumentoBean detalleDocumento(Integer idDocumento);
    int deleteDocumento(Integer idDocumento);
    int deleteDocumentoUsuario(Integer idDocumento);
}
