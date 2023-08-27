package br.ufc.crateus.madacarudev.country_town_paths.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.crateus.madacarudev.country_town_paths.services.interfaces.IStorageService;

@Service
public class FirebaseStorageService implements IStorageService {
    @Override
    public String save(String directory, MultipartFile file) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(String resourceUrl) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
   
}
