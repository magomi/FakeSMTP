package com.nilhcem.fakesmtp.check;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Marco Grunert (magomi@gmail.com)
 */
public class CheckHttpHandler extends AbstractHandler {

    @Override public void handle(String s, Request request, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws IOException, ServletException {
        String query = request.getQueryString();
        String email = MailCache.getInstance().getMailData(query);
        if (null == email) {
            httpServletResponse.setStatus(404);
        } else {
            httpServletResponse.setStatus(200);
            httpServletResponse.getWriter().write(email);
        }
    }
}
