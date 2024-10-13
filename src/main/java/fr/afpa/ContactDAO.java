package fr.afpa;

import java.applet.Applet;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO extends DAO<Contact> {
    public void insertContact(Contact contact) {
        Connection connection = Singleton.getInstance();
        PreparedStatement pstmt = null;

        try {
            // Préparation de la requête d'insertion
            String sql = "INSERT INTO contact (last_name, first_name, gender, birth_date, pseudo, personnal_number, " +
                    "professionnal_number, mail_adress, postal_adress, link_git) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstmt = connection.prepareStatement(sql);

            // Remplacement des "?" par les valeurs fournies
            pstmt.setString(1, contact.getLastName());
            pstmt.setString(2, contact.getFirstName());
            pstmt.setString(3, contact.getGender());
            pstmt.setDate(4, Date.valueOf(contact.getBirthDate()));
            pstmt.setString(5, contact.getPseudo());
            pstmt.setString(6, contact.getPrivateNumber());
            pstmt.setString(7, contact.getProfessionalNumber());
            pstmt.setString(8, contact.getMailAdress());
            pstmt.setString(9, contact.getPostalAdress());
            pstmt.setString(10, contact.getGithub());

            // Exécution de l'insertion
            int rowsAffected = pstmt.executeUpdate();

            // Affichage du résultat
            if (rowsAffected > 0) {
                System.out.println("Insertion réussie !");
            } else {
                System.out.println("Aucune ligne insérée.");
            }

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            // Fermeture des ressources
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                System.out.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
            }
        }
    }

    public void deleteContactById(int id) {
        Connection connection = Singleton.getInstance();
        PreparedStatement pstmt = null;

        try {
            // Préparation de la requête de suppression
            String sql = "DELETE FROM contact WHERE id_contact = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            // Exécution de la suppression
            int rowsAffected = pstmt.executeUpdate();

            // Vérification si un enregistrement a été supprimé
            if (rowsAffected > 0) {
                System.out.println("L'enregistrement a été supprimé avec succès.");
            } else {
                System.out.println("Aucun enregistrement trouvé.");
            }

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            // Fermeture des ressources
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                System.out.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
            }
        }
    }

    public void updateContact(Contact contact) {
        Connection connection = Singleton.getInstance();
        PreparedStatement pstmt = null;

        try {
            // Préparation de la requête de mise à jour
            String sql = "UPDATE contact SET last_name = ?, first_name = ?, gender = ?, birth_date = ?, pseudo = ?, " +
                    "personnal_number = ?, professionnal_number = ?, mail_adress = ?, postal_adress = ?, link_git = ? " +
                    "WHERE id_contact = ?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, contact.getLastName());
            pstmt.setString(2, contact.getFirstName());
            pstmt.setString(3, contact.getGender());
            pstmt.setDate(4, Date.valueOf(contact.getBirthDate()));
            pstmt.setString(5, contact.getPseudo());
            pstmt.setString(6, contact.getPrivateNumber());
            pstmt.setString(7, contact.getProfessionalNumber());
            pstmt.setString(8, contact.getMailAdress());
            pstmt.setString(9, contact.getPostalAdress());
            pstmt.setString(10, contact.getGithub());
            pstmt.setInt(11, contact.getId());

            // Exécution de la mise à jour
            int rowsAffected = pstmt.executeUpdate();

            // Affichage du résultat
            if (rowsAffected > 0) {
                System.out.println("Mise à jour réussie !");
            } else {
                System.out.println("Aucune ligne trouvée.");
            }

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            // Fermeture des ressources
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                System.out.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
            }
        }
    }

    public Contact getContactById(int id) {
        Connection connection = Singleton.getInstance();
        PreparedStatement pstmt = null;

        try {
            // Préparation de la requête de sélection
            String sql = "SELECT * FROM contact WHERE id_contact = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            try (ResultSet result = pstmt.executeQuery()) {
                if (result.next()) {
                    return new Contact(
                            result.getInt("id_contact"),
                            result.getString("last_name"),
                            result.getString("first_name"),
                            result.getString("gender"),
                            result.getObject("birth_date", LocalDate.class),
                            result.getString("pseudo"),
                            result.getString("personnal_number"),
                            result.getString("professionnal_number"),
                            result.getString("mail_adress"),
                            result.getString("postal_adress"),
                            result.getString("link_git")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération du contact : " + e.getMessage());
        } finally {
            // Fermeture des ressources
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                System.out.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
            }
        }
        return null;
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        Connection connection = Singleton.getInstance();
        Statement stmt = null;

        try {
            // Création de l'objet statement
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM contact");

            while (result.next()) {
                Contact contact = new Contact(
                        result.getInt("id_contact"),
                        result.getString("last_name"),
                        result.getString("first_name"),
                        result.getString("gender"),
                        result.getObject("birth_date", LocalDate.class),
                        result.getString("pseudo"),
                        result.getString("personnal_number"),
                        result.getString("professionnal_number"),
                        result.getString("mail_adress"),
                        result.getString("postal_adress"),
                        result.getString("link_git")
                );
                contacts.add(contact);
            }
            result.close();

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            // Fermeture des ressources
            try {
                if (stmt != null) stmt.close();
            } catch (Exception e) {
                System.out.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
            }
        }
        return contacts;
    }

    public Contact getContactByFullname(String lastName, String firstName) {
        Connection connection = Singleton.getInstance();
        PreparedStatement pstmt = null;

        try {
            // Préparation de la requête de sélection
            String sql = "SELECT * FROM contact WHERE last_name = ? AND first_name = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, lastName);
            pstmt.setString(2, firstName);

            try (ResultSet result = pstmt.executeQuery()) {
                if (result.next()) {
                    return new Contact(
                            result.getInt("id_contact"),
                            result.getString("last_name"),
                            result.getString("first_name"),
                            result.getString("gender"),
                            result.getObject("birth_date", LocalDate.class),
                            result.getString("pseudo"),
                            result.getString("personnal_number"),
                            result.getString("professionnal_number"),
                            result.getString("mail_adress"),
                            result.getString("postal_adress"),
                            result.getString("link_git")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération du contact : " + e.getMessage());
        } finally {
            // Fermeture des ressources
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                System.out.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Contact find(long id) {
        return null;
    }

    @Override
    public Contact create(Contact obj) {
        return null;
    }

    @Override
    public Contact update(Contact obj) {
        return null;
    }

    @Override
    public void delete(Contact obj) {

    }
}
