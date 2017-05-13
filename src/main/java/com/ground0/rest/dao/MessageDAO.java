package com.ground0.rest.dao;

import com.ground0.rest.model.Message;
import com.ground0.rest.util.SessionUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by zer0 on 4/2/17.
 */
public class MessageDAO {


    public void addMessage(Message message) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        addMessage(session, message);
        transaction.commit();
        session.close();
    }

    private void addMessage(Session session, Message message) {
        Message newMessage = new Message();
        newMessage.setData(message.getData());
        session.save(newMessage);
    }

    public List<Message> getMessages() {
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("from Message");
        List<Message> messages = query.list();
        session.close();
        return messages;
    }
}
