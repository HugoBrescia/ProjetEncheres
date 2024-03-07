package fr.eni.projetEnchereHugo.dal;

import java.util.List;

import fr.eni.projetEnchereHugo.bo.Categorie;

public interface CategorieDAO {
    void save(Categorie categorie);
    Categorie getById(int id);
    void update(Categorie categorie);
    void delete(int id);
    List<Categorie> getAll();
}