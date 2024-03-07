package fr.eni.projetEnchereHugo.dal;

import java.util.List;

import fr.eni.projetEnchereHugo.bo.Retrait;

public interface RetraitDAO {
    void save(Retrait retrait);
    Retrait getById(int id);
    void update(Retrait retrait);
    void delete(int id);
	List<Retrait> getAll();
}
