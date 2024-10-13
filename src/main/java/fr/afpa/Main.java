package fr.afpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println("ghfhf");
//        SelectContact selectContact = new SelectContact();
//        List<Contact> contacts = selectContact.getAllContacts();
//        System.out.println(contacts.toString());  // Correctement afficher chaque contact
//
//        // Affiche les détails de chaque contact
//        for (Contact contact : contacts) {
//            System.out.println(contact);  // Correctement afficher chaque contact
//        }
//
//        SelectOneContact selectOneContact = new SelectOneContact();
//        Contact contact = SelectOneContact.getContactById(10);  // Récupère le contact avec l'ID 1
//        if (contact != null) {
//            System.out.println(STR."Détails du contact avec l'ID  : \{contact}");
//        } else {
//            System.out.println("Aucun contact trouvé avec l'ID ");
//        }
//        Delete delete = new Delete();
//        delete.deleteRecord(1);
//
//        InsertContact insertContact = new InsertContact();
//        insertContact.insertContact(
//                "Lovelace",                     // lastName
//                "Ada",                          // firstName
//                "F",                            // gender
//                LocalDate.of(1815, 12, 10),     // birthDate
//                "adalovelace",                  // pseudo
//                "0601020304",                   // personnalNumber
//                "0145678901",                   // professionalNumber
//                "ada@computing.co.uk",          // mailAddress
//                "123 Science Street, London",   // postalAddress
//                "https://github.com/adalovelace" // linkGit
//        );
//
//
//        UpdateContact updateContact = new UpdateContact();
//
//        // Appel de la méthode updateContact avec les nouvelles valeurs
//        updateContact.updateContact(
//                1,                             // ID du contact à mettre à jour
//                "Lovelace",                    // lastName
//                "Ada",                         // firstName
//                "F",                           // gender
//                LocalDate.of(1815, 12, 10),    // birthDate
//                "adalovelace_updated",         // pseudo
//                "0601020305",                  // personnalNumber
//                "0145678902",                  // professionalNumber
//                "ada.lovelace@updated.co.uk",  // mailAddress
//                "123 Updated Street, London",  // postalAddress
//                "https://github.com/ada_updated" // linkGit
//        );
//
//        System.out.println("Modification du contact effectuée.");




//        System.out.println("Début du programme");
//
//        // Création d'un objet ContactDAO
        ContactDAO contactDAO = new ContactDAO();
//
//        // Création d'un nouvel objet Contact
        Contact newContact = new Contact(
                17,
                "Marie",                     // lastName
                "Adama",                          // firstName
                "N-B",                            // gender
                LocalDate.of(1815, 12, 10),     // birthDate
                "",                  // pseudo
                "0601020304",                   // personnalNumber
                "0145678901",                   // professionalNumber
                "marie@gmail.com",          // mailAddress
                "123 Science Street, London",   // postalAddress
                "https://github.com/MarieAdama" // linkGit
        );

        // Appel de la méthode insertContact pour insérer le nouveau contact
//        contactDAO.insertContact(newContact);
        // contactDAO.deleteContactById(19);
       // contactDAO.updateContact(newContact);



        Contact contact = contactDAO.getContactById(3);
        System.out.println(contact);

//        Contact contactByName = contactDAO.getContactByFullname("Lovelace", "Ada");
//        System.out.println(contactByName);

//        List<Contact> contacts = contactDAO.getAllContacts();
//        for (Contact c : contacts) {
//            System.out.println(c);
//        }
//
//        System.out.println("Fin du programme");








}
}
