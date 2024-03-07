package fr.eni.projetEnchereHugo.dal;

import fr.eni.projetEnchereHugo.bo.Enchere;

import java.util.List;

public interface EnchereDAO {
    void save(Enchere enchere);
    Enchere getById(int id);
    void update(Enchere enchere);
    void delete(int id);
    List<Enchere> getAll();
}
