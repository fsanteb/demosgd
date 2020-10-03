package pe.gob.pnp.gestiondocumental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.pnp.gestiondocumental.bean.DocumentoTiposBean;
import pe.gob.pnp.gestiondocumental.dao.DocumentoTiposDao;
import pe.gob.pnp.gestiondocumental.service.DocumentoTiposService;

import java.util.List;

@Service
@Transactional
public class DocumentoTiposServiceImpl implements DocumentoTiposService {

    @Autowired
    DocumentoTiposDao documentoTiposDao;

    @Override
    public List<DocumentoTiposBean> listar() {
        return documentoTiposDao.listar();
    }
}
