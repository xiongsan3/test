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

//        //��Ҫ����ͼƬ��·��
//       FileInputStream fis = new FileInputStream("C:/Users/С��û�г�/Desktop/heliu.jfif") ;
//    //�õ��ļ���С
//        int size = fis.available();
//        byte data[] = new byte[size] ;
//        fis.read(data) ;
//        fis.close();
//
//    //���÷��ص��ļ�����
//        response.setContentType("image/jpg");
//        OutputStream os = response.getOutputStream() ;
//        os.write(data);
//        os.flush();
//        os.close();
      Connection conn = null;
        PreparedStatement pstmt = null;
        String jilu=null,name="������",jilu2=null;
        ResultSet re = null;
        try {
            //ע������
            Class.forName("com.mysql.cj.jdbc.Driver");
            //��ȡ����
            String url = "jdbc:mysql://localhost:3306/management grade?serverTimezone=UTC&useSSL=false";
            conn = DriverManager.getConnection(url, "root", "123456");
            //׼��sql���
            String sql = "select codes,sname,jname FROM sc WHERE jname=? ";
            pstmt = ((Connection) conn).prepareStatement(sql);
            //��������
            pstmt.setString(1,name );
            //ִ��sql���
            re = pstmt.executeQuery();
            //��ȡ���ݿ�����
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
