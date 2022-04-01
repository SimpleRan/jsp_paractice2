package com.ict.jdbc;

import java.util.Scanner;

public class JDBCDelete {

	public static void main(String[] args) {
		// Scanner로 삭제할 아이디를 입력받으면
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 아이디를 입력해주세요.");
		String id = scan.nextLine();
		// DB에 삭제용 쿼리문을 날려주는 로직을 작성해주세요
		
		// 삭제되었는지 SELECT 코드나 혹은 Workbench를 이용해 확인해주세요.
		
		// 사용 쿼리문 : DELETE FROM userinfo WHERE user_id='아이디'
	}
}
