import Util.BasicDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 李鑫
 * @version1.0
 */
@WebServlet("/sing")
public class SinIn extends HttpServlet {
    String user;
    String password;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        user = req.getParameter("username");
        password = req.getParameter("password");
        String remember = req.getParameter("remember");

        System.out.println(user);
        System.out.println(password);
        System.out.println(remember);

        if (this.chekUser(user, password)) {
            resp.setContentType("text/html; charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.write("<h1>登陆成功</h1>");
            if (remember.equals("1")){
                this.remember(user,password,resp);
            }
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            resp.sendRedirect("losin/brand_jsp.jsp");
        } else {
            resp.setContentType("text/html; charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.write(
                    "<h1>登录失败</h1>");
            resp.sendRedirect("losin/login.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }

    public boolean chekUser(String userid, String passed) {
        BasicDAO<User> userBasicDAO = new BasicDAO<>();
        User user = userBasicDAO.querySingle
                ("select * from user where userid=? and passed=?", User.class, userid, passed);
        System.out.println(user);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    public void remember(String userid , String password ,HttpServletResponse resp) {
        Cookie cookie = new Cookie("userid",userid);
        Cookie password1 = new Cookie("password", password);
        resp.addCookie(cookie);
        resp.addCookie(password1);
    }
}
