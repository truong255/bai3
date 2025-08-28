package murach.email;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import murach.business.User;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        // Lấy dữ liệu từ form
        String firstName = request.getParameter("firstName");
        String lastName  = request.getParameter("lastName");
        String email     = request.getParameter("email");
        String dob       = request.getParameter("dob");

        String error = null;

        // ===== Kiểm tra ràng buộc =====
        if (firstName == null || firstName.trim().length() < 2) {
            error = "First name phải có ít nhất 2 ký tự.";
        } else if (lastName == null || lastName.trim().length() < 2) {
            error = "Last name phải có ít nhất 2 ký tự.";
        } else if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            error = "Email không hợp lệ.";
        } else if (dob == null || dob.isEmpty()) {
            error = "Ngày sinh không được để trống.";
        }

        if (error != null) {
            // Nếu có lỗi → quay lại form + hiển thị lỗi
            request.setAttribute("errorMessage", error);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return;
        }

        // ===== Nếu hợp lệ =====
        User user = new User(firstName, lastName, email, dob);
        request.setAttribute("user", user);

        // Forward sang trang cảm ơn
        String url = "/thanks.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
