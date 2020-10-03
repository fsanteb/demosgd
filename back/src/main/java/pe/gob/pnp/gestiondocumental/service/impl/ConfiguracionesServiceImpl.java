package pe.gob.pnp.gestiondocumental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.pnp.gestiondocumental.bean.ConfiguracionesBean;
import pe.gob.pnp.gestiondocumental.dao.ConfiguracionesDao;
import pe.gob.pnp.gestiondocumental.service.ConfiguracionesService;

@Service
@Transactional
public class ConfiguracionesServiceImpl implements ConfiguracionesService {

    @Override
    public String calcularSigla(Integer documentotipo_id) {
        String siglaResultado = "";

        /**
        Falta agregar aqui para el calculo

         ConfiguracionesBean bean = findByIdTipoDocumento(documentotipo_id);

        int numeroNuevo = bean.getNumero() + 1;
        int longitud = bean.getNumero_longitud();
        siglaResultado = bean.getSiglas();
        String numCadena = "" + numeroNuevo;

        for(int i=1; i < longitud ; i++){
            numCadena = "0" + numCadena;
        }
        return siglaResultado.replace("XXX", numCadena);
         **/

        return null;
    }

}
