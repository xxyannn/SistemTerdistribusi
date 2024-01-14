/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.riyandi.nilai.repository;

import com.riyandi.nilai.entity.Nilai;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author xxyan
 */
public interface NilaiRepository extends JpaRepository<Nilai, Long>{
    
}
