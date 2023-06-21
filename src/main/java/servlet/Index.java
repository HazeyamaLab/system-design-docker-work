package servlet;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import model.Sample;
import service.SampleService;

@WebServlet("/index")
// HttpServletを継承することで、このクラスはServletとして、働くことができる
public class Index extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // requestオブジェクトの文字エンコーディングの設定
    request.setCharacterEncoding("UTF-8");
    // request.setAttribute("",);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    dispatcher.forward(request, response);
  }
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
        // requestオブジェクトから登録情報の取り出し
        String hello = request.getParameter("hello");
        System.out.println("取得した文字列は" + hello + "です！");
        response.sendRedirect("/system-design-dev/index");
  }
}
