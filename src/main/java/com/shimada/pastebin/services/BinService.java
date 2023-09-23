package com.shimada.pastebin.services;

import com.shimada.pastebin.entity.Bin;
import com.shimada.pastebin.repositories.BinRepository;
import com.shimada.pastebin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinService {

    private final BinRepository binRepository;

    private final UserRepository userRepository;

    @Autowired
    public BinService(BinRepository binRepository, UserRepository userRepository) {
        this.binRepository = binRepository;
        this.userRepository = userRepository;
    }

    public void delete(Bin bin) {
        binRepository.delete(bin);
    }

    public ResponseEntity findBinsByUserId() {
        return new ResponseEntity(binRepository.findAll(), HttpStatus.OK);
    }


    public Bin save(Bin bin) {
        return binRepository.save(bin);
    }

    public List<Bin> findAll() {
        return binRepository.findAll();
    }

    public Object findById(Long id) {
        return binRepository.findById(id);
    }
}
