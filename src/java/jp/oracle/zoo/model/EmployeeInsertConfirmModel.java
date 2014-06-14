
package jp.oracle.zoo.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 社員情報編集の入力ページ
 * /oracle-zoo/employee_insert-/confirmのModel
 *
 * @author kiaamaaio
 */
public class EmployeeInsertConfirmModel implements ZooModelInterface {
    
    
    /**
     * メッセージ変数初期化
     */
        
    
    public void doBusinessLogic(HttpServletRequest req, HttpServletResponse resp){
        
          resp.setContentType("text/html; charset=UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EmployeeInsertConfirmModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String sei = req.getParameter("sei");
        String seifurigana = req.getParameter("seifurigana");
        String seienglish = req.getParameter("seienglish");
        String mei = req.getParameter("mei");
        String meifurigana = req.getParameter("meifurigana");
        String meienglish = req.getParameter("meienglish");
        String seibetsu = req.getParameter("seibetsu");
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String day = req.getParameter("day");
        String zip_code = req.getParameter("zip_code");
        String address = req.getParameter("address");
        String address_en = req.getParameter("address_en");
        String country_code = req.getParameter("country_code");
        String l_number = req.getParameter("l_number");
        String email = req.getParameter("email");
        String c_number = req.getParameter("c_number");
        confirmSetAttribute(sei, seifurigana, seienglish, mei, meifurigana, meienglish, seibetsu, year, month, day, zip_code, address, address_en, country_code, l_number, email, c_number, req, resp);
        
    }
    
    
    public void confirmSetAttribute(String sei,String seifurigana,String seienglish,String mei,String meifurigana,String meienglish, String seibetsu, String year, String month,String day, String zip_code,String address,String address_en,String country_code,String l_number,String email,String c_number,HttpServletRequest req, HttpServletResponse resp){
        
        
        try{
        req.setAttribute("sei", sei);
        req.setAttribute("seifurigana",seifurigana);
        req.setAttribute("seienglish", seienglish);
        req.setAttribute("mei", mei);
        req.setAttribute("meifurigana", meifurigana);
        req.setAttribute("meienglish", meienglish);
        req.setAttribute("seibetsu", seibetsu);
        req.setAttribute("year", year);
        req.setAttribute("month", month);
        req.setAttribute("day", day);
        req.setAttribute("zip_code",zip_code);
        req.setAttribute("address", address);
        req.setAttribute("address_en", address_en);
        req.setAttribute("country_code", country_code);
        req.setAttribute("l_number", l_number);
        req.setAttribute("email", email);
        req.setAttribute("c_number", c_number);
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/employee_insert/employee_complete.jsp");
	rd.forward(req, resp);
        }catch(ServletException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
