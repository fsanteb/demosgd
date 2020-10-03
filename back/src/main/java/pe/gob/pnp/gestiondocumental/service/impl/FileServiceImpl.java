package pe.gob.pnp.gestiondocumental.service.impl;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.pnp.gestiondocumental.service.FileService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
@Transactional
public class FileServiceImpl implements FileService {
    @Override
    public String getFileBase64(String fileName) throws IOException {
        String encodedString = "";
        try {
            byte[] fileContent = FileUtils.readFileToByteArray(new File("E:\\" + fileName));
            encodedString = Base64.encodeBase64String(fileContent);
        }catch(FileNotFoundException fex) {
            return null;
        }
        return encodedString;
    }
}
