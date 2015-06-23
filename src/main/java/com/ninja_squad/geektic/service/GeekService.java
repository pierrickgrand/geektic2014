package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.Dao.GeekDao;
import com.ninja_squad.geektic.model.Geek;


@RestController
@Transactional
@RequestMapping("/Geeks")
public class GeekService {


    @Autowired
    private GeekDao lesGeeks;

    @RequestMapping(method = RequestMethod.GET)
    public List<Geek> getGeeks()
    {
        List<Geek> MesGeeks = lesGeeks.getAllGeeks();
        return MesGeeks;
    }

    @RequestMapping(method = RequestMethod.GET, params= "sexe")
    public List<Geek> getGeeksBySexe(@RequestParam("sexe") String sexe)
    {
        List<Geek> MesGeeks = lesGeeks.getAllGeek(sexe);
        return MesGeeks;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Geek getGeekById(@PathVariable int id)
    {
        Geek monGeek= lesGeeks.getGeekById(id);
        return monGeek;
    }

}


