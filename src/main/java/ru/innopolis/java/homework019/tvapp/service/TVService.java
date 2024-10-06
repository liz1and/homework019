package ru.innopolis.java.homework019.tvapp.service;

import ru.innopolis.java.homework019.tvapp.model.TV;

import java.util.List;

public interface TVService {
    TV createTV(TV tv);
    TV updateTV(TV tv);
    void deleteTV(Long id);
    TV getTVById(Long id);
    List<TV> getAllTVs();
}
