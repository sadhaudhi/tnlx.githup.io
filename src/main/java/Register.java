import Util.BasicDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 李鑫
 * @version1.0
 */
@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vcode = req.getParameter("Vcode");
        HttpSession session = req.getSession();
        Object vcode1 = session.getAttribute("code");
        if (!vcode1.equals(vcode)) {
            System.out.println("验证码错误");
            req.setAttribute("register_msg","验证码错误");
            req.getRequestDispatcher("/losin/register.jsp").forward(req,resp);
        } else {

            String username = req.getParameter("username");
            String password = req.getParameter("password");
            boolean b = this.newUser(username, password);
            if (b) {
                resp.setHeader("text/html", "charset=utf-8");
                PrintWriter writer = resp.getWriter();
                writer.write("</th>创捷成功</th>");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                resp.sendRedirect("/SinIn/losin/login.jsp");
            } else {
                resp.setHeader("text/html", "charset=utf-8");
                PrintWriter writer = resp.getWriter();
                writer.write("</th>创建失败</th>");
                resp.sendRedirect("/SinIn/losin/register.jsp");

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    public boolean newUser(String userid, String passed) {
        String user_= "^\\d{3,9}$";
        String pas = "^(\\w{6,16})$";
        boolean matches = userid.matches(user_);
        boolean matches1 = passed.matches(pas);
        if (matches1 && matches) {
            // 查用户是否存在
            BasicDAO<User> userBasicDAO = new BasicDAO<>();
            User user = userBasicDAO.querySingle("select * from  user where userid = ?", User.class, userid);

            if (user != null) {
                return false;
            } else {
                // 创建用户
                userBasicDAO.update("insert into user values(?,?)", userid, passed);
                return true;
            }
        }else {
            return false;
    }
}

}
