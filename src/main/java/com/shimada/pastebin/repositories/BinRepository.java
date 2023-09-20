package com.shimada.pastebin.repositories;

import com.shimada.pastebin.Entity.Bin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BinRepository extends JpaRepository<Bin, Long> {


    Optional<Bin> findAllByUserId(Long aLong);


}
