
package jp.oracle.zoo.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jp.oracle.zoo.exception.EmptyStringException;
import jp.oracle.zoo.exception.LimitMaxCharacter;
import jp.oracle.zoo.exception.TypeNumberException;
import jp.oracle.zoo.util.InputValidation;

/**
 * 社員情報追加の入力ページ
 * /oracle-zoo/employee_insert/inputのModel
 *
 * @author kiaamaaio
 */



public class EmployeeInsertInputModel implements ZooModelInterface {
    
    public String messege = "";
    public String messege1 = "";
    public String messege2 = "";
    public String messege3 = "";
    public String messege4 = "";
    public String messege5 = "";
    public String messege6 = "";
    public String messege7 = "";
    public String messege8 = "";
    public String messege9 = "";
    public String messege10 = "";
    public String messege11 = "";
    public int confirmcheck = 0;

   
    
    private boolean isRedirect = false;
    
    public boolean getIsRedirect() {
        return isRedirect;
    }

    public void setIsRedirect(boolean isRedirect) {
        this.isRedirect = isRedirect;
    }
    
    /**
     * リダイレクトして、失敗したら例外を投げる
     * 
     * @param req
     * @param resp
     * @param path
     * @throws IOException 
     */
    private void pageRedirect(HttpServletRequest req, HttpServletResponse resp, String path) throws IOException{
        
        resp.sendRedirect(path);
    }

    
    @Override
    public void doBusinessLogic(HttpServletRequest req, HttpServletResponse resp){
    
            
          resp.setContentType("text/html; charset=UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EmployeeInsertConfirmModel.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        messegeInitialSet(req, resp);
        
        if(req.getParameter("confirm") != null){    
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
        
     try{   
            
            seimeiNullCheck(sei, mei, req, resp);
            seimeiFuriganaNullCheck(meifurigana, seifurigana, req, resp);
            zipcodeNullCheck(zip_code, req, resp);
            addressNullCheck(address, req, resp);
            countrycodeNullCheck(country_code, req, resp);
            countrycodeNumAndMaxCheck(country_code, req, resp);
            lnumberullCheck(l_number, req, resp);
            cnumberullCheck(c_number, req, resp);
            emailnullCheck(email, req, resp);
            if(confirmcheck != 1){
            confirmSetAttribute(sei, seifurigana, seienglish, mei, meifurigana, meienglish, seibetsu, year, month, day, zip_code, address, address_en, country_code, l_number, email, c_number, req, resp);
            }
            }catch(Exception e){
            e.printStackTrace();
     }
    }
        
    }
    
    public void seimeiNullCheck(String sei,String mei,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(sei);
            iv.checkEmptyString(mei);
        }catch(EmptyStringException e){
            messege = "<font size=\"2\" color=\"#ff0000\">氏名が入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("seimeiNullCheckmessege", messege);
        }
    }
    
    public void seimeiFuriganaNullCheck(String meifurigana,String seifurigana,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(meifurigana);
            iv.checkEmptyString(seifurigana);
        }catch(EmptyStringException e){
            messege1 = "<font size=\"2\" color=\"#ff0000\">氏名のふりがなが入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("seimeiFuriganaNullCheckmessege", messege1);
        }
    }
    
    
    
    public void zipcodeNullCheck(String zipcode,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(zipcode);
        }catch(EmptyStringException e){
            messege2 = "<font size=\"2\" color=\"#ff0000\">郵便番号が入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("zipcodeNullCheckmessege", messege2);
        }
    }
    
    public void addressNullCheck(String address,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(address);
        }catch(EmptyStringException e){
            messege3 = "<font size=\"2\" color=\"#ff0000\">住所が入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("addressNullCheckmessege", messege3);
        }
    }
    
    public void countrycodeNullCheck(String countrycode,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(countrycode);
        }catch(EmptyStringException e){
            messege4 = "<font size=\"2\" color=\"#ff0000\">住所が入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("countrycodeNullCheckmessege", messege4);
        }
    }
    
    public void lnumberullCheck(String lnumber,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(lnumber);
        }catch(EmptyStringException e){
            messege5 = "<font size=\"2\" color=\"#ff0000\">固定電話が入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("lnumberullCheckmessege", messege5);
        }
    }
    
    public void cnumberullCheck(String cnumber,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(cnumber);
        }catch(EmptyStringException e){
            messege6 = "<font size=\"2\" color=\"#ff0000\">携帯電話が入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("cnumberullCheckmessege", messege6);
        }
    }
    
    public void emailnullCheck(String email,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkEmptyString(email);
        }catch(EmptyStringException e){
            messege7 = "<font size=\"2\" color=\"#ff0000\">メールアドレスが入力されていません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("emailnullCheckmessege", messege7);
        }
    }
    
    public void messegeInitialSet(HttpServletRequest req, HttpServletResponse resp){
        req.setAttribute("seimeiNullCheckmessege", messege);
        req.setAttribute("seimeiFuriganaNullCheckmessege", messege1);
        req.setAttribute("zipcodeNullCheckmessege", messege2);
        req.setAttribute("addressNullCheckmessege", messege3);
        req.setAttribute("countrycodeNullCheckmessege", messege4);
        req.setAttribute("lnumberullCheckmessege", messege5);
        req.setAttribute("cnumberullCheckmessege", messege6);
        req.setAttribute("emailnullCheckmessege", messege7);
        req.setAttribute("countrycodeNumCheckmessege", messege8);
        req.setAttribute("countrycodeMaxCheckmessege", messege9);
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
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/employee_insert/employee_confirm.jsp");
	rd.forward(req, resp);
        }catch(ServletException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void countrycodeNumAndMaxCheck(String countrycode,HttpServletRequest req, HttpServletResponse resp){
        try{
            InputValidation iv = new InputValidation();
            iv.checkTypeNumber(countrycode);
            iv.checkLimitMaxCharacter(countrycode, 6);
        }catch(TypeNumberException e){
            messege8 = "<font size=\"2\" color=\"#ff0000\">数値ではありません。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("countrycodeNumCheckmessege", messege8);
        }catch(LimitMaxCharacter e){
            messege9 = "<font size=\"2\" color=\"#ff0000\">入力した数値が5桁を超えています。</font><br/>";
            confirmcheck = 1;
            req.setAttribute("countrycodeMaxCheckmessege", messege9);
        }
    }
    
    
}