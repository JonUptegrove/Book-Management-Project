package org.se4940project.library_manager.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.se4940project.library_manager.model.Member;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("loggedInUser");

        // Check if user is present and has ADMIN role
        if (member != null && "ADMIN".equals(member.getRole())) {
            return true; // Proceed to controller
        }

        // Redirect unauthorized users back to the book inventory
        response.sendRedirect("/books?unauthorized=true");
        return false;
    }
}
