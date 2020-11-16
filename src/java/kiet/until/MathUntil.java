/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiet.until;

/**
 *
 * @author Admin
 */
public class MathUntil {

    // fake class math
    // Math.sqrt() .abs() .pow() .PI
    public static final double PI = 3.1415;

    // tính n! = 1.2.3.4....n
    //21! tràn long, âm giai thừa k tính đc, vô nghĩa
    // bài này tính gt trong khoảng 0..20
    public static long getFactorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("n must be between 0..20");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long re = 1;
        for (int i = 2; i <= n; i++) {
            re *= i;
        }
        return re;
    }
    // tự tin hàm đúng như thiết kế
    // không tin, test đã
    // có nhiều cách để test
    // kiểu gì cunugx phải là: mình tính đc trc kết quả hàm cần trả về EXPECTED VALUE
    //                         mình gọi hàm coi nó chạy ra mấy, ACTUAL VALUE
    // so sánh xem EXPECTED VALUE == ACTUAL VALUE hay không
//    có bằng, hàm chạy đúng cho tình huống x
//            không bằng, hàm chạy sai trong tình huống x
//                    ví dụ: tao nghĩ 5! là 120 (EXPECTED)
//                    giờ t gọi làm getFactorial(5 đưa vào), xem ra kq bao nhiêu (actual)
//                    nếu bằng 120 luôn, hàm đúng kì vọng
//                            case n = 5 đúng
//                            case n =6 trả về 720 đúng
//                    case n = 0 trả về 1 là đúng
//                    ..
//                    làm các case mà mình nghĩ là người dùng sẽ dùng
//                    gọi là các test case
//                    1 hàm có nhiều test case
//                    đảm bảo hàm đúng với các test case mới đc release

    public static void main(String[] args) {
        long expected = 120;
        long actual = MathUntil.getFactorial(5);
        // kì vọng 120, chạy thực tế ra gì sẽ đc lưu ở actual
        // so sánh bằng mắt
        System.out.println("5! ? expected:" + 120 + "; actual: " + MathUntil.getFactorial(5));
        System.out.println("6! ? expected:" + 720 + "; actual: " + MathUntil.getFactorial(6));
        System.out.println("0! ? expected:" + 1 + "  ; actual: " + MathUntil.getFactorial(0));
        
        // ném về ngoại lệ nếu đưa vào âm giai thừa
        // ko cần sout() vì chết khi gọi hàm rồi
        MathUntil.getFactorial(-1);
    }
}
// nhược điểm kĩ thuật này: 
// cần dùng mắt để so sánh từm TH xài hàm : expected và actual
// nếu test nhiều tình huống, mắt đủ mệt vì phait dò từng dòng output

// CÁCH NÂNG CAO
// gom cả đám test case chạy 1 lượt
// máy so giúp
//sau đó
//Nếu tất cả case đều đúng: thẩy ra 1 màu xanh- code ổn
// nếu tất cả các test case đều đúng, ngoại trừ 1 thằng nào đó
// expected khác actual, thẩy ra 1 màu đỏ, hàm ý code sai
// hàm đúng gần hết, mà sai 1 vài trường hợp, không tin cậy hàm đó
// chỉ cần ít nhất 1 cặp expected value bằng nhau, kết luận ngay hàm sai

// ta cần bộ thư viện giúp ta làm việc này
// bộ thư viện làm 2 việc: so sánh actual và expected
// khớp --> xanh
// không khớp: đỏ
// bộ thư viện này chính là những file .JAR .DLL đc add vào project
// bộ thư viện này mang tên chung cho mọi ngôn ngữ lập trình -Unit Test
// JAVA: JUnit, TestNG
// C# :  NUnit
// PHP: PHPUnit
// ....
// đưa code lêm server