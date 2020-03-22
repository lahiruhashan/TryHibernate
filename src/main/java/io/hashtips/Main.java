package io.hashtips;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;

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

//        Address address = new Address();
//        address.setStreet("street 1");
//        address.setCity("city 1");
//        address.setState("state 1");
//        address.setPinCode("12345");
//        userDetails.setAddress(address);
//
//        Address officeAddress = new Address();
//        officeAddress.setStreet("street 2");
//        officeAddress.setCity("city 2");
//        officeAddress.setState("state 2");
//        officeAddress.setPinCode("67909");
//        userDetails.setOfficeAddress(officeAddress);

//        userDetails.setDescription("Description of the user");

//        session.save(userDetails);




//        User user = new User();
//        user.setUsername("Hashan");
//
//        User user1 = new User();
//        user1.setUsername("Lahiru");
//
//        User user2 = new User();
//        user2.setUsername("Perera");

//        Vehicle vehicle = new Vehicle();
//        vehicle.setVehicleName("Car");
//
//        Vehicle vehicle2 = new Vehicle();
//        vehicle2.setVehicleName("Jeep");
//
//        TwoWheeler bike = new TwoWheeler();
//        bike.setVehicleName("Bike");
//        bike.setSteeringHandle("Bike Steering Handle");
//
//        FourWheeler car = new FourWheeler();
//        car.setVehicleName("Porsche");
//        car.setSteeringWheel("Porsche Steering Wheel");


//        user.getVehicle().add(vehicle);
//        user.getVehicle().add(vehicle2);

//        session.persist(user);
//        session.save(vehicle);
//        session.save(car);
//        session.save(bike);

//
//        Hotel hotel = new Hotel();
//        hotel.setHotelName("hotel 1");
//        session.save(hotel);

//        RoomType roomType = new RoomType();
//        roomType.setRoomTypeName("Room Type 1");
//        session.save(roomType);

//        session.save(user);
//        session.save(user1);
//        session.save(user2);

//        User returnedUser = session.get(User.class, 3);
//        System.out.println("Username : " + returnedUser.getUsername());

//        session.delete(returnedUser);

//        User returnedUser = session.get(User.class, 2);
//        returnedUser.setUsername("Lahiru");
//        session.update(returnedUser);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("select new map (userId, username) from User");
        query.setFirstResult(2);
        query.setMaxResults(3);
        List<HashMap<Integer, String>> users = query.list();
        System.out.println(users.size());

        session.getTransaction().commit();
        session.close();

        for (HashMap u: users) {
            System.out.println(u.values());
        }
//
//        userDetails = null;
//        session = sessionFactory.openSession();
//        user = session.get(User.class, 1);
//        System.out.println(user.getVehicle().size());
//        session.close();
    }
}