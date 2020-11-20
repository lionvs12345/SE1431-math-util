/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiet.until.test;

import java.sql.SQLException;
import static kiet.until.MathUntil.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class MathUtilityTest {

    // class này là class dùng bộ thư viện để test code theo dạng xanh đỏ thay vì dùng bằng mắt như bên main() sout()
    // 2 file .JAR đã đc add vào project này, và ta thoải mái dùng các hàm của nó
    // trong các hàm của thư viện này có n hàm đặc biệt đều có tên xuất phát là assertX(expected va actual đc đưa vào)
    // nếu nó nó thấy expected != actual, màu đỏ
    //                         ==       , màu xanh
    // ĐẢM BẢO HÀM CHẠY ĐÚNG MỌI CASE
    @Test // biến hàm ngay sau đây thành main()
    // muốn chạy thì nhấn shift + F6
    public void getFactorial_RunsWell_IfValidArgument() {
        assertEquals(120, getFactorial(5));
        assertEquals(720, getFactorial(6));
        assertEquals(24, getFactorial(4));
        assertEquals(1, getFactorial(0));
    }
    
//    @Test(expected = SQLException.class)
    @Test(expected = IllegalArgumentException.class)
    public void getFactorial_ThrowsException_IfInvalidArgument() {
        // ngoại lệ k phải là value để assert()
        getFactorial(-3);
    }
}
