/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.riyandi.matakuliah.controller;

import com.riyandi.matakuliah.entity.Matakuliah;
import com.riyandi.matakuliah.service.MatakuliahService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author xxyan
 */
@RestController
@RequestMapping("api/v1/matakuliah")
public class MatakuliahController {

    @Autowired
    private MatakuliahService matakuliahservice;

    @GetMapping
    public List<Matakuliah> getAll() {
        return matakuliahservice.getAll();
    }

    @PostMapping
    public void insert(@RequestBody Matakuliah matkul) {
        matakuliahservice.insert(matkul);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        matakuliahservice.delete(id);
    }

   

}
