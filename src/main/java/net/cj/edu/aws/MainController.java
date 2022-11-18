package net.cj.edu.aws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @restController를 사용한다.
// rest Controller와 일반 Controller의 차이는..
// rest Controller는 데이터 전송용이며, 페이지 이동을 위해선 Controller를 쓰면 된다.
// 일반 Controller는 a.jsp를 a.jsp로 리턴하고, rest jsp는 a.jsp를 "a.jsp"로 리턴하기 때문이다.

@RestController
public class MainController {

	@GetMapping("/")
	
	public String home() {
		return "<h1>Hi, aws-devops</h1>"; // 저장만 하면 재기동 됨. spring devtools를 설치해서그렇다
	}
	
	@GetMapping("/date")
	public String date() throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");

		String connurl = "jdbc:postgresql://aws-devops-db.cydmfksv8r5x.ap-northeast-2.rds.amazonaws.com:5432/postgres";
		String user = "postgres";
		String password = "12345678";
		String result = "NO_DATA";

		try (Connection connection = DriverManager.getConnection(connurl, user, password);) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT now() AS date");

			while (rs.next()) {
				result = rs.getString("date");
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
