package com.ground0.rest.dao;

import com.ground0.rest.model.Location;
import com.ground0.rest.model.Trip;
import com.ground0.rest.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by zer0 on 11/2/17.
 */
public class TripDAO {


    public void addTrip(Trip trip) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        addTrip(session, trip);
        transaction.commit();
        session.close();
    }

    private void addTrip(Session session, Trip trip) {
        Trip newTrip = new Trip();
        newTrip.setStart_time(trip.getStart_time());
        newTrip.setEnd_time(trip.getEnd_time());
        newTrip.setEnd_location(trip.getEnd_location());
        newTrip.setStart_location(trip.getStart_location());
        session.save(newTrip);
    }
}
