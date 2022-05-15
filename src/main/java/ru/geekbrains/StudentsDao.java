package ru.geekbrains;

import java.util.List;

public interface StudentsDao {
    Students findById(Long id);

    List<Students> findByName(String name);

    List<Students> findAll();

    void save(Students students);

    void updateNameById(Long id, String newName);
}
