package servlet;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// @WebServletの引数は，どのURLでこのServletが起動するかを示している．
@WebServlet("/index")
// HttpServletを継承することで、このクラスはServletとして、働くことができる
public class Index extends HttpServlet {

  private static final long serialVersionUID = 1L;
  //doGetはブラウザからのGETリクエストがあった場合に実行される．
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // requestオブジェクトの文字エンコーディングの設定
    request.setCharacterEncoding("UTF-8");
    // RequestDispatcherで遷移先の情報を定義している．
    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    dispatcher.forward(request, response);
  }
  //doPostはブラウザからのPOSTリクエストがあった場合に実行される．
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // requestオブジェクトの文字エンコーディングの設定
    request.setCharacterEncoding("UTF-8");
  }
}
