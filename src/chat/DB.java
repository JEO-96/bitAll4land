package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	public static Connection conn;
    public static Statement stmt;

    // DB 연결
    public static void init() {

       try {

          Class.forName("org.postgresql.Driver");

          conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

          stmt = conn.createStatement();
          
//          System.out.println("접속완료");
       } catch (ClassNotFoundException e) {
          System.out.println("해당 드라이버가 없습니다.");
          e.printStackTrace();
       } catch (SQLException e) {
          System.out.println("접속 오류 / SQL 오류");
          e.printStackTrace();
       }
    }

    // 조회
    public static ResultSet getResultSet(String sql) {
       try {
          return stmt.executeQuery(sql);
    
       }catch(Exception e){
          System.out.println(e);   //오류 메시지
          
          return null;
       }
    }
    
    // 삽입, 수정, 삭제 
    public static void executeUpdate(String sql) {
       try {
          stmt.executeUpdate(sql);
       } catch (SQLException e) {
          e.printStackTrace();
       }
    }
    
 // 테이블 생성
    public static void createTable() {
       
       // 사용자 테이블 생성
       String str = "CREATE TABLE users ("
             + "   user_id varchar(20) NOT NULL,"
             + "   nickname varchar(30) NOT NULL,"
             + "   pw varchar(20) NOT NULL,"
             + "   kick_count int4 NOT NULL DEFAULT 0,"
             + "   last_login timestamp NULL DEFAULT current_timestamp,"
             + "   CONSTRAINT user_pk PRIMARY KEY (user_id) "
             + ")";
       executeUpdate(str);

       // 채팅 내역 테이블 생성
       str ="CREATE TABLE chat_log ("
             + "   chat_id serial NOT NULL,"
             + "   user_id varchar(20) NOT NULL,"
             + "   chat_msg text NOT NULL,"
             + "   chat_time timestamp NOT NULL,"
             + "   receive_id varchar(20) NULL,"
             + "   CONSTRAINT chat_log_pk PRIMARY KEY (chat_id),"
             + "   CONSTRAINT chat_log_fk FOREIGN KEY (user_id) REFERENCES public.users(user_id) "
             + ")";
       executeUpdate(str);
       
       // 공지사항 테이블 생성
       str ="CREATE TABLE \"notice\" ("
             + "   notice_id serial4 NOT NULL,"
             + "   user_id varchar(20) NOT NULL,"
             + "   notice_msg text NOT NULL,"
             + "   CONSTRAINT notice_pk PRIMARY KEY (notice_id),"
             + "   CONSTRAINT notice_fk FOREIGN KEY (user_id) REFERENCES public.users(user_id) "
             + ")";
       executeUpdate(str);
       
       // 이모티콘 테이블 생성
       str ="CREATE TABLE emoji ("
             + "   emoji_id serial4 NOT NULL,"
             + "   emoji_text varchar(30) NOT NULL,"
             + "   CONSTRAINT emoji_pk PRIMARY KEY (emoji_id) "
             + ");";
       executeUpdate(str);
       
       str ="INSERT INTO emoji (emoji_text) VALUES"
             + " ('😀'),"
             + " ('😎'),"
             + " ('☺'),"
             + "   ('😴'),"
             + "   ('😭'),"
             + " ('(❁´◡`❁)'),"
             + " ('╰(*°▽°*)╯'),"
             + " ('(☞ﾟヮﾟ)☞'),"
             + " ('╰(ツ)_/¯'),"
             + " ('(T_T)'),"
             + " ('😶'),"
             + " ('^_^')";
       executeUpdate(str);
    }
    public static void main(String[] args) {
    	init();
    	createTable();
	}
}
