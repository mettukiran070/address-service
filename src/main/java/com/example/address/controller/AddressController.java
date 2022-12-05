package com.example.address.controller;

import com.example.address.entity.Address;
import com.example.address.exception.AddressNotFoundException;
import com.example.address.service.AddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping("/")
    public ResponseEntity<Address> save(@RequestBody Address address) {
        return new ResponseEntity<>(this.service.save(address), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Address>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable("id") Long id) {
        Address address = this.service.getById(id).orElseThrow(() -> new AddressNotFoundException());
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable("id") Long id, @RequestBody Address address) {
        this.service.getById(id).orElseThrow(() -> new AddressNotFoundException());
        return new ResponseEntity<>(this.service.update(address), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id) {
        this.service.getById(id).orElseThrow(() -> new AddressNotFoundException());
        this.service.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
