package io.hashtips;

import io.hashtips.dto.Address;
import io.hashtips.dto.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        UserDetails userDetails = new UserDetails();
//        userDetails.setUserName("Lahiru");
//        userDetails.setJoinedDate(new Date());

        Address address = new Address();
        address.setStreet("street 1");
        address.setCity("city 1");
        address.setState("state 1");
        address.setPinCode("12345");
//        userDetails.setAddress(address);

        Address officeAddress = new Address();
        officeAddress.setStreet("street 2");
        officeAddress.setCity("city 2");
        officeAddress.setState("state 2");
        officeAddress.setPinCode("67909");
//        userDetails.setOfficeAddress(officeAddress);

//        userDetails.setDescription("Description of the user");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        session.save(userDetails);

        User user = new User();
        user.setUsername("Hashan");
        HashSet<Address> addresses = new HashSet<Address>();
        addresses.add(address);
        addresses.add(officeAddress);
        user.setListOfAddresses(addresses);
        session.save(user);


//
//        Hotel hotel = new Hotel();
//        hotel.setHotelName("hotel 1");
//        session.save(hotel);

//        RoomType roomType = new RoomType();
//        roomType.setRoomTypeName("Room Type 1");
//        session.save(roomType);

        session.getTransaction().commit();
        session.close();
//
//        userDetails = null;
        session = sessionFactory.openSession();
        user = session.get(User.class, 1);
        session.close();
        System.out.println(user.getListOfAddresses().size());
    }
}