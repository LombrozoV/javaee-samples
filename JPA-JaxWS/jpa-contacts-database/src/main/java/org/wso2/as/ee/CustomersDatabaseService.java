package org.wso2.as.ee;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class CustomersDatabaseService {

    @EJB
    ContactManager contactManager;

    @WebMethod
    public ContactsDTO getContacts() throws Exception {

        List<ContactDTO> contactsList = new ArrayList<ContactDTO>();

        for (Contact contact : contactManager.getContacts()) {
            contactsList.add(new ContactDTO(contact.getName(), contact.getContactNumber(), contact.getAge(), contact.getEmail(), contact.getBirthday()));
        }

        ContactsDTO contactsDTO = new ContactsDTO(contactsList);
        return contactsDTO;
    }

    @WebMethod
    public String addContact(ContactDTO contact) throws Exception {
        Contact contactEntity = new Contact(contact.getName(), contact.getContactNumber(), contact.getAge(), contact.getEmail(), contact.getBirthday());
        return contactManager.addContact(contactEntity);
    }
}
