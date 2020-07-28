package test;

import java.sql.SQLException;
import java.sql.SQLTransientException;

public class ExceptionEx1 {
	
	public static void main(String[] args) {
		A a = new B();
		try {
			a.method(); //SQLException처리를 해줘야 함
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}

class B implements A {

	@Override
	public void method() throws SQLTransientException { //method재정의시 A보다 하위클래스 익셉션만 발생시킬 수 있음
	}
	
	/*
	@Override
	public void method() throws Exception { //상위클래스 익셉션이므로 에러
	}
	*/
}

interface A {
	
	void method() throws SQLException;
	
}
