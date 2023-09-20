package com.shimada.pastebin.services;

import com.shimada.pastebin.Entity.Bin;
import com.shimada.pastebin.repositories.BinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BinService {

    private final BinRepository binRepository;

    @Autowired
    public BinService(BinRepository binRepository) {
        this.binRepository = binRepository;
    }

    public ResponseEntity save(Bin bin) {
        return new ResponseEntity(binRepository.save(bin), HttpStatus.OK);
    }

    public void delete(Bin bin) {
        binRepository.delete(bin);
    }

    public ResponseEntity findAll() {
        return new ResponseEntity(binRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity findById(Long id) {
        return new ResponseEntity(binRepository.findAllByUserId(id), HttpStatus.OK);
    }
}
