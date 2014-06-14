
package jp.oracle.zoo.model;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jp.oracle.zoo.dao.EmployeeInsertCompleteDAO;

/**
 * 部門情報追加の完了ページ
 * /oracle-zoo/department_insert/completeのModel
 *
 * @author kiaamaaio
 */
public class DepartmentInsertCompleteModel implements ZooModelInterface {
    @Override
    public void doBusinessLogic(HttpServletRequest req, HttpServletResponse resp){
        
         resp.setContentType("text/html; charset=UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EmployeeInsertConfirmModel.class.getName()).log(Level.SEVERE, null, ex);
        }    
            
            
        try{
            
            
        /**
         *  GetParameter 項目読込み
         */
        
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

       /**
        * GetParameter値チェック sout 出力
        */ 
       
        System.out.println(sei + seifurigana + seienglish +  mei+ meifurigana + meienglish + seibetsu + year + month + day + zip_code + address + address_en + country_code + l_number + c_number);
 
        /**
         * insertDAO の実行
         */
             EmployeeInsertCompleteDAO eDAO = new EmployeeInsertCompleteDAO();
        String sql =  eDAO.InsertEmployee(sei,seifurigana,seienglish,mei,meifurigana,meienglish,seibetsu,year,month,day,zip_code,address,address_en,country_code,l_number, email, c_number);
        
        /**
         * SQLのsysout出力
         */
        
        System.out.println(sql);
        }catch(SQLException e){
        e.printStackTrace();
        }
    }
}
