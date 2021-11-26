package by.it.academy.listener;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent sessionEvent) {
		System.out.println("Session created:: ID " + sessionEvent.getSession().getId());
	}
	
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		System.out.println("Session destroyed:: ID " + sessionEvent.getSession().getId());
	} 
}
