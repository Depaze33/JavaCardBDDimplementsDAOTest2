package fr.afpa;

import java.io.IOException;
import java.util.ArrayList;

public interface Serializer<T> {
    //Methode for serialization

    /**
     * serialiser = enregistrer de la donnée dans un format particulier(vcard, Json, Binaire ...) dans un fochier ici filePath
     *
     * @param filePath     chemin vers un fichier
     * @param objectToSave list
     * @throws IOException
     */
    //filePath peux contenir les dossiers parents
    void saveList(String filePath, ArrayList<T> objectToSave) throws IOException;

    /**
     * Enregistre qu'un seul contact dans un format particulier
     * @param filePath chemin vers un fichier
     * @param objectToSave objet
     * @throws IOException
     */
    void save(String filePath, T objectToSave) throws IOException;

}
