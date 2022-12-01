package com.example.address.service;

import com.example.address.entity.Address;
import com.example.address.repository.AddressRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public Address save(Address address) {
        return this.repository.save(address);
    }

    public List<Address> getAll(){
        return this.repository.findAll();
    }

    public Optional<Address> getById(Long id) {
        return this.repository.findById(id);
    }

    public Address update(Address address) {
        return this.repository.save(address);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

}
