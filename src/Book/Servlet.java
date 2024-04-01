package Book;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
       response.setContentType("text/html;charset =utf-8");

//        //想要返回图片的路径
//       FileInputStream fis = new FileInputStream("C:/Users/小鹏没有翅/Desktop/heliu.jfif") ;
//    //得到文件大小
//        int size = fis.available();
//        byte data[] = new byte[size] ;
//        fis.read(data) ;
//        fis.close();
//
//    //设置返回的文件类型
//        response.setContentType("image/jpg");
//        OutputStream os = response.getOutputStream() ;
//        os.write(data);
//        os.flush();
//        os.close();
      Connection conn = null;
        PreparedStatement pstmt = null;
        String jilu=null,name="贾坤鹏",jilu2=null;
        ResultSet re = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/management grade?serverTimezone=UTC&useSSL=false";
            conn = DriverManager.getConnection(url, "root", "123456");
            //准备sql语句
            String sql = "select codes,sname,jname FROM sc WHERE jname=? ";
            pstmt = ((Connection) conn).prepareStatement(sql);
            //填入数据
            pstmt.setString(1,name );
            //执行sql语句
            re = pstmt.executeQuery();
            //读取数据库内容
            while (re.next()) {
                //jilu2=" ";
                jilu=re.getString(1) + '\t';
                jilu=jilu+re.getString(2) + '\t'+'\t';
                jilu=jilu+re.getString(3) + '\t';
                jilu=jilu+ '\n';
                jilu2=jilu2+jilu;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        response.getWriter().print(jilu2);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
