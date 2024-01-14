/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riyandi.matakuliah.repository;

import com.riyandi.matakuliah.entity.Matakuliah;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author xxyan
 */
public interface MatakuliahRepository extends JpaRepository<Matakuliah, Long> {

    public Optional<Matakuliah> findMatakuliahByNama(String nama);

    public Optional<Matakuliah> findMatakuliahByKode(String kode);

    public Optional<Matakuliah> findMatakuliahBySks(int sks);
    
}