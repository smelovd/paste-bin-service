package com.shimada.pastebin.controllers;

import com.shimada.pastebin.Entity.Bin;
import com.shimada.pastebin.services.BinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BinController {


    private BinService binsService;

    @Autowired
    public BinController(BinService binsService) {
        this.binsService = binsService;
    }

    @PostMapping("/bins/create")
    public ResponseEntity createBin(Bin bin) {
        return binsService.save(bin);
    }

    @DeleteMapping("/bins/remove")
    public HttpStatus deleteBin(Bin bin) {
        binsService.delete(bin);
        return HttpStatus.OK;
    }

    @GetMapping("/bins")
    public ResponseEntity getAllBins() {
        return binsService.findAll();
    }

    @GetMapping("/bins/{id}")
    public ResponseEntity getAllBins(@PathVariable Long id) {
        return binsService.findById(id);
    }
}
