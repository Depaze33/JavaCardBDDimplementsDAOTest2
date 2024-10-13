package fr.afpa;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ContactJsonSerialiazer implements Serializer<Contact> {

    private final ObjectMapper mapper;

    public ContactJsonSerialiazer() {
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public void saveList(String filePath, ArrayList<Contact> objectToSave) throws IOException {
        // writerWithDefaultPrettyPrinter add indentation & breaklines
        String contact = null;


        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), objectToSave);
    }

    public ArrayList<Object> listerContactDTO(ArrayList<Contact> contacts) {
        ArrayList<Object> listeContactDTO = new ArrayList<>();

        for (Contact contact : contacts) {
            ContactDTO contactDTO = new ContactDTO(contact.getLastName(), contact.getFirstName(),
                    contact.getGender(), contact.getBirthDate(), contact.getPseudo(),
                    contact.getPrivateNumber(), contact.getProfessionalNumber(), contact.getMailAdress(),
                    contact.getPostalAdress(),
                    contact.getGithub(), contact.getId());

            listeContactDTO.add(contactDTO);
        }

        return listeContactDTO;
    }

    /**
     * la fonction prend en entrée un contact et retourne un contactDTO du type ContactDTO
     * Fais la conversion
     *
     * @param contact de la classe Contact
     * @return contactDTO
     */
    private ContactDTO newContactDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO(contact.getLastName(), contact.getFirstName(),
                contact.getGender(), contact.getBirthDate(), contact.getPseudo(),
                contact.getPrivateNumber(), contact.getProfessionalNumber(), contact.getMailAdress(),
                contact.getPostalAdress(),
                contact.getGithub(), contact.getId());
        return contactDTO;
    }

    /**
     * @param filePath     chemin vers LE fichier
     * @param objectToSave objet
     * @throws IOException
     */
    @Override
    public void save(String filePath, Contact objectToSave) throws IOException {
        // writerWithDefaultPrettyPrinter add indentation & breaklines
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), newContactDTO(objectToSave));
    }


    @JsonRootName(value = "contact")
    private static class ContactDTO {


        public String lastName;
        public String firstName;
        public String gender;
        public LocalDate birthDate;
        public String pseudo;
        public String privateNumber;
        public String professionalNumber;
        public String mailAdress;
        public String postalAdress;
        public String github;
        public String id;

        public ContactDTO(String lastName, String firstName, String gender, LocalDate birthDate, String pseudo,
                          String privateNumber, String professionalNumber, String mailAdress, String postalAdress, String github, String id) {

            this.lastName = lastName;
            this.firstName = firstName;
            this.gender = gender;
            this.birthDate = birthDate;
            this.pseudo = pseudo;
            this.privateNumber = privateNumber;
            this.professionalNumber = professionalNumber;
            this.mailAdress = mailAdress;
            this.postalAdress = postalAdress;
            this.github = github;
            this.id = id;

        }
    }

}
//ObjectMapper : Prend objet java et le transforme en JSON ou dans l'autre sens aussi
// Module controller comment certaine chose sont gerer.
//PrettyPrint la jolie affiche