package fr.eni.projetEnchereHugo.dal;

import fr.eni.projetEnchereHugo.bo.Utilisateur;
import java.util.List;

public interface UtilisateurDAO {
    void save(Utilisateur utilisateur);
    Utilisateur getById(int id);
    List<Utilisateur> getAll();
    void update(Utilisateur utilisateur);
    void delete(int id);
    Utilisateur findByUsername(String username);
}
