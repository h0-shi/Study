package dec27;
//23.12.27

// 자바와 DB 연동
// 데이터베이스 드라이버가 필요하다.
/*
 * localhost = 127.0.0.1
 * 
 * DB에 접속 할 때에는 
 * 경로 url, 아이디 user, 암호 pw 가 필요하다
 * 우리 경우에는 
 *  ulr : jdbc:mariadb://guro.wisejia.com:3307(port)/employees(db명)
 *  user : c23c_07
 * 	pw : ************
 * 
 * 	위 정보를 하나의 클래스에 적으면, 이 접속 정보를 그 클래스에서만 사용 가능
 *  => 따라서 접속 정보를 class로 저장해 다른곳에 임포트하자!
 *  = DBConnection
 *  
 *  데이터 접속 객체 = Data Access Object / DAO
 *  데이터 전송 객체 = Data Transfer Object / DTO(getter/setter)
 */
public class Study {

}
