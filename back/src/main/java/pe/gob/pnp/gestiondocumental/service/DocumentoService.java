package pe.gob.pnp.gestiondocumental.service;

import pe.gob.pnp.gestiondocumental.bean.DocumentoBean;
import pe.gob.pnp.gestiondocumental.dto.DcoumentoDetalleResponseDto;
import pe.gob.pnp.gestiondocumental.dto.DocumentoFilterRequestDto;
import pe.gob.pnp.gestiondocumental.dto.DocumentoFilterResponseDto;

import java.io.IOException;
import java.util.List;

public interface DocumentoService {
    List<DocumentoFilterResponseDto> buscar(DocumentoFilterRequestDto dto);
    DcoumentoDetalleResponseDto detalleDocumento(Integer idDocumento) throws IOException;
    int deleteDocumento(Integer idDocumento);
}
