package pe.gob.pnp.gestiondocumental.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.gob.pnp.gestiondocumental.bean.DocumentoBean;
import pe.gob.pnp.gestiondocumental.bean.DocumentoTiposBean;
import pe.gob.pnp.gestiondocumental.dto.DcoumentoDetalleResponseDto;
import pe.gob.pnp.gestiondocumental.dto.DocumentoFilterRequestDto;
import pe.gob.pnp.gestiondocumental.dto.DocumentoFilterResponseDto;
import pe.gob.pnp.gestiondocumental.dto.ResponseDTO;
import pe.gob.pnp.gestiondocumental.service.ConfiguracionesService;
import pe.gob.pnp.gestiondocumental.service.DocumentoService;
import pe.gob.pnp.gestiondocumental.service.DocumentoTiposService;
import pe.gob.pnp.gestiondocumental.util.MensajeResponse;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("documento")
@Api(value = "Administración de documentos")
public class DocumentoController {

    @Autowired
    DocumentoService documentoService;

    @Autowired
    DocumentoTiposService documentoTiposService;

    @Autowired
    ConfiguracionesService configuracionesService;

    @PostMapping(value ="/busqueda", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Filtro para buscar un Documento")
    public ResponseDTO<List<DocumentoFilterResponseDto>> filtroBusqueda(@RequestBody DocumentoFilterRequestDto dto){
        ResponseDTO response = new ResponseDTO();
        List<DocumentoFilterResponseDto> lista = documentoService.buscar(dto);
        response.setCodigo(MensajeResponse.MSG_200.getCodigo());
        response.setMensaje(MensajeResponse.MSG_200.getMensaje());
        response.setData(lista);
        return response;
    }

    @GetMapping(value ="/detalle/{idDocumento}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseDTO<DcoumentoDetalleResponseDto> detalleDocumento(@PathVariable("idDocumento") Integer idDocumento) throws IOException {
        ResponseDTO response = new ResponseDTO();
        DcoumentoDetalleResponseDto bean = documentoService.detalleDocumento(idDocumento);
        response.setCodigo(MensajeResponse.MSG_200.getCodigo());
        response.setMensaje(MensajeResponse.MSG_200.getMensaje());
        response.setData(bean);
        return response;
    }

    @GetMapping(value ="/tipos", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseDTO<List<DocumentoTiposBean>> consultar(){
        ResponseDTO response = new ResponseDTO();
        List<DocumentoTiposBean> lista = documentoTiposService.listar();
        response.setCodigo(MensajeResponse.MSG_200.getCodigo());
        response.setMensaje(MensajeResponse.MSG_200.getMensaje());
        response.setData(lista);
        return response;
    }

    @GetMapping(value ="/calcularSigla/{documentotipo}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseDTO<String> calcularSigla(@PathVariable("documentotipo") Integer documentotipo){
        ResponseDTO response = new ResponseDTO();
        response.setCodigo(MensajeResponse.MSG_200.getCodigo());
        response.setMensaje(MensajeResponse.MSG_200.getMensaje());
        response.setData(configuracionesService.calcularSigla(documentotipo));
        return response;
    }

    @DeleteMapping(value ="/eliminar/{idDocumento}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseDTO<Integer> eliminarDocumento(@PathVariable("idDocumento") Integer idDocumento) throws IOException {
        ResponseDTO response = new ResponseDTO();
        int resultado = documentoService.deleteDocumento(idDocumento);
        response.setCodigo(MensajeResponse.MSG_200.getCodigo());
        response.setMensaje(MensajeResponse.MSG_200.getMensaje());
        response.setData(resultado);
        return response;
    }
}
