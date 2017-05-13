package com.ground0.rest.dao;

import com.ground0.rest.model.Location;
import com.ground0.rest.model.Message;
import com.ground0.rest.util.SessionUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by zer0 on 11/2/17.
 */
public class LocationDAO {

    public void addLocation(Location location) {
        if (!isLocationPresent(location)) {
            Session session = SessionUtil.getSession();
            Transaction transaction = session.beginTransaction();
            addLocation(session, location);
            transaction.commit();
            session.close();
        }
    }

    private void addLocation(Session session, Location location) {
        Location newLocation = new Location();
        newLocation.setDescription(location.getDescription());
        newLocation.setLatitude(location.getLatitude());
        newLocation.setLongitude(location.getLongitude());
        newLocation.setName(location.getName());
        session.save(newLocation);
    }

    private boolean isLocationPresent(Location location) {
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("from Location where latitude > " + (location.getLatitude() + 10) + "and latitude < " + (location.getLatitude() - 10) + "and longitude > " + (location.getLongitude() + 10) + "and longitude < " + (location.getLongitude() - 10));
        List<Location> messages = query.list();
        session.close();
        return !messages.isEmpty();
    }
}
