package com.shimada.pastebin.controllers;

import com.shimada.pastebin.entity.Bin;
import com.shimada.pastebin.entity.User;
import com.shimada.pastebin.requests.BinRequest;
import com.shimada.pastebin.services.BinService;
import com.shimada.pastebin.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bins")
public class BinController {


    private BinService binService;
    private UserService userService;

    @Autowired
    public BinController(BinService binsService, UserService userService) {
        this.binService = binsService;
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Get all bins")
    public ResponseEntity getAllBins() {
        return ResponseEntity.status(HttpStatus.OK).body(binService.findAll());
    }

    /*@GetMapping("/{id}")
    @Operation(summary = "Get bins by user ID")
    public ResponseEntity getAllBinsByUserId(@PathVariable Long id) {
        var user = userService.findUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user.getBins());
    }*/

    @GetMapping("/{id}")
    @Operation(summary = "Get bin by bin ID")
    public ResponseEntity getBinById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(binService.findById(id));
    }

    @PostMapping("/create")
    @Operation(summary = "Create new bin")
    public ResponseEntity createBin(@RequestBody BinRequest binRequest) {
        Bin bin = new Bin();
        bin.setText(binRequest.getText());

        User user = userService.findUserById(binRequest.getUserId());
        bin.setUser(user);

        Bin savedBin = binService.save(bin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBin);
    }

}

