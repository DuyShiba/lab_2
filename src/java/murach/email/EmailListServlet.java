package murach.email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmailListServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set request encoding to handle Vietnamese characters
        request.setCharacterEncoding("UTF-8");
        
        // Get parameters from the form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String heardFrom = request.getParameter("heardFrom");
        String wantsUpdates = request.getParameter("wantsUpdates");
        String emailOK = request.getParameter("emailOK");
        String contactVia = request.getParameter("contactVia");
        
        // Set response content type with UTF-8 encoding
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        // Generate response HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Survey Results</title>");
        out.println("<link rel='stylesheet' href='styles/survey.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Cảm ơn bạn đã gửi thông tin!</h1>");
        out.println("<h2>Thông tin bạn đã gửi:</h2>");
        out.println("<p><strong>Họ tên:</strong> " + firstName + " " + lastName + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        if (dateOfBirth != null && !dateOfBirth.isEmpty()) {
            out.println("<p><strong>Ngày sinh:</strong> " + dateOfBirth + "</p>");
        }
        out.println("<p><strong>Bạn biết đến chúng tôi qua:</strong> " + heardFrom + "</p>");
        out.println("<p><strong>Muốn nhận thông tin cập nhật:</strong> " + (wantsUpdates != null ? "Có" : "Không") + "</p>");
        out.println("<p><strong>Đồng ý nhận email thông báo:</strong> " + (emailOK != null ? "Có" : "Không") + "</p>");
        out.println("<p><strong>Liên hệ qua:</strong> " + contactVia + "</p>");
        out.println("<p><a href='index.html'>Làm khảo sát lại</a></p>");
        out.println("</body>");
        out.println("</html>");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect GET requests to the survey form
        response.sendRedirect("index.html");
    }
}