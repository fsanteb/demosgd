package pe.gob.pnp.gestiondocumental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.pnp.gestiondocumental.bean.DocumentoBean;
import pe.gob.pnp.gestiondocumental.dao.DocumentoDao;
import pe.gob.pnp.gestiondocumental.dao.DocumentoTiposDao;
import pe.gob.pnp.gestiondocumental.dao.UsuariosDao;
import pe.gob.pnp.gestiondocumental.dto.DcoumentoDetalleResponseDto;
import pe.gob.pnp.gestiondocumental.dto.DocumentoFilterRequestDto;
import pe.gob.pnp.gestiondocumental.dto.DocumentoFilterResponseDto;
import pe.gob.pnp.gestiondocumental.service.ConfiguracionesService;
import pe.gob.pnp.gestiondocumental.service.DocumentoService;
import pe.gob.pnp.gestiondocumental.service.FileService;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    DocumentoDao documentoDao;

    @Autowired
    ConfiguracionesService configuracionesService;

    @Autowired
    UsuariosDao usuariosDao;

    @Autowired
    FileService fileService;

    @Override
    public List<DocumentoFilterResponseDto> buscar(DocumentoFilterRequestDto dto) {
        return documentoDao.buscar(dto);
    }

    @Override
    public DcoumentoDetalleResponseDto detalleDocumento(Integer idDocumento) throws IOException {
        DcoumentoDetalleResponseDto result = new DcoumentoDetalleResponseDto();
        DocumentoBean bean = documentoDao.detalleDocumento(idDocumento);
        result.setAsunto(bean.getAsunto());
        result.setSiglas(bean.getNumero_siglas());
        result.setUsuarios(usuariosDao.usuariosXDocumento(idDocumento));
        result.setxArchivo(fileService.getFileBase64(bean.getArchivo()));

        return result;
    }

    @Override
    public int deleteDocumento(Integer idDocumento){
        documentoDao.deleteDocumentoUsuario(idDocumento);
        documentoDao.deleteDocumento(idDocumento);
        return 1;
    }


}
