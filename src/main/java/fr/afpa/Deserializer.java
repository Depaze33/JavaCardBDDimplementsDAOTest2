package fr.afpa;

import java.util.ArrayList;

public interface Deserializer<T> {
//Methode to Deserializaiton

    /**
     * Deseriliser : lit le fichier et prend les infos serialiser et les transforme en une liste
     *
     * @param filePath chemin de fichier
     * @return List Contact
     */
    ArrayList<T> loadList(String filePath);

    /**
     * Deserialiser (un seul contact) lit le fichier d'un seul contact, le transforme et le retourne
     *
     * @param filePath chemin de fichier
     * @return un contact
     */
    T load(String filePath);

}
