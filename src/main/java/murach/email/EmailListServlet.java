package murach.email;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import murach.business.User;

public class EmailListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Lấy dữ liệu từ form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");

        // Tạo đối tượng User
        User user = new User(firstName, lastName, email, dob);

        // Lưu user vào request để JSP lấy ra hiển thị
        request.setAttribute("user", user);

        // Forward sang thanks.jsp
        String url = "/thanks.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
